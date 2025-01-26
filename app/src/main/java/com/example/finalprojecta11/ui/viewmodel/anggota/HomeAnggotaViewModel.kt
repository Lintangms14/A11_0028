package com.example.finalprojecta11.ui.viewmodel.anggota

import com.example.finalprojecta11.model.Anggota
sealed class HomeAnggotaUiState{
    data class Success(val anggota: List<Anggota>) : HomeAnggotaUiState()
    object Error : HomeAnggotaUiState()
    object Loading : HomeAnggotaUiState()
}