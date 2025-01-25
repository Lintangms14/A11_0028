package com.example.finalprojecta11.di

import com.example.finalprojecta11.repository.AnggotaRepository
import com.example.finalprojecta11.repository.NetworkAnggotaRepository
import com.example.finalprojecta11.service.AnggotaService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit


interface AnggotaContainer {
    val anggotaRepository: AnggotaRepository
}

class AgtContainer : AnggotaContainer {

    private val baseUrl = "http://10.0.2.2:3000/api/peminjaman/" //localhost diganti ip kalo run di hp

    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl).build()

    private val anggotaService: AnggotaService by lazy {
        retrofit.create(AnggotaService::class.java)
    }

    override val anggotaRepository: AnggotaRepository by lazy {
        NetworkAnggotaRepository(anggotaService)
    }
}