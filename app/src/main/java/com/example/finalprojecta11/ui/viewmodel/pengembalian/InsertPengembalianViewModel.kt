package com.example.finalprojecta11.ui.viewmodel.pengembalian

data class InsertPengembalianUiEvent(
    val id_pengembalian: String = "",
    val id_peminjaman: String = "",
    val tanggal_dikembalikan: String = ""
)