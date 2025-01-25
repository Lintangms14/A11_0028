package com.example.finalprojecta11.ui.viewmodel.buku

import com.example.finalprojecta11.model.Buku

sealed class DetailUiState {
    data class Success(val buku: Buku) : DetailUiState()
    object Error : DetailUiState()
    object Loading : DetailUiState()
}