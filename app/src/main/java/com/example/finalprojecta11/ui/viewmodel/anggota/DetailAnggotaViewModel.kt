package com.example.finalprojecta11.ui.viewmodel.anggota

import com.example.finalprojecta11.model.Anggota

sealed class DetailAnggotaUiState {
    data class Success(val anggota: Anggota) : DetailAnggotaUiState()
    object Error : DetailAnggotaUiState()
    object Loading : DetailAnggotaUiState()
}