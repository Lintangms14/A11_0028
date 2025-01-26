package com.example.finalprojecta11.ui.viewmodel.anggota

import com.example.finalprojecta11.model.Anggota

fun Anggota.toInsertUiEvent(): InsertAnggotaUiEvent = InsertAnggotaUiEvent(
    id_anggota = id_anggota,
    nama = nama,
    email = email,
    nomor_telepon = nomor_telepon
)

fun InsertAnggotaUiEvent.toAgt(): Anggota = Anggota(
    id_anggota = id_anggota,
    nama = nama,
    email = email,
    nomor_telepon = nomor_telepon
)

data class InsertAnggotaUiEvent(
    val id_anggota: String = "",
    val nama: String = "",
    val email: String = "",
    val nomor_telepon: String = ""
)