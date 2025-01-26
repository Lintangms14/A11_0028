package com.example.finalprojecta11.ui.viewmodel.peminjaman

import android.util.Log
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

sealed class HomePeminjamanUiState{
    data class Success(val peminjaman: List<Peminjaman>) : HomePeminjamanUiState()
    object Error : HomePeminjamanUiState()
    object Loading : HomePeminjamanUiState()
}

class HomePeminjamanViewModel(private val Pmjmn: PeminjamanRepository) : ViewModel() {
    var PmjmnUiState: HomePeminjamanUiState by mutableStateOf(HomePeminjamanUiState.Loading)
        private set

    init {
        getPmjmn()
    }

    fun getPmjmn() {
        viewModelScope.launch {
            PmjmnUiState = HomePeminjamanUiState.Loading
            PmjmnUiState = try {
                HomePeminjamanUiState.Success(Pmjmn.getPeminjaman().data)
            } catch (e: IOException) {
                Log.e("GetPmjmnError", "IOException occurred: ${e.message}", e)
                HomePeminjamanUiState.Error
            } catch (e: HttpException) {
                Log.e("GetPmjmnError", "HttpException occurred: ${e.message}", e)
                HomePeminjamanUiState.Error
            }
        }
    }


    fun deletePmjmn(id_peminjaman: String){
        viewModelScope.launch {
            try {
                Pmjmn.deletePeminjaman(id_peminjaman)
            } catch (e: IOException){
                HomePeminjamanUiState.Error
            } catch (e: HttpException){
                HomePeminjamanUiState.Error
            }
        }
    }
}