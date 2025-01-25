package com.example.finalprojecta11.model

import kotlinx.serialization.Serializable

@Serializable
data class Anggota(
    val id_anggota: String,
    val nama: String,
    val email: String,
    val nomor_telepon: String
)

@Serializable
data class  AllAnggotaResponse(
    val status: Boolean,
    val message: String,
    val data: List<Anggota>
)

@Serializable
data class  AnggotaDetailResponse(
    val status: Boolean,
    val message: String,
    val data: Anggota
)