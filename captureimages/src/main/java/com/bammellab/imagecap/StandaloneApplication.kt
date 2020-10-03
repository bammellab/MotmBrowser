package com.bammellab.imagecap

import android.app.Application
import android.content.Context
import timber.log.Timber

class StandaloneApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
