package com.example.finalprojecta11.ui.viewmodel.anggota

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecta11.model.Anggota
import com.example.finalprojecta11.repository.AnggotaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

class DetailAnggotaViewModel(private val Agt: AnggotaRepository) : ViewModel() {
    private val _detailUiState = MutableStateFlow<DetailAnggotaUiState>(DetailAnggotaUiState.Loading)
    val detailUiState: StateFlow<DetailAnggotaUiState> = _detailUiState

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun getAnggotaByid(id_anggota: String) {
        viewModelScope.launch {
            _detailUiState.value = DetailAnggotaUiState.Loading
            _detailUiState.value = try {
                val anggota = Agt.getAnggotaByid(id_anggota)
                DetailAnggotaUiState.Success(anggota)
            } catch (e: IOException) {
                DetailAnggotaUiState.Error
            } catch (e: HttpException) {
                DetailAnggotaUiState.Error
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun updateAgt(id_anggota: String, updatedAnggota: Anggota) {
        viewModelScope.launch {
            try {
                Agt.updateAnggota(id_anggota, updatedAnggota)
                _detailUiState.value = DetailAnggotaUiState.Success(updatedAnggota)
            } catch (e: IOException) {
                _detailUiState.value = DetailAnggotaUiState.Error
            } catch (e: HttpException) {
                _detailUiState.value = DetailAnggotaUiState.Error
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun deleteAgt(id_anggota: String) {
        viewModelScope.launch {
            try {
                Agt.deleteAnggota(id_anggota)
                _detailUiState.value = DetailAnggotaUiState.Loading
            } catch (e: IOException) {
                _detailUiState.value = DetailAnggotaUiState.Error
            } catch (e: HttpException) {
                _detailUiState.value = DetailAnggotaUiState.Error
            }
        }
    }
}

sealed class DetailAnggotaUiState {
    data class Success(val anggota: Anggota) : DetailAnggotaUiState()
    object Error : DetailAnggotaUiState()
    object Loading : DetailAnggotaUiState()
}