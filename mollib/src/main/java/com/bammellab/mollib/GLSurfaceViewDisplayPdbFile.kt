/*
 * Copyright (C) 2016-2018 James Andreas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

@file:Suppress("unused", "unused_variable", "unused_parameter", "deprecation")
package com.bammellab.mollib

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.PointF
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Scroller
import kotlin.math.atan2
import kotlin.math.sqrt

@Suppress("ConstantConditionIf")
class GLSurfaceViewDisplayPdbFile : GLSurfaceView {
    var mSelectMode = false
    private var mLastTouchState = NO_FINGER_DOWN

    private var mRenderer: RendererDisplayPdbFile? = null

    private var mScroller: Scroller? = null
    private var mGestureDetector: GestureDetector? = null
    private var mContext: Context? = null

    // Offsets for touch events
    private var mPreviousX: Float = 0.toFloat()
    private var mPreviousY: Float = 0.toFloat()
    private var mDensity: Float = 0.toFloat()
    private var mInitialSpacing: Float = 0.toFloat()

    private var mOldX = 0f
    private var mOldY = 0f

    private val isAnimationRunning: Boolean
        get() = !mScroller!!.isFinished

    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    private fun init(context: Context) {

        mContext = context
        mScroller = Scroller(context, null, true)

        // The scroller doesn't have any built-in animation functions--it just supplies
        // values when we ask it to. So we have to have a way to call it every frame
        // until the fling ends. This code (ab)uses a ValueAnimator object to generate
        // a callback on every animation frame. We don't use the animated value at all.

        val mScrollAnimator = ValueAnimator.ofFloat(0f, 1f)
        mScrollAnimator.addUpdateListener {
            // tickScrollAnimation();
        }


        // Create a gesture detector to handle onTouch messages
        mGestureDetector = GestureDetector(context, GestureListener())

        // Turn off long press--this control doesn't use it, and if long press is enabled,
        // you can't scroll for a bit, pause, then scroll some more (the pause is interpreted
        // as a long press, apparently)
        mGestureDetector!!.setIsLongpressEnabled(false)
    }

    // with h/t to :

    // http://stackoverflow.com/questions/14818530/how-to-implement-a-two-finger-drag-gesture-on-android
    // and:
    // http://judepereira.com/blog/multi-touch-in-android-translate-scale-and-rotate/

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(m: MotionEvent?): Boolean {
        val x1: Float
        val x2: Float
        val y1: Float
        val y2: Float
        var deltax: Float
        var deltay: Float
        var deltaSpacing: Float

        // hand the event to the GestureDetector
        // ignore the result for now.
        // TODO:  hook up fling logic
        val result = mGestureDetector!!.onTouchEvent(m)

        if (m == null) {
            return true
        }
        if (hack) renderMode = RENDERMODE_CONTINUOUSLY


        //Number of touches
        val pointerCount = m.pointerCount
        when {
            pointerCount > 2 -> {
                mLastTouchState = MORE_FINGERS
                return true
            }
            pointerCount == 2 -> {
                if (mSelectMode) return true
                val action = m.actionMasked
                val actionIndex = m.actionIndex
                if (mLastTouchState == MORE_FINGERS) {
                    x1 = m.getX(0)
                    y1 = m.getY(0)
                    x2 = m.getX(1)
                    y2 = m.getY(1)

                    mRenderer!!.touchX = m.x
                    mRenderer!!.touchY = m.y

                    mOldX = (x1 + x2) / 2.0f
                    mOldY = (y1 + y2) / 2.0f
                    mLastTouchState = TWO_FINGERS_DOWN
                    return true
                }
                when (action) {
                    MotionEvent.ACTION_MOVE -> {

                        x1 = m.getX(0)
                        y1 = m.getY(0)
                        x2 = m.getX(1)
                        y2 = m.getY(1)

                        mRenderer!!.touchX = m.x
                        mRenderer!!.touchY = m.y

                        deltax = (x1 + x2) / 2.0f
                        deltax -= mOldX
                        deltay = (y1 + y2) / 2.0f
                        deltay -= mOldY

                        mRenderer!!.deltaTranslateX = mRenderer!!.deltaTranslateX + deltax / (mDensity * 300f)
                        mRenderer!!.deltaTranslateY = mRenderer!!.deltaTranslateY - deltay / (mDensity * 300f)

                        mOldX = (x1 + x2) / 2.0f
                        mOldY = (y1 + y2) / 2.0f

                        val mCurrentSpacing = spacing(m)

                        if (mLastTouchState != TWO_FINGERS_DOWN) {
                            mInitialSpacing = spacing(m)
                        } else {
                            deltaSpacing = mCurrentSpacing - mInitialSpacing
                            deltaSpacing /= mInitialSpacing


                            // TODO: adjust this exponent.
                            //   for now, hack into buckets
                            if (mRenderer!!.scaleCurrentF < 0.1f) {
                                mRenderer!!.scaleCurrentF = mRenderer!!.scaleCurrentF + -deltaSpacing / 1000f
                            } else if (mRenderer!!.scaleCurrentF < 0.1f) {
                                mRenderer!!.scaleCurrentF = mRenderer!!.scaleCurrentF + -deltaSpacing / 500f
                            } else if (mRenderer!!.scaleCurrentF < 0.5f) {
                                mRenderer!!.scaleCurrentF = mRenderer!!.scaleCurrentF + -deltaSpacing / 200f
                            } else if (mRenderer!!.scaleCurrentF < 1f) {
                                mRenderer!!.scaleCurrentF = mRenderer!!.scaleCurrentF + -deltaSpacing / 50f
                            } else if (mRenderer!!.scaleCurrentF < 2f) {
                                mRenderer!!.scaleCurrentF = mRenderer!!.scaleCurrentF + -deltaSpacing / 10f
                            } else if (mRenderer!!.scaleCurrentF < 5f) {
                                mRenderer!!.scaleCurrentF = mRenderer!!.scaleCurrentF + -deltaSpacing / 10f
                            } else if (mRenderer!!.scaleCurrentF > 5f) {
                                if (deltaSpacing > 0) {
                                    mRenderer!!.scaleCurrentF = mRenderer!!.scaleCurrentF + -deltaSpacing / 10f
                                }
                            }
                            //                        Log.w("Move", "Spacing is " + mRenderer.mScaleCurrentF + " spacing = " + deltaSpacing);


                        }
                    }
                    MotionEvent.ACTION_POINTER_DOWN -> {
                        // Log.w("touch POINTER DOWN", "");

                        x1 = m.getX(0)
                        y1 = m.getY(0)
                        x2 = m.getX(1)
                        y2 = m.getY(1)

                        mRenderer!!.touchX = m.x
                        mRenderer!!.touchY = m.y

                        mOldX = (x1 + x2) / 2.0f
                        mOldY = (y1 + y2) / 2.0f
                        mInitialSpacing = spacing(m)
                    }
                    MotionEvent.ACTION_POINTER_UP -> if (hack) renderMode = RENDERMODE_WHEN_DIRTY
                }// Log.w("Down", "touch DOWN, mInitialSpacing is " + mInitialSpacing);
                mLastTouchState = TWO_FINGERS_DOWN
                return true
            }
            pointerCount == 1 -> {
                /*
             * handle single finger swipe - rotate each item
             */
                val x = m.x
                val y = m.y

                mRenderer!!.touchX = m.x
                mRenderer!!.touchY = m.y

                if (m.action == MotionEvent.ACTION_MOVE) {
                    if (mLastTouchState != ONE_FINGER_DOWN) {  // handle anything to one finger interaction
                        mLastTouchState = ONE_FINGER_DOWN
                    } else if (mRenderer != null) {
                        val deltaX = (x - mPreviousX) / mDensity / 2f
                        val deltaY = (y - mPreviousY) / mDensity / 2f

                        mRenderer!!.deltaX = mRenderer!!.deltaX + deltaX
                        mRenderer!!.deltaY = mRenderer!!.deltaY + deltaY
                        // Log.w("touch", ": mDX = " + mRenderer.mDeltaX + " mDY = " + mRenderer.mDeltaY);
                    }
                }
                mPreviousX = x
                mPreviousY = y

                return true
            }
            hack -> renderMode = RENDERMODE_WHEN_DIRTY
        }

        return super.onTouchEvent(m)
    }

    /**
     * Determine the space between the first two fingers
     */
    private fun spacing(event: MotionEvent): Float {
        val x = event.getX(0) - event.getX(1)
        val y = event.getY(0) - event.getY(1)
        return sqrt((x * x + y * y).toDouble()).toFloat()
    }

    /**
     * Calculate the mid point of the first two fingers
     */
    private fun midPoint(point: PointF, event: MotionEvent) {
        val x = event.getX(0) + event.getX(1)
        val y = event.getY(0) + event.getY(1)
        point.set(x / 2, y / 2)
    }

    /*
     * Calculate the degree to be rotated by.
     */
    private fun rotation(event: MotionEvent): Float {
        val deltaX = (event.getX(0) - event.getX(1)).toDouble()
        val deltaY = (event.getY(0) - event.getY(1)).toDouble()
        val radians = atan2(deltaY, deltaX)
        return Math.toDegrees(radians).toFloat()
    }

    // Hides superclass method.
    fun setRenderer(renderer: RendererDisplayPdbFile, density: Float) {
        mRenderer = renderer
        mDensity = density
        super.setRenderer(renderer)
    }

    /**
     * Extends [GestureDetector.SimpleOnGestureListener] to provide custom gesture
     * processing.
     */
    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onScroll(e1: MotionEvent, e2: MotionEvent, distanceX: Float, distanceY: Float): Boolean {

            // Timber.w("onScroll");
            return true
        }

        // not implemented - probably a bad idea
        //   might be good to average out the pivot to help with jitter
        override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {

            // Timber.w("onFling");
            //            // Set up the Scroller for a fling
            //            float scrollTheta = vectorToScalarScroll(
            //                    velocityX,
            //                    velocityY,
            //                    e2.getX() - mPieBounds.centerX(),
            //                    e2.getY() - mPieBounds.centerY());
            //            mScroller.fling(
            //                    0,
            //                    (int) getPieRotation(),
            //                    0,
            //                    (int) scrollTheta / FLING_VELOCITY_DOWNSCALE,
            //                    0,
            //                    0,
            //                    Integer.MIN_VALUE,
            //                    Integer.MAX_VALUE);
            //
            //            // Start the animator and tell it to animate for the expected duration of the fling.
            //            if (Build.VERSION.SDK_INT >= 11) {
            //                mScrollAnimator.setDuration(mScroller.getDuration());
            //                mScrollAnimator.start();
            //            }
            return true
        }

        override fun onDown(e: MotionEvent): Boolean {

            if (isAnimationRunning) {
                stopScrolling()
            }
            return true
        }
    }

    /**
     * Force a stop to all pie motion. Called when the user taps during a fling.
     */
    private fun stopScrolling() {
        mScroller!!.forceFinished(true)

        onScrollFinished()
    }

    /**
     * Called when the user finishes a scroll action.
     */
    private fun onScrollFinished() {

    }

    companion object {

        private const val NO_FINGER_DOWN = 0
        private const val ONE_FINGER_DOWN = 1
        private const val TWO_FINGERS_DOWN = 2
        private const val MORE_FINGERS = 3

        private const val hack = true   // play with Rendermode
    }
}