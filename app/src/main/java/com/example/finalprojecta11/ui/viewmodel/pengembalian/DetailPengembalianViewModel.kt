package com.example.finalprojecta11.ui.viewmodel.pengembalian

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecta11.model.Pengembalian
import com.example.finalprojecta11.repository.PengembalianRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed class DetailPengembalianUiState {
    data class Success(val pengembalian: Pengembalian) : DetailPengembalianUiState()
    object Error : DetailPengembalianUiState()
    object Loading : DetailPengembalianUiState()
}

class DetailPengembalianViewModel(private val Pngmbln: PengembalianRepository) : ViewModel() {
    private val _detailUiState =
        MutableStateFlow<DetailPengembalianUiState>(DetailPengembalianUiState.Loading)
    val detailUiState: StateFlow<DetailPengembalianUiState> = _detailUiState

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getPengembalianByid(id_pengembalian: String) {
        viewModelScope.launch {
            _detailUiState.value = DetailPengembalianUiState.Loading
            _detailUiState.value = try {
                val peminjaman = Pngmbln.getPengembalianByid(id_pengembalian)
                DetailPengembalianUiState.Success(peminjaman)
            } catch (e: IOException) {
                DetailPengembalianUiState.Error
            } catch (e: HttpException) {
                DetailPengembalianUiState.Error
            }
        }
    }
}