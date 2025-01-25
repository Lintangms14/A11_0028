package com.example.finalprojecta11.model

import kotlinx.serialization.Serializable

@Serializable
data class Peminjaman(
    val id_peminjaman: String,
    val nama: String,
    val id_anggota: String,
    val tanggal_peminjaman: String,
    val tanggal_pengembalian: String
)

@Serializable
data class  AllPeminjamanResponse(
    val status: Boolean,
    val message: String,
    val data: List<Peminjaman>
)

@Serializable
data class  PeminjamanDetailResponse(
    val status: Boolean,
    val message: String,
    val data: Peminjaman
)