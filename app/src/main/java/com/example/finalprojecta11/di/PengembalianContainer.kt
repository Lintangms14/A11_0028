package com.example.finalprojecta11.di

import com.example.finalprojecta11.repository.NetworkPengembalianRepository
import com.example.finalprojecta11.repository.PengembalianRepository
import com.example.finalprojecta11.service.PengembalianService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface PengembalianContainer {
    val pengembalianRepository: PengembalianRepository
}

class PngmblnContainer : PengembalianContainer {

    private val baseUrl = "http://10.0.2.2:3000/api/pengembalian/" //localhost diganti ip kalo run di hp

    private val json = Json { ignoreUnknownKeys = true }

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl).build()

    private val pengembalianService: PengembalianService by lazy {
        retrofit.create(PengembalianService::class.java)
    }

    override val pengembalianRepository: PengembalianRepository by lazy {
        NetworkPengembalianRepository(pengembalianService)
    }
}