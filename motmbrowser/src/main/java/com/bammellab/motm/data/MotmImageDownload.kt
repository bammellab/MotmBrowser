/*
 *  Copyright 2020 James Andreas
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *       http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.bammellab.motm.data

object MotmImageDownload {

    /**
     * Find the TIF file corresponding to the MOTM number.
     * Just return the first TIF following the number for now.
     * TODO: cycle through the TIF files in the detail dialog...
     */
    fun getFirstTiffImageURL(motmNumber: Int): String {
        val match = imageList.indexOfFirst { e ->
            e == motmNumber.toString()
        }
        if (match == -1) {
            return ""
        }
        if (match + 1 > imageList.size - 1) {
            return ""
        }
        return imageList[match + 1]

    }

    private val imageList = listOf(

            "250",
            "250-Capsaicin_Receptor_TRPV1-5is0_composite",
            "250-Capsaicin_Receptor_TRPV1-6dmw",
            "249",
            "249-SARSCoV2_RNAdependent_RNA_Polymerase-6yyt_label",
            "249-SARSCoV2_RNAdependent_RNA_Polymerase-2ahm_2",
            "248",
            "248-Phytosulfokine_Receptor-4z64_Figure",
            "248-Phytosulfokine_Receptor-4mn8_4lsx",
            "247",
            "247-Myelinassociated_Glycoprotein-Myelin",
            "247-Myelinassociated_Glycoprotein-1pkq_1bx2",
            "246",
            "246-SARSCoV2_Spike-6crz_6vxx3",
            "246-Coronavirus_Spike-6vsb_6m17_2",
            "245",
            "245-Spliceosomes-3jb9",
            "245-Spliceosomes-6n7p",
            "245-Spliceosomes-1mh1_1ryf",
            "244",
            "244-Photosynthetic_Supercomplexes-5xnl",
            "244-Photosynthetic_Supercomplexes-6kad_6kac",
            "244-Photosynthetic_Supercomplexes-5zji_6nwa",
            "243",
            "242-Voltagegated_Sodium_Channels-6j8j_twoview",
            "242-Voltagegated_Sodium_Channels-6a95_green",
            "242",
            "243-Coronavirus_Proteases-6lu7",
            "243-Coronavirus_Proteases-1q2w_4ow0",
            "241",
            "241-Twenty_Years_of_Molecules-6j4y",
            "241-Twenty_Years_of_Molecules-records",
            "241-Twenty_Years_of_Molecules-2or1",
            "241-Twenty_Years_of_Molecules-6mam",
            "241-Twenty_Years_of_Molecules-6by7",
            "241-Twenty_Years_of_Molecules-CyclicBeauty",
            "240",
            "240-HypoxiaInducible_Factors-1lqb_composite",
            "240-HypoxiaInducible_Factors-4zpr",
            "239",
            "239-Phospholipase_A2-1bp2",
            "239-Phospholipase_A2-1bp2_1cjy",
            "238",
            "238-Ribonucleotide_Reductase-1mrr_3r1r",
            "238-Ribonucleotide_Reductase-3uus",
            "237",
            "237-Nanodiscs_and_HDL-4v6m",
            "237-Nanodiscs_and_HDL-6clz",
            "236",
            "236-Cyclin_and_Cyclindependent_Kinase-1fin",
            "236-Cyclin_and_Cyclindependent_Kinase-CDKinhibitors",
            "235",
            "235-AMPA_Receptor-3kg2_composite",
            "235-AMPA_Receptor-iGluR",
            "234",
            "234-MDM2_and_Cancer-MDM2_painting",
            "234-MDM2_and_Cancer-MDM2",
            "233",
            "233-SNitrosylated_Hemoglobin-1buw",
            "233-SNitrosylated_Hemoglobin-2ifq",
            "232",
            "231-Proteins_and_Biominerals-1q8h_4uxm",
            "231-Proteins_and_Biominerals-4jj0",
            "231",
            "231-Measles_Virus_Proteins-measles",
            "232-Measles_Virus_Proteins-4uft",
            "230",
            "230-Initiation_Factor_eIF4E-1ap8_1rf8",
            "230-Initiation_Factor_eIF4E-complexes",
            "229",
            "229-Fluorescent_RNA_AptamersSpinach_fluorescent_aptamer_with_RNA_in_light_orange_and_fluorophore_in_green-4kzd",
            "229-Fluorescent_RNA_AptamersSpinach_fluorescent_aptamer_with_RNA_in_light_orange_and_fluorophore_in_green-fluorescent_aptamers",
            "228",
            "228-Directed_Evolution_of_Enzymes-5ucw",
            "228-Directed_Evolution_of_Enzymes-3wwj",
            "228-Directed_Evolution_of_Enzymes-1wdw_6am8",
            "227",
            "227-Telomerase-6d6v",
            "227-Telomerase-143d",
            "226",
            "226-Aminoglycoside_Antibiotics_and_Resistance-1fjg",
            "226-Aminoglycoside_Antibiotics_and_Resistance-4ox9",
            "225",
            "225-Phytase-1dkq_phyticacid",
            "225-Phytase-phytases",
            "224",
            "224-Legumain-4awb",
            "224-Legumain-legumains",
            "223",
            "223-Piezo1_Mechanosensitive_Channel-6b3r",
            "223-Piezo1_Mechanosensitive_Channel-3um7_5vkq",
            "222",
            "221-Proteins_and_Nanoparticles-5et3_motm",
            "221-Proteins_and_Nanoparticles-4prq",
            "221-Proteins_and_Nanoparticles-5oeh_3nkx",
            "221",
            "222-Human_Papillomavirus_and_Vaccines-3j6r-6bt3",
            "222-Human_Papillomavirus_and_Vaccines-4xr8",
            "220",
            "220-Dehalogenases-4ur0",
            "220-Dehalogenases-dehalogenases",
            "219",
            "219-Vacuolar_ATPase-5vox",
            "219-Vacuolar_ATPase-ATPases",
            "218",
            "218-EPSP_Synthase_and_Weedkillers-2gg4_2gga",
            "218-EPSP_Synthase_and_Weedkillers-2p1n",
            "217",
            "217-Opioid_Receptors-4dkl",
            "217-Opioid_Receptors-3fvy_5ee3",
            "216",
            "216-Biodegradable_Plastic-5t6o_composite",
            "216-Biodegradable_Plastic-4o9c_3vzs",
            "215",
            "215-Aspartate_Transcarbamoylase-5at1",
            "215-Aspartate_Transcarbamoylase-CAD",
            "214",
            "214-Chimeric_Antigen_Receptors-CAR",
            "214-Chimeric_Antigen_Receptors-CART_2017",
            "213",
            "213-Sirtuins-4iao",
            "213-Sirtuins-5btr_5mf6",
            "212",
            "212-Glutathione_Transferases-3gss",
            "212-Glutathione_Transferases-3zml_3zmk",
            "211",
            "211-Pilus_Machine-3jc8",
            "211-Pilus_Machine-3jc8_action",
            "210",
            "210-Adenine_Riboswitch_in_Action-5e54_5swe",
            "210-Adenine_Riboswitch_in_Action-5e54_5swe_lattice",
            "209",
            "209-Tissue_Transglutaminase_and_Celiac_Disease-2q3z_3ly6",
            "209-Tissue_Transglutaminase_and_Celiac_Disease-1s9v_5ks9",
            "208",
            "208-Glucose_Transporters-4pyp_4zwc",
            "208-Glucose_Transporters-1pv6_1pw4",
            "207",
            "207-Photoactive_Yellow_Protein-2pyp",
            "207-Photoactive_Yellow_Protein-2zoi",
            "206",
            "206-Globin_Evolution-Myoglobins",
            "206-Globin_Evolution-Globins",
            "206-Globin_Evolution-3vrf",
            "205",
            "205-Nuclear_Pore_Complex-5a9q_5ijn",
            "205-Nuclear_Pore_Complex-5dis",
            "204",
            "203-PD1_Programmed_Cell_Death_Protein_1-3bik_3bp5",
            "203-PD1_Programmed_Cell_Death_Protein_1-5dk3_5jxe",
            "203",
            "203-Aminopeptidase_1_and_Autophagy-Selective_Autophagy_2016",
            "204-Aminopeptidase_1_and_Autophagy-5jh9_4r8f",
            "202",
            "202-Dipeptidyl_Peptidase4-1nu8",
            "202-Dipeptidyl_Peptidase4-Substrates2",
            "201",
            "201-Isoprene_Synthase-3n0g",
            "201-Isoprene_Synthase-1i9a_1p0n",
            "200",
            "200-Quasisymmetry_in_Icosahedral_Viruses-Quasisymmetry",
            "200-Quasisymmetry_in_Icosahedral_Viruses-1sva_2btv",
            "199",
            "199-Monellin-SuperSweet",
            "199-Monellin-SweetReceptor",
            "198",
            "198-betaGalactosidase-1jz8",
            "198-Betagalactosidase-bgal_2015_Multicolor_highRes_Subramaniam",
            "197",
            "197-Zika_Virus-5ire_glyc",
            "197-Zika_Virus-ZikaVirus",
            "196",
            "196-Lead_Poisoning-1qnv",
            "196-Lead_Poisoning-lead",
            "195",
            "195-Raf_Protein_Kinases-raf",
            "195-Raf_Protein_Kinases-1uwj",
            "194",
            "194-Designer_Insulins-1trz",
            "194-Designer_Insulins-4ajx",
            "193",
            "193-Siderocalin-3cmp_composite",
            "193-Siderocalin-1lfg_3eyc",
            "192",
            "192-Vancomycin-1fvm",
            "192-Vancomycin-3se7",
            "191",
            "191-GlutamateGatedChlorideReceptors_3rif",
            "191-GlutamateGatedChlorideReceptors_4hfe_3jad",
            "190",
            "190-TwoComponentSystems_2c2a_3by8",
            "190-TwoComponentSystems_1kgs_1gxp_1zes",
            "189",
            "189-Amyloids_2m4j",
            "189-Amyloids_amyloids",
            "188",
            "188-TetrahydrobiopterinBiosynthesis_1gtp_1gtq_1sep",
            "188-TetrahydrobiopterinBiosynthesis_1dcp_1dhr",
            "187",
            "187-New_Delhi_MetalloBetaLactamase-4eyl",
            "187-New_Delhi_MetalloBetaLactamase-3rxw",
            "186",
            "186-ReceptorForAdvancedGlycationEndProducts_4lp5_figure",
            "186-ReceptorForAdvancedGlycationEndProducts_3b75_figure",
            "185",
            "185-Titin_sarcomere_titin",
            "185-Titin_1ya5",
            "184",
            "184-Glucagon_glucagonreceptor",
            "184-Glucagon_proglucagon",
            "183",
            "183-Phototropin_phototropin",
            "183-Phototropin_Vivid",
            "182",
            "182-InsulinReceptor_insulinreceptor",
            "182-InsulinReceptor_3w14_composite",
            "181",
            "181-CascadeAndCRISPR_1vy8",
            "181-CascadeAndCRISPR_CasProteins",
            "181-CascadeAndCRISPR_4un3",
            "180",
            "180-TALEffectors_3ugm",
            "180-TALEffectors_TALEN",
            "179",
            "179-MethylCoenzymeMReductase_1mro",
            "179-MethylCoenzymeMReductase_1mro_tools",
            "178",
            "178-Ebola_Virus_Proteins-EbolaProteins2018",
            "178-Ebola_Virus_Proteins-5z9w",
            "178-EbolaVirusProteins_VP40",
            "177",
            "177-Apoptosomes_human_apoptosome",
            "177-Apoptosomes_apoptosomes",
            "176",
            "176-Dynein_3vkh-label",
            "176-Dynein_3j1t",
            "175",
            "175-Microtubules_3j2u",
            "175-Microtubules_1ffx",
            "174",
            "174-GFPLikeProteins_1g7k",
            "174-GFPLikeProteins_GFP-like_Proteins",
            "173",
            "173-Aquaporin_1fqy",
            "173-Aquaporin_1fx8_pmv",
            "172",
            "172-RecAAndRad51_recA_filament",
            "172-RecAAndRad51_1w36",
            "171",
            "171-NeurotransmitterTransporters_4m48",
            "171-NeurotransmitterTransporters_2nwx",
            "170",
            "170-BroadlyNeutralizingAntibodies_4nco_bnAb",
            "170-BroadlyNeutralizingAntibodies_HA_bnAb",
            "169",
            "169-HIVEnvelopeGlycoprotein_4nco_composite",
            "169-HIVEnvelopeGlycoprotein_1gc1_composite",
            "168",
            "168-DNAHelicase_4esv",
            "168-DNAHelicase_3r8f_helix",
            "167",
            "167-SNAREProteins_1sfc_1br0",
            "167-SNAREProteins_1nsf",
            "166",
            "166-Proteasome_4b4t_dimer",
            "166-Proteasome_1fnt_3l5q",
            "165",
            "165-DesignedProteinCages_3vdx_4egg",
            "165-DesignedProteinCages_3tom",
            "164",
            "164-SerotoninReceptor_4iar",
            "164-SerotoninReceptor_3gwv",
            "163",
            "163-HIVCapsid_capsid_composite",
            "163-HIVCapsid_2lm3_1ak4_1e6j",
            "162",
            "162-Dermcidin_2ymk_twoviews",
            "162-Dermcidin_1dfn_2k6o",
            "161",
            "161-Ricin_2aai",
            "161-Ricin_3u5d_3u5e",
            "161-Ricin_immunotoxin",
            "160",
            "160-Actinomycin_173d_composite",
            "160-Actinomycin_1k4t",
            "159",
            "159-Erythrocruorin_2gtl",
            "159-Erythrocruorin_hemoglobins",
            "158",
            "158-ProtonGatedUreaChannel_3ux4",
            "158-ProtonGatedUreaChannel_1e9y",
            "157",
            "157-TransferMessengerRNA_3iyr_composite",
            "157-TransferMessengerRNA_3j18_3j19_composite",
            "156",
            "156-ABOBloodTypeGlycosyltransferases_3i0g_composite",
            "156-ABOBloodTypeGlycosyltransferases_1lu1_2j1u_2obs",
            "155",
            "155-VitaminDReceptor_VDRcryo",
            "155-VitaminDReceptor_3c6g_1j78",
            "154",
            "154-CitricAcidCycle_citricacidcycle",
            "154-CitricAcidCycle_1cts",
            "154-CitricAcidCycle_7acn-composite",
            "154-CitricAcidCycle_3blw",
            "154-CitricAcidCycle_OGDH",
            "154-CitricAcidCycle_2fp4_1cqi",
            "154-CitricAcidCycle_1nek-composite",
            "154-CitricAcidCycle_1fuo",
            "154-CitricAcidCycle_1mld_5mdh",
            "153",
            "153-PyruvateDehydrogenaseComplex_pyruvatedehydrogenase",
            "153-PyruvateDehydrogenaseComplex_1w85_composite",
            "152",
            "152-cAMP-dependentProteinKinase_PKA",
            "152-cAMP-dependentProteinKinase_1xp0",
            "151",
            "151-HGPRT_1hmp",
            "151-HGPRT_1cjb",
            "150",
            "150-SlidingClamps_3u5z_open",
            "150-SlidingClamps_1ul1",
            "149",
            "149-Leptin_1ax8",
            "149-Leptin_1ron",
            "148",
            "148-RasProtein_5p21",
            "148-RasProtein_Ras",
            "147",
            "147-Rhodopsin_1f88",
            "147-Rhodopsin_3fsn",
            "146",
            "146-AminoglycosideAntibiotics_3frh_3pb3",
            "146-AminoglycosideAntibiotics_aminoglycoside_modifying_enzymes",
            "145",
            "145-MessengerRNACapping_3kyh_1ri1",
            "145-MessengerRNACapping_2qkm_1st0",
            "144",
            "144-ComplexI_3m9s_3rko",
            "144-ComplexI_1zcd",
            "143",
            "143-TollLikeReceptors_3fxi_2j67",
            "143-TollLikeReceptors_3ciy",
            "142",
            "142-PDBPioneers_oxygencarrier",
            "142-PDBPioneers_enzymes",
            "142-PDBPioneers_electroncarrier",
            "141",
            "141-OGlcNAcTransferase_3pe4_1w3b",
            "141-OGlcNAcTransferase_2cbj",
            "140",
            "140-RhomboidProteaseGlpG_2nrf_membrane",
            "140-RhomboidProteaseGlpG_3b4r_3s0x",
            "139",
            "139-DNAMethylases_DNMT",
            "139-DNAMethylases_1mht",
            "138",
            "138-Glucansucrase_3aic",
            "138-Glucansucrase_3aie_1smd",
            "137",
            "137-Cytochromebc1_3h1j",
            "137-Cytochromebc1_1vf5",
            "136",
            "136-Nanobodies_antibody_nanobody",
            "136-Nanobodies_1mel_complex",
            "135",
            "135-Integrase_3os1_composite",
            "134",
            "134-Integrin_1jv2-2k9j-1m8o",
            "134-Integrin_integrins",
            "133",
            "133-NitricOxideSynthase_nNOS",
            "133-NitricOxideSynthase_sGC",
            "132",
            "132-Adenovirus_adenovirus",
            "132-Adenovirus_adenovirus_clip",
            "131",
            "131-Inteins_1jva",
            "131-Inteins_1lws_1am2",
            "130",
            "130-Riboswitches_1u8d",
            "130-Riboswitches_riboswitches",
            "129",
            "129-IsocitrateDehydrogenase_3blw_9icd",
            "129-IsocitrateDehydrogenase_3lcb",
            "128",
            "128-Interferons_interferons",
            "128-Interferons_3bes",
            "127",
            "127-Crystallins",
            "126",
            "126-EpidermalGrowthFactor_EGFR",
            "126-EpidermalGrowthFactor_1ptu",
            "125",
            "125-Parvoviruses_1fpv_2cas",
            "125-Parvoviruses_1s58",
            "124",
            "124-ConcanavalinACircularPermutation_1cvn",
            "124-ConcanavalinACircularPermutation_3cna",
            "123",
            "123-P-glycoprotein_3g61_composite",
            "123-P-glycoprotein_3g61_1bln",
            "122",
            "122-Enhanceosome_enhanceosome",
            "122-Enhanceosome_CBP",
            "121",
            "121-70SRibosomes_2wdk_2wdl_front",
            "121-70SRibosomes_initiation",
            "121-70SRibosomes_elongation",
            "121-70SRibosomes_termination",
            "121-70SRibosomes_antibiotics",
            "120",
            "120-AntifreezeProteins_1kdf",
            "120-AntifreezeProteins_antifreeze",
            "119",
            "119-DesignedDNACrystal_3gbi_composite",
            "119-DesignedDNACrystal_309d",
            "118",
            "118-SodiumPotassiumPump_2zxe_composite",
            "118-SodiumPotassiumPump_2zxe_1su4_3b8c",
            "117",
            "117-XanthineOxidoreductase_1fo4_composite",
            "117-XanthineOxidoreductase_1r4u_composite",
            "116",
            "116-Sulfotransferases_sulfotransferases",
            "116-Sulfotransferases_APSenzymes",
            "115",
            "115-betaSecretase_1sgz_1py1",
            "115-betaSecretase_1py1",
            "114",
            "114-Vaults_vaults",
            "114-Vaults_containers",
            "113",
            "113-Influenza_Neuraminidase-neuraminidases",
            "113-Influenza_Neuraminidase-1nca",
            "112",
            "112-TranscriptionFactors_1gt0_composite",
            "112-TranscriptionFactors_1nkp_2ebt",
            "111",
            "111-Hydrogenases_composite",
            "111-Hydrogenases_1e08",
            "110",
            "110-AuxinandTIR1UbiquitinLigase_2p1p",
            "110-AuxinandTIR1UbiquitinLigase_1xmb",
            "109",
            "109-TobaccoMosaicVirus_2tmv_composite",
            "109-TobaccoMosaicVirus_1ei7",
            "108",
            "108-Hsp90-2cg9_composite",
            "108-Hsp90-2cg9_2ioq",
            "107",
            "107-MechanosensitiveChannels-2oau_composite",
            "107-MechanosensitiveChannels-2oar_composite",
            "106",
            "106-Poly-A-Polymerase-1fa0",
            "106-Poly-A-Polymerase-1cvj",
            "105",
            "105-Ribonuclease-A-5rsa",
            "105-Ribonuclease-A-2fk6_2ez6",
            "104",
            "104-SelenocysteineSynthase-3bc8_2yye",
            "104-SelenocysteineSynthase-1wb1_2uwm",
            "103",
            "103-DengueVirus-1k4r",
            "103-DengueVirus-nonstructuralproteins",
            "102",
            "102-LactateDehydrogenase-3ldh",
            "102-LactateDehydrogenase-1lth",
            "101",
            "101-Prions-PrP",
            "101-Prions-2rnm",
            "100",
            "100-AdrenergicReceptors-2rh1",
            "100-AdrenergicReceptors-backbone",
            "99",
            "99-Cadherin-1l3w-1i7x",
            "99-Cadherin-1l3w-1q5a-1q5c",
            "98",
            "98-SmallInterferingRNA-siRNA",
            "98-SmallInterferingRNA-1r9f",
            "97",
            "97-CircadianClock Proteins-Kai-proteins",
            "97-CircadianClockProteins-1cjw",
            "96",
            "96-OxidosqualeneCyclase-1w6k",
            "96-OxidosqualeneCyclase-1hwk",
            "95",
            "95-MultidrugResistanceTransporter-2onj",
            "95-MultridrigResistanceTransporter-multidrugtransporters",
            "94",
            "94-SuperoxideDismutase-2sod",
            "94-SuperoxideDismutase-SODs",
            "93",
            "93-CitrateSynthase-1cts-2cts",
            "93-CitrateSynthase-1nxg",
            "92",
            "92-AnabolicSteroids-1d2s",
            "92-AnabolicSteroids-1xf0",
            "91",
            "91-ThymineDimers-1n4e",
            "91-ThymineDimers-1vas-1tez",
            "90",
            "90-FattyAcidSynthase-fas",
            "90-FattyAcidSynthase-fasII-composite",
            "89",
            "89-AconitaseandIronRegulatoryProtein1-2b3y-2ipy",
            "89-AconitaseandIronRegulatoryProtein1-moonlighting",
            "88",
            "88-Clathrin-1xi4-composite",
            "88-Clathrin-ap2-composite",
            "87",
            "87-ZincFingers-1tf6-1un6",
            "87-ZincFingers-zincfingers",
            "86",
            "86-Exosomes-2nn6",
            "86-Exosomes-2a1s-1st0",
            "85",
            "85-Importins-1qgk-composite",
            "85-Importins-2bku-1wa5",
            "84",
            "84-Transposase-1muh-tube",
            "84-Transposase-1z1g-composite",
            "83",
            "83-Fibrin-1m1j-composite",
            "83-Fibrin-1m1j-1fzc",
            "82",
            "82-Cytochromep450-1w0e-2j0d",
            "82-Cytochromep450-1ea1-1e6e",
            "81",
            "81-ElongationFactors-1ttt",
            "81-ElongationFactors-1efu",
            "81-ElongationFactors-1dar-1ttt",
            "80",
            "80-AAA+Proteases-1yyf",
            "80-AAA+Proteases-AAAproteins",
            "79",
            "79-Amyloid-betaPrecursorProtein-app-composite",
            "79-Amyloid-betaPrecursorProtein-1fkn",
            "78",
            "78-Luciferase-2d1s-composite",
            "78-Luciferase-1brl-1vpr",
            "77",
            "77-GlucoseOxidase-gpe-composite",
            "77-GlucoseOxidase-1gco-1cq1",
            "76",
            "76-Hemagglutinin-1ruz-membrane",
            "76-Hemagglutinin-HA-action",
            "75",

            "75-TissueFactor-1dan-composite",
            "75-TissueFactor-2hft-composite", // needs fixing -number

            "74",
            "74-alpha-Amylase-1ppi",
            "74-alpha-Amylase-industrial",
            "73",
            "73-Topoisomerases-1a36-composite",
            "73-Topoisomerases-1bgw-1ei1",
            "72",
            "72-ATPSynthase-ATPsynthase",
            "72-ATP_Synthase-6b8h",
            "71",
            "71-AcetylcholineReceptor-2bg9-composite",
            "71-AcetycholineReceptor-1yi5",
            "70",
            "70-DesignerProteins-1qys-composite",
            "70-DesignerProteins-bundles",
            "69",
            "69-CholeraToxin-1xtc-composite",
            "69-CholeraToxin-toxins",
            "68",
            "68-Neurotrophins-1bet",
            "68-Neurotrophins-receptors",
            "67",
            "67-TATA-BindingProtein-1cdw",
            "67-TATA-BindingProtein-TF",
            "66",
            "66-CarotenoidOxygenase-2biw-composite",
            "66-CartenoidOxygenase-1jb0-1f88",
            "65",
            "65-Self-SplicingRNA-1u6b",
            "65-Self-SplicingRNA-1mme",
            "64",

            "64-Kinesin-3kin-2ncd",
            "64-Kinesin-3kin-composite",  // needs fixing - number suffix

            "63",
            "63-T-CellReceptor-1tcr",
            "63-T-CellReceptor-MHC",
            "62",
            "62-MajorHistocompatibilityComplex-1hsa",
            "62-MajorHistocompatibilityComplex-1hsa-1dlh",
            "62-MajorHistocompatibilityComplex-IgDomain1",
            "62-MajorHistocompatibilityComplex-IgDomain2",
            "61",
            "61-PhenylalanineHydroxylase-2pah-1phz",
            "61-PhenylalanineHydroxylase-hydroxylases",
            "60",
            "60-Ubiquitin-ubiquitin",
            "60-Ubiquitin-enzymes",
            "60-Ubiquitin-1fnt",
            "59",
            "59-PhotosystemII-1s5l-chain",
            "59-PhotosystemII-antenna",
            "58",
            "58-G_Proteins-1gg2",
            "58-G_Proteins-G-Protein",
            "57",
            "57-Catalase-7cat",
            "57-Catalase-catalases",
            "56",
            "56-Caspases-caspases",
            "56-Caspases-CAD",
            "55",
            "55-DNALigase-1a0i-1dgs",
            "55-DNALigase-1NHEJ-label",
            "54",
            "54-Acetylcholinesterase-1acj-composite",
            "54-Acetylcholinesterase-1b41-1eve",
            "53",
            "53-Serpins-1psi",
            "53-Serpins-antitrypsin-action",
            "52",
            "52-GrowthHormone-hormones",
            "52-GrowthHormone-3hhr-membrane",
            "51",
            "51-TheCalciumPump-1eul-membrane",
            "51-TheCalciumPumps-calcium-pumps",
            "50",
            "50-TheGlycolyticEnzymes-glycolysis",
            "50-TheGlycolyticEnzymes-01-1dgk",
            "50-TheGlycolyticEnzymes-01-1hkg-2yhx",
            "50-TheGlycolyticEnzymes-02-1hox",
            "50-TheGlycolyticEnzymes-03-4pfk",
            "50-TheGlycolyticEnzymes-03-4pfk-6pfk",
            "50-TheGlycolyticEnzymes-04-4ald-1j4e",
            "50-TheGlycolyticEnzymes-05-2ypi",
            "50-TheGlycolyticEnzymes-06-3gpd-1nqo",
            "50-TheGlycolyticEnzymes-07-3pgk-1vpe",
            "50-TheGlycolyticEnzymes-08-3pgm-1eqj",
            "50-TheGlycolyticEnzymes-09-2one",
            "50-TheGlycolyticEnzymes-10-1e0u-1a3w",
            "49",
            "49-CarbonicAnhydrase-carbonic-anhydrases",
            "49-CarbonicAnhydrase-1cnw",
            "48",
            "48-CataboliteActivatorProtein-1cgp",
            "48-CataboliteActivatorProtein-cap-polymerase",
            "47",
            "47-SimianVirus40-1sva-DNA",
            "47-SimianVirus40-T-antigen",
            "46",
            "46-Trypsin-serine-proteases",
            "46-Trypsin-trypsinogen",
            "45",
            "45-EstrogenReceptor-1hcq-1a52",
            "45-EstrogenReceptor-tamoxifen",
            "44",
            "44-Calmodulin-3cln",
            "44-Calmodulin-1cfd-1cll",
            "44-Calmodulin-complexes",
            "43",
            "43-SrcTyosineKinase-2src",
            "43-SrcTyrosineKinase-2src-mechanism",
            "42",
            "42-GreenFlourescentProtein-1gfl-composite",
            "42-GreenFluorescentProtein-1kys-composite",
            "41",
            "41-Hemoglobin-2dhb",
            "41-Hemoglobin-2hbs-fiber",
            "40",
            "40-RNAPolymerase-1i6h-composite",
            "40-RNAPolymerase-1k83",
            "39",
            "39-LacRepressor-lac",
            "39-LacRepressor-lac-DNAloop",
            "39-lac_Repressor-39-LacRepressor-lac-operon",
            "38",
            "38-PotassiumChannels-1bl8",
            "38-PotassiumChannels",
            "38-PotassiumChannels-2crd",
            "37",
            "37-SerumAlbumin-1e7i",
            "37-SerumAlbumin-transport",
            "36",
            "36-Cytochromec-3cyt-twoviews",
            "36-Cytochromec-electron-transport",
            "35",
            "35-FerritinandTransferrin-ferritin",
            "35-FerritinandTransferrin-transferrin-and-receptor",
            "34",
            "34-DihydrofolateReductase-7dfr",
            "34-DihydrofolateReductase-3dfr-1dls",
            "33",
            "33-ReverseTranscriptase-3hvt",
            "33-ReverseTranscriptase-2hmi-label",
            "32",
            "32-Chaperones-chaperonin",
            "32-Chaperones-dnaK-prefoldin",
            "31",
            "31-p53TumorSuppressor-p53-unbound",
            "31-p53TumorSuppressor-p53-bound",
            "30",
            "30-GlutamineSynthetase-1fpy-twoviews",
            "30-GlutamineSynthetase-1fpy-ligands",
            "29",
            "29-Penicillin-bindingProteins-3pte",
            "29-Penicillin-bindingProteins-4blm-3pte",
            "28",
            "28-Anthrax-Toxin",
            "28-AnthraxToxin-1acc-1tzo",
            "27",
            "27-Bacteriorhodopsin-1fbb-twoviews",
            "27-Bacteriorhodopsin-two-rhodopsins",
            "26",
            "26-Nitrogenase-1n2c",
            "26-Nitrogenase-1n2c-clusters",
            "25",
            "25-Thrombin-1ppb-transparent",
            "25-Thrombin-activation",
            "25-Thrombin-hirudin",
            "24",
            "24-GlycogenPhosphorylase-6gpb-2views",
            "24-GlycogenPhosphorylase-allostery",
            "23",
            "23-DNA-B-DNA",
            "23-DNA-information",
            "23-DNA-ABZ",
            "22",
            "22-PhotosystemI-1jb0",
            "22-PhotosystemI-1jb0-etc",
            "22-PhotosystemI-reaction-centers",
            "22-PhotosystemI-1jb0-antenna",
            "21",
            "21-Antibodies-1igt",
            "21-Antibodies-hyhel-overlap",
            "21-Antibodies-1c1e-reaction",
            "20",
            "20-PoliovirusandRhinovirus-picornaviruses",
            "20-PoliovirusandRhinovirus-4rhv-symmetry",
            "20-PoliovirusandRhinovirus-rhinovirus-biology",
            "19",
            "19-Actin-actin18",
            "19-Actin-actin-binding",
            "18",
            "18-Myosin-1b7t",
            "18-Myosin-painting",
            "18-Myosin-powerstroke",
            "17",
            "17-Cyclooxygenase-1prh-figure",
            "17-Cyclooxygenase-4cox_tunnel",
            "16",
            "16-Aminoacyl-tRNASynthetases-1asz",
            "16-Aminoacyl-tRNASynthetases-aaRS",
            "16-Aminoacyl-tRNASynthetases-1ffy",
            "15",
            "15-TransferRNA-two-trna",
            "14",
            "14-Insulin-2kqp_4ins",
            "14-Insulin-4ins_2hiu",
            "13",
            "13-AlcoholDehydrogenase-1htb",
            "13-AlcoholDehydrogenase-two-adh",
            "12",
            "12-Pepsin-pepsinogen",
            "12-Pepsin-asp-proteases",
            "11",
            "11-Rubisco-1rcx",
            "11-Rubisco-two-forms",
            "10",
            "10-Ribosome_figure",
            "10-Ribosome-1ffk_front_figure",
            "10-Ribosome-1fka_front_figure",
            "9",
            "9-Lysozyme-2lyz",
            "9-Lysozyme-mutant",
            "8",
            "8-RestrictionEnzymes-EcorI",
            "8-RestrictionEnzymes-stickyends",
            "7",
            "7-Nucleosome-1aoi",
            "7-Nucleosome",
            "6",
            "6-HIV-1Protease-3hvp",
            "6-HIV-1Protease-7hvp_activesite",
            "5",
            "5-CytochromecOxidase-1oco",
            "5-CytochromecOxidase-cytox_composite",
            "5-CytochromecOxidase-1oco_subunit",
            "4",
            "4-Collagen",
            "4-Collagen-painting_large",
            "3",
            "3-DNAPolymerase-1tau",
            "2",
            "2-BacteriophagephiX174-mature",
            "2-BacteriophagephiX174-1cd3",
            "1",
            "1-Myoglobin-geis-myoglobin",
            "1-Myoglobin-1pmb_1mbn",
            "1-Myoglobin-1mbo_JSmol",

            "0" // end marker


    )
}