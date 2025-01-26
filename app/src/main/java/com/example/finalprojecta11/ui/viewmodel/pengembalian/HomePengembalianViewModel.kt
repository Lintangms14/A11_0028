package com.example.finalprojecta11.ui.viewmodel.pengembalian

import com.example.finalprojecta11.model.Pengembalian

sealed class HomePengembalianUiState{
    data class Success(val pengembalian: List<Pengembalian>) : HomePengembalianUiState()
    object Error : HomePengembalianUiState()
    object Loading : HomePengembalianUiState()
}