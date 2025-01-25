package com.example.finalprojecta11.ui.viewmodel.buku

data class InsertUiEvent(
    val id_buku: String = "",
    val judul: String = "",
    val penulis: String = "",
    val kategori: String = "",
    val status: String = ""
)