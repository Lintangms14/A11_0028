package com.example.finalprojecta11.ui.viewmodel.anggota

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecta11.model.Anggota
import com.example.finalprojecta11.repository.AnggotaRepository
import kotlinx.coroutines.launch

class InsertAnggotaViewModel(private val Agt: AnggotaRepository) : ViewModel() {
    var uiState by mutableStateOf(InsertAnggotaUiState())
        private set

    fun updateInsertAgtState(insertAnggotaUiEvent: InsertAnggotaUiEvent) {
        uiState = InsertAnggotaUiState(insertAnggotaUiEvent = insertAnggotaUiEvent)
    }

    suspend fun insertAgt() {
        viewModelScope.launch {
            try {
                Agt.insertAnggota(uiState.insertAnggotaUiEvent.toAgt())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

fun Anggota.toUiStateAgt(): InsertAnggotaUiState = InsertAnggotaUiState(
    insertAnggotaUiEvent = toInsertUiEvent()
)

data class InsertAnggotaUiState(
    val insertAnggotaUiEvent: InsertAnggotaUiEvent = InsertAnggotaUiEvent()
)


fun Anggota.toInsertUiEvent(): InsertAnggotaUiEvent = InsertAnggotaUiEvent(
    id_anggota = id_anggota,
    nama = nama,
    email = email,
    nomor_telepon = nomor_telepon
)

fun InsertAnggotaUiEvent.toAgt(): Anggota = Anggota(
    id_anggota = id_anggota,
    nama = nama,
    email = email,
    nomor_telepon = nomor_telepon
)

data class InsertAnggotaUiEvent(
    val id_anggota: String = "",
    val nama: String = "",
    val email: String = "",
    val nomor_telepon: String = ""
)