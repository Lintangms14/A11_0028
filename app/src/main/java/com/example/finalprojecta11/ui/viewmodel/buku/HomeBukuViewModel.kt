package com.example.finalprojecta11.ui.viewmodel.buku

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecta11.model.Buku
import com.example.finalprojecta11.repository.BukuRepository
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed class HomeUiState{
    data class Success(val buku: List<Buku>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}