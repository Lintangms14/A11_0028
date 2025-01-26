package com.example.finalprojecta11.ui.viewmodel.peminjaman

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.finalprojecta11.model.Peminjaman
import com.example.finalprojecta11.repository.PeminjamanRepository

class InsertPeminjamanViewModel(private val Pmjmn: PeminjamanRepository) : ViewModel() {
    var uiState by mutableStateOf(InsertPeminjamanUiState())
        private set

    fun updateInsertPmjmnState(insertPeminjamanUiEvent: InsertPeminjamanUiEvent) {
        uiState = InsertPeminjamanUiState(insertPeminjamanUiEvent = insertPeminjamanUiEvent)
    }

    suspend fun insertPmjmn() {
        try {
            Pmjmn.insertPeminjaman(uiState.insertPeminjamanUiEvent.toPmjmn())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

fun Peminjaman.toUiStatePmjmn(): InsertPeminjamanUiState = InsertPeminjamanUiState(
    insertPeminjamanUiEvent = toInsertUiEvent()
)

data class InsertPeminjamanUiState(
    val insertPeminjamanUiEvent: InsertPeminjamanUiEvent = InsertPeminjamanUiEvent()
)

fun Peminjaman.toInsertUiEvent(): InsertPeminjamanUiEvent = InsertPeminjamanUiEvent(
    id_peminjaman = id_peminjaman,
    nama = nama,
    id_anggota = id_anggota,
    tanggal_peminjaman = tanggal_peminjaman,
    tanggal_pengembalian = tanggal_pengembalian
)

fun InsertPeminjamanUiEvent.toPmjmn(): Peminjaman = Peminjaman(
    id_peminjaman = id_peminjaman,
    nama = nama,
    id_anggota = id_anggota,
    tanggal_peminjaman = tanggal_peminjaman,
    tanggal_pengembalian = tanggal_pengembalian
)

data class InsertPeminjamanUiEvent(
    val id_peminjaman: String = "",
    val nama: String = "",
    val id_anggota: String = "",
    val tanggal_peminjaman: String = "",
    val tanggal_pengembalian: String = ""
)
