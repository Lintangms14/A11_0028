package com.example.finalprojecta11.ui.viewmodel.buku

import android.os.Build
import androidx.annotation.RequiresExtension
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

class UpdateBukuViewModel(private val Bk: BukuRepository) : ViewModel() {
    var UpdateuiState by mutableStateOf(UpdateUiState())
        private set

    fun updateState(updateUiEvent: UpdateUiEvent) {
        UpdateuiState = UpdateUiState(updateUiEvent = updateUiEvent)
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun loadBuku(id_buku: String) {
        viewModelScope.launch {
            try {
                val buku = Bk.getBukuByid(id_buku)
                UpdateuiState = buku.toUpdateUiState()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: HttpException) {
                e.printStackTrace()
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun updateBk() {
        viewModelScope.launch {
            try {
                val buku = UpdateuiState.updateUiEvent.toBk()
                Bk.updateBuku(buku.id_buku, buku)
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: HttpException) {
                e.printStackTrace()
            }
        }
    }
}

fun Buku.toUpdateUiState(): UpdateUiState = UpdateUiState(
    updateUiEvent = toUpdateUiEvent()
)

data class UpdateUiState(
    val updateUiEvent: UpdateUiEvent = UpdateUiEvent()
)

fun Buku.toUpdateUiEvent(): UpdateUiEvent = UpdateUiEvent(
    id_buku = id_buku,
    judul = judul,
    penulis = penulis,
    kategori = kategori,
    status = status
)

fun UpdateUiEvent.toBk(): Buku = Buku(
    id_buku = id_buku,
    judul = judul,
    penulis = penulis,
    kategori = kategori,
    status = status
)

data class UpdateUiEvent(
    val id_buku: String = "",
    val judul: String = "",
    val penulis: String = "",
    val kategori: String = "",
    val status: String = ""
)