package com.example.finalprojecta11.ui.viewmodel.peminjaman

data class InsertPeminjamanUiEvent(
    val id_peminjaman: String = "",
    val nama: String = "",
    val id_anggota: String = "",
    val tanggal_peminjaman: String = "",
    val tanggal_pengembalian: String = ""
)
