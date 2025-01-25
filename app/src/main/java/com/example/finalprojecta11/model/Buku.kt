package com.example.finalprojecta11.model

import kotlinx.serialization.Serializable

@Serializable
data class Buku(
    val id_buku: String,
    val judul: String,
    val penulis: String,
    val kategori: String,
    val status: String
)

@Serializable
data class  AllBukuResponse(
    val status: Boolean,
    val message: String,
    val data: List<Buku>
)

@Serializable
data class  BukuDetailResponse(
    val status: Boolean,
    val message: String,
    val data: Buku
)