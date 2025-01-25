package com.example.finalprojecta11.di

import com.example.finalprojecta11.repository.NetworkPeminjamanRepository
import com.example.finalprojecta11.repository.PeminjamanRepository
import com.example.finalprojecta11.service.PeminjamanService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface PeminjamanContainer {
    val peminjamanRepository: PeminjamanRepository
}

class PmnjmnContainer : PeminjamanContainer {

    private val baseUrl = "http://10.0.2.2:3000/api/peminjaman/" //localhost diganti ip kalo run di hp

    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl).build()

    private val peminjamanService: PeminjamanService by lazy {
        retrofit.create(PeminjamanService::class.java)
    }

    override val peminjamanRepository: PeminjamanRepository by lazy {
        NetworkPeminjamanRepository(peminjamanService)
    }
}