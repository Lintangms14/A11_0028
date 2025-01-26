package com.example.finalprojecta11.ui.viewmodel.peminjaman

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecta11.model.Peminjaman
import com.example.finalprojecta11.repository.PeminjamanRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

class DetailPeminjamanViewModel(private val Pmjmn: PeminjamanRepository) : ViewModel() {
    private val _detailUiState = MutableStateFlow<DetailPeminjamanUiState>(DetailPeminjamanUiState.Loading)
    val detailUiState: StateFlow<DetailPeminjamanUiState> = _detailUiState

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getPeminjamanByid(id_peminjaman: String) {
        viewModelScope.launch {
            _detailUiState.value = DetailPeminjamanUiState.Loading
            _detailUiState.value = try {
                val peminjaman = Pmjmn.getPeminjamanByid(id_peminjaman)
                DetailPeminjamanUiState.Success(peminjaman)
            } catch (e: IOException) {
                DetailPeminjamanUiState.Error
            } catch (e: HttpException) {
                DetailPeminjamanUiState.Error
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun updatePmjmn(id_peminjaman: String, updatedPeminjaman: Peminjaman) {
        viewModelScope.launch {
            try {
                Pmjmn.updatePeminjaman(id_peminjaman, updatedPeminjaman)
                _detailUiState.value = DetailPeminjamanUiState.Success(updatedPeminjaman)
            } catch (e: IOException) {
                _detailUiState.value = DetailPeminjamanUiState.Error
            } catch (e: HttpException) {
                _detailUiState.value = DetailPeminjamanUiState.Error
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun deletePmjmn(id_peminjaman: String) {
        viewModelScope.launch {
            try {
                Pmjmn.deletePeminjaman(id_peminjaman)
                _detailUiState.value = DetailPeminjamanUiState.Loading
            } catch (e: IOException) {
                _detailUiState.value = DetailPeminjamanUiState.Error
            } catch (e: HttpException) {
                _detailUiState.value = DetailPeminjamanUiState.Error
            }
        }
    }
}

sealed class DetailPeminjamanUiState {
    data class Success(val peminjaman: Peminjaman) : DetailPeminjamanUiState()
    object Error : DetailPeminjamanUiState()
    object Loading : DetailPeminjamanUiState()
}