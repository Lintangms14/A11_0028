package com.example.finalprojecta11.ui.viewmodel.anggota

import android.util.Log
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

sealed class HomeAnggotaUiState{
    data class Success(val anggota: List<Anggota>) : HomeAnggotaUiState()
    object Error : HomeAnggotaUiState()
    object Loading : HomeAnggotaUiState()
}

class HomeAnggotaViewModel(private val Agt: AnggotaRepository) : ViewModel() {
    var AgtUiState: HomeAnggotaUiState by mutableStateOf(HomeAnggotaUiState.Loading)
        private set

    init {
        getAgt()
    }

    fun getAgt() {
        viewModelScope.launch {
            AgtUiState = HomeAnggotaUiState.Loading
            AgtUiState = try {
                HomeAnggotaUiState.Success(Agt.getAnggota().data)
            } catch (e: IOException) {
                Log.e("GetAgtError", "IOException occurred: ${e.message}", e)
                HomeAnggotaUiState.Error
            } catch (e: HttpException) {
                Log.e("GetAgtError", "HttpException occurred: ${e.message}", e)
                HomeAnggotaUiState.Error
            }
        }
    }


    fun deleteAgt(id_anggota: String){
        viewModelScope.launch {
            try {
                Agt.deleteAnggota(id_anggota)
            } catch (e: IOException){
                HomeAnggotaUiState.Error
            } catch (e: HttpException){
                HomeAnggotaUiState.Error
            }
        }
    }
}