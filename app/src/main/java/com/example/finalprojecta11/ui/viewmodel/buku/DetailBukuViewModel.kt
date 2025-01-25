package com.example.finalprojecta11.ui.viewmodel.buku

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecta11.model.Buku
import com.example.finalprojecta11.repository.BukuRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

class DetailBukuViewModel(private val Bk: BukuRepository) : ViewModel() {
    private val _detailUiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val detailUiState: StateFlow<DetailUiState> = _detailUiState

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getBukuByid(id_buku: String) {
        viewModelScope.launch {
            _detailUiState.value = DetailUiState.Loading
            _detailUiState.value = try {
                val buku = Bk.getBukuByid(id_buku)
                DetailUiState.Success(buku)
            } catch (e: IOException) {
                DetailUiState.Error
            } catch (e: HttpException) {
                DetailUiState.Error
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun updateBk(id_buku: String, updatedBuku: Buku) {
        viewModelScope.launch {
            try {
                Bk.updateBuku(id_buku, updatedBuku)
                _detailUiState.value = DetailUiState.Success(updatedBuku)
            } catch (e: IOException) {
                _detailUiState.value = DetailUiState.Error
            } catch (e: HttpException) {
                _detailUiState.value = DetailUiState.Error
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun deleteBk(id_buku: String) {
        viewModelScope.launch {
            try {
                Bk.deleteBuku(id_buku)
                _detailUiState.value = DetailUiState.Loading
            } catch (e: IOException) {
                _detailUiState.value = DetailUiState.Error
            } catch (e: HttpException) {
                _detailUiState.value = DetailUiState.Error
            }
        }
    }
}

sealed class DetailUiState {
    data class Success(val buku: Buku) : DetailUiState()
    object Error : DetailUiState()
    object Loading : DetailUiState()
}