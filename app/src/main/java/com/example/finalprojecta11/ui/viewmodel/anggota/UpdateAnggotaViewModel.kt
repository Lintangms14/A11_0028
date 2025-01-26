package com.example.finalprojecta11.ui.viewmodel.anggota

import com.example.finalprojecta11.model.Anggota

fun Anggota.toUpdateUiState(): UpdateAnggotaUiState = UpdateAnggotaUiState(
    updateAnggotaUiEvent = toUpdateUiEvent()
)

data class UpdateAnggotaUiState(
    val updateAnggotaUiEvent: UpdateAnggotaUiEvent = UpdateAnggotaUiEvent()
)

fun Anggota.toUpdateUiEvent(): UpdateAnggotaUiEvent = UpdateAnggotaUiEvent(
    id_anggota = id_anggota,
    nama = nama,
    email = email,
    nomor_telepon = nomor_telepon
)

fun UpdateAnggotaUiEvent.toAgt(): Anggota = Anggota(
    id_anggota = id_anggota,
    nama = nama,
    email = email,
    nomor_telepon = nomor_telepon
)

data class UpdateAnggotaUiEvent(
    val id_anggota: String = "",
    val nama: String = "",
    val email: String = "",
    val nomor_telepon: String = ""
)