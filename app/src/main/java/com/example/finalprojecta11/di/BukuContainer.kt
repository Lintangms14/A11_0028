package com.example.finalprojecta11.di

import com.example.finalprojecta11.repository.BukuRepository
import com.example.finalprojecta11.repository.NetworkBukuRepository
import com.example.finalprojecta11.service.BukuService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface BukuContainer {
    val bukuRepository: BukuRepository
}

class BkContainer : BukuContainer {

    private val baseUrl = "http://10.0.2.2:3000/api/buku/" //localhost diganti ip kalo run di hp

    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl).build()

    private val bukuService: BukuService by lazy {
        retrofit.create(BukuService::class.java)
    }

    override val bukuRepository: BukuRepository by lazy {
        NetworkBukuRepository(bukuService)
    }
}