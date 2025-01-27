package com.example.finalprojecta11

import android.app.Application
import com.example.finalprojecta11.di.AgtContainer
import com.example.finalprojecta11.di.AnggotaContainer
import com.example.finalprojecta11.di.BkContainer
import com.example.finalprojecta11.di.BukuContainer
import com.example.finalprojecta11.di.PeminjamanContainer
import com.example.finalprojecta11.di.PengembalianContainer
import com.example.finalprojecta11.di.PmnjmnContainer
import com.example.finalprojecta11.di.PngmblnContainer

class PerpustakaanApplications: Application()  {

    lateinit var container: BukuContainer
    lateinit var containerA: AnggotaContainer
    lateinit var containerP: PeminjamanContainer
    lateinit var containerPe: PengembalianContainer

    override fun onCreate() {
        super.onCreate()
        container = BkContainer()
        containerA = AgtContainer()
        containerP = PmnjmnContainer()
        containerPe = PngmblnContainer()
    }
}