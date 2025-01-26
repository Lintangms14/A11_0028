package com.example.finalprojecta11.ui.viewmodel.peminjaman

import com.example.finalprojecta11.model.Peminjaman

fun Peminjaman.toUpdateUiState(): UpdatePeminjamanUiState = UpdatePeminjamanUiState(
    updatePeminjamanUiEvent = toUpdateUiEvent()
)

data class UpdatePeminjamanUiState(
    val updatePeminjamanUiEvent: UpdatePeminjamanUiEvent = UpdatePeminjamanUiEvent()
)

fun Peminjaman.toUpdateUiEvent(): UpdatePeminjamanUiEvent = UpdatePeminjamanUiEvent(
    id_peminjaman = id_peminjaman,
    nama = nama,
    id_anggota = id_anggota,
    tanggal_peminjaman = tanggal_peminjaman,
    tanggal_pengembalian = tanggal_pengembalian
)

fun UpdatePeminjamanUiEvent.toPmjmn(): Peminjaman = Peminjaman(
    id_peminjaman = id_peminjaman,
    nama = nama,
    id_anggota = id_anggota,
    tanggal_peminjaman = tanggal_peminjaman,
    tanggal_pengembalian = tanggal_pengembalian
)

data class UpdatePeminjamanUiEvent(
    val id_peminjaman: String = "",
    val nama: String = "",
    val id_anggota: String = "",
    val tanggal_peminjaman: String = "",
    val tanggal_pengembalian: String = ""
)