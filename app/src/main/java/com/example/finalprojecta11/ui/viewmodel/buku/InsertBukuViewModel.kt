package com.example.finalprojecta11.ui.viewmodel.buku

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecta11.model.Buku
import com.example.finalprojecta11.repository.BukuRepository
import kotlinx.coroutines.launch

class InsertBukuViewModel(private val Bk: BukuRepository) : ViewModel() {
    var uiState by mutableStateOf(InsertUiState())
        private set

    fun updateInsertBkState(insertUiEvent: InsertUiEvent){
        uiState = InsertUiState(insertUiEvent = insertUiEvent)
    }

    suspend fun insertBk(){
        viewModelScope.launch {
            try {
                Bk.insertBuku(uiState.insertUiEvent.toBk())
            } catch (e: Exception){
                e.printStackTrace()
            }
        }
    }
}

fun Buku.toUiStateBk(): InsertUiState = InsertUiState(
    insertUiEvent = toInsertUiEvent()
)

data class InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent()
)

fun Buku.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
    id_buku = id_buku,
    judul = judul,
    penulis = penulis,
    kategori = kategori,
    status = status
)

fun InsertUiEvent.toBk(): Buku = Buku(
    id_buku = id_buku,
    judul = judul,
    penulis = penulis,
    kategori = kategori,
    status = status
)

data class InsertUiEvent(
    val id_buku: String = "",
    val judul: String = "",
    val penulis: String = "",
    val kategori: String = "",
    val status: String = ""
)