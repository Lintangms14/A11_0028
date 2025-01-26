package com.example.finalprojecta11.ui.viewmodel.pengembalian

import com.example.finalprojecta11.model.Pengembalian

sealed class DetailPengembalianUiState {
    data class Success(val pengembalian: Pengembalian) : DetailPengembalianUiState()
    object Error : DetailPengembalianUiState()
    object Loading : DetailPengembalianUiState()
}