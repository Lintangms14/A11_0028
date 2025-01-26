package com.example.finalprojecta11.ui.viewmodel.peminjaman

import com.example.finalprojecta11.model.Peminjaman

sealed class DetailPeminjamanUiState {
    data class Success(val peminjaman: Peminjaman) : DetailPeminjamanUiState()
    object Error : DetailPeminjamanUiState()
    object Loading : DetailPeminjamanUiState()
}