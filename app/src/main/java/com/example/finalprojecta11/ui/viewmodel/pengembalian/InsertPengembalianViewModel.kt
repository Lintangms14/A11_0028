package com.example.finalprojecta11.ui.viewmodel.pengembalian

import com.example.finalprojecta11.model.Pengembalian

fun InsertPengembalianUiEvent.toPngmbln(): Pengembalian = Pengembalian(
    id_pengembalian = id_pengembalian,
    id_peminjaman = id_peminjaman,
    tanggal_dikembalikan = tanggal_dikembalikan
)

data class InsertPengembalianUiEvent(
    val id_pengembalian: String = "",
    val id_peminjaman: String = "",
    val tanggal_dikembalikan: String = ""
)