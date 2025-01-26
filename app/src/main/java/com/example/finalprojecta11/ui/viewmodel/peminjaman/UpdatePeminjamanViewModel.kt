package com.example.finalprojecta11.ui.viewmodel.peminjaman

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecta11.model.Peminjaman
import com.example.finalprojecta11.repository.PeminjamanRepository
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

class UpdatePeminjamanViewModel(private val Pmjmn: PeminjamanRepository) : ViewModel() {
    var UpdateuiState by mutableStateOf(UpdatePeminjamanUiState())
        private set

    fun updateState(updateUiEvent: UpdatePeminjamanUiEvent) {
        UpdateuiState = UpdatePeminjamanUiState(updatePeminjamanUiEvent = updateUiEvent)
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun loadPeminjaman(id_peminjaman: String) {
        viewModelScope.launch {
            try {
                val peminjaman = Pmjmn.getPeminjamanByid(id_peminjaman)
                UpdateuiState = peminjaman.toUpdateUiState()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: HttpException) {
                e.printStackTrace()
            }
        }
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun updatePmjmn() {
        viewModelScope.launch {
            try {
                val peminjaman = UpdateuiState.updatePeminjamanUiEvent.toPmjmn()
                Pmjmn.updatePeminjaman(peminjaman.id_peminjaman, peminjaman)
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: HttpException) {
                e.printStackTrace()
            }
        }
    }
}

fun Peminjaman.toUpdateUiState(): UpdatePeminjamanUiState = UpdatePeminjamanUiState(
    updatePeminjamanUiEvent = toUpdateUiEvent()
)

data class UpdatePeminjamanUiState(
    val updatePeminjamanUiEvent: UpdatePeminjamanUiEvent = UpdatePeminjamanUiEvent()
)

fun Peminjaman.toUpdateUiEvent(): UpdatePeminjamanUiEvent = UpdatePeminjamanUiEvent(
    id_peminjaman = id_peminjaman,
    nama = nama,
    id_anggota = id_anggota,
    tanggal_peminjaman = tanggal_peminjaman,
    tanggal_pengembalian = tanggal_pengembalian
)

fun UpdatePeminjamanUiEvent.toPmjmn(): Peminjaman = Peminjaman(
    id_peminjaman = id_peminjaman,
    nama = nama,
    id_anggota = id_anggota,
    tanggal_peminjaman = tanggal_peminjaman,
    tanggal_pengembalian = tanggal_pengembalian
)

data class UpdatePeminjamanUiEvent(
    val id_peminjaman: String = "",
    val nama: String = "",
    val id_anggota: String = "",
    val tanggal_peminjaman: String = "",
    val tanggal_pengembalian: String = ""
)