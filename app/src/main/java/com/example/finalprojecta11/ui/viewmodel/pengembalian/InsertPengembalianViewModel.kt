package com.example.finalprojecta11.ui.viewmodel.pengembalian

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.finalprojecta11.model.Pengembalian
import com.example.finalprojecta11.repository.PengembalianRepository

class InsertPengembalianViewModel(private val Pngmbln: PengembalianRepository) : ViewModel() {
    var uiState by mutableStateOf(InsertPengembalianUiState())
        private set

    fun updateInsertPngmblnState(insertPengembalianUiEvent: InsertPengembalianUiEvent) {
        uiState = InsertPengembalianUiState(insertPengembalianUiEvent = insertPengembalianUiEvent)
    }

    suspend fun insertPngmbln() {
        try {
            Pngmbln.insertPengembalian(uiState.insertPengembalianUiEvent.toPngmbln())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun Pengembalian.toUiStatePngmbln(): InsertPengembalianUiState = InsertPengembalianUiState(
    insertPengembalianUiEvent = toInsertUiEvent()
)

data class InsertPengembalianUiState(
    val insertPengembalianUiEvent: InsertPengembalianUiEvent = InsertPengembalianUiEvent()
)

fun Pengembalian.toInsertUiEvent(): InsertPengembalianUiEvent = InsertPengembalianUiEvent(
    id_pengembalian = id_pengembalian,
    id_peminjaman = id_peminjaman,
    tanggal_dikembalikan = tanggal_dikembalikan
)

fun InsertPengembalianUiEvent.toPngmbln(): Pengembalian = Pengembalian(
    id_pengembalian = id_pengembalian,
    id_peminjaman = id_peminjaman,
    tanggal_dikembalikan = tanggal_dikembalikan
)

data class InsertPengembalianUiEvent(
    val id_pengembalian: String = "",
    val id_peminjaman: String = "",
    val tanggal_dikembalikan: String = ""
)