package com.example.finalprojecta11.ui.viewmodel.anggota

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecta11.model.Anggota
import com.example.finalprojecta11.repository.AnggotaRepository
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

class UpdateAnggotaViewModel(private val Agt: AnggotaRepository) : ViewModel() {
    var UpdateuiState by mutableStateOf(UpdateAnggotaUiState())
        private set

    fun updateState(updateUiEvent: UpdateAnggotaUiEvent) {
        UpdateuiState = UpdateAnggotaUiState(updateAnggotaUiEvent = updateUiEvent)
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun loadAnggota(id_anggota: String) {
        viewModelScope.launch {
            try {
                val anggota = Agt.getAnggotaByid(id_anggota)
                UpdateuiState = anggota.toUpdateUiState()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: HttpException) {
                e.printStackTrace()
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun updateAgt() {
        viewModelScope.launch {
            try {
                val anggota = UpdateuiState.updateAnggotaUiEvent.toAgt()
                Agt.updateAnggota(anggota.id_anggota, anggota)
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: HttpException) {
                e.printStackTrace()
            }
        }
    }
}

fun Anggota.toUpdateUiState(): UpdateAnggotaUiState = UpdateAnggotaUiState(
    updateAnggotaUiEvent = toUpdateUiEvent()
)

data class UpdateAnggotaUiState(
    val updateAnggotaUiEvent: UpdateAnggotaUiEvent = UpdateAnggotaUiEvent()
)

fun Anggota.toUpdateUiEvent(): UpdateAnggotaUiEvent = UpdateAnggotaUiEvent(
    id_anggota = id_anggota,
    nama = nama,
    email = email,
    nomor_telepon = nomor_telepon
)

fun UpdateAnggotaUiEvent.toAgt(): Anggota = Anggota(
    id_anggota = id_anggota,
    nama = nama,
    email = email,
    nomor_telepon = nomor_telepon
)

data class UpdateAnggotaUiEvent(
    val id_anggota: String = "",
    val nama: String = "",
    val email: String = "",
    val nomor_telepon: String = ""
)