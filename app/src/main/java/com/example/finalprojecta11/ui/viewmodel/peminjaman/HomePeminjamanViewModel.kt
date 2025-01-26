package com.example.finalprojecta11.ui.viewmodel.peminjaman

import com.example.finalprojecta11.model.Peminjaman

sealed class HomePeminjamanUiState{
    data class Success(val peminjaman: List<Peminjaman>) : HomePeminjamanUiState()
    object Error : HomePeminjamanUiState()
    object Loading : HomePeminjamanUiState()
}