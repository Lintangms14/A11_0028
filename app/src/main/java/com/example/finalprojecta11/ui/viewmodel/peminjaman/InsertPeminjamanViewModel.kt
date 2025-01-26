package com.example.finalprojecta11.ui.viewmodel.peminjaman

import com.example.finalprojecta11.model.Peminjaman

fun Peminjaman.toUiStatePmjmn(): InsertPeminjamanUiState = InsertPeminjamanUiState(
    insertPeminjamanUiEvent = toInsertUiEvent()
)

data class InsertPeminjamanUiState(
    val insertPeminjamanUiEvent: InsertPeminjamanUiEvent = InsertPeminjamanUiEvent()
)

fun Peminjaman.toInsertUiEvent(): InsertPeminjamanUiEvent = InsertPeminjamanUiEvent(
    id_peminjaman = id_peminjaman,
    nama = nama,
    id_anggota = id_anggota,
    tanggal_peminjaman = tanggal_peminjaman,
    tanggal_pengembalian = tanggal_pengembalian
)

fun InsertPeminjamanUiEvent.toPmjmn(): Peminjaman = Peminjaman(
    id_peminjaman = id_peminjaman,
    nama = nama,
    id_anggota = id_anggota,
    tanggal_peminjaman = tanggal_peminjaman,
    tanggal_pengembalian = tanggal_pengembalian
)

data class InsertPeminjamanUiEvent(
    val id_peminjaman: String = "",
    val nama: String = "",
    val id_anggota: String = "",
    val tanggal_peminjaman: String = "",
    val tanggal_pengembalian: String = ""
)
