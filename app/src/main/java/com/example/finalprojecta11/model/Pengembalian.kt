package com.example.finalprojecta11.model

import kotlinx.serialization.Serializable

@Serializable
data class Pengembalian(
    val id_pengembalian: String,
    val id_peminjaman: String,
    val tanggal_dikembalikan: String
)

@Serializable
data class  AllPengembalianResponse(
    val status: Boolean,
    val message: String,
    val data: List<Pengembalian>
)

@Serializable
data class  PengembalianDetailResponse(
    val status: Boolean,
    val message: String,
    val data: Pengembalian
)