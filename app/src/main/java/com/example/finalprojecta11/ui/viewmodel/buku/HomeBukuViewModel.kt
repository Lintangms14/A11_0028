package com.example.finalprojecta11.ui.viewmodel.buku

import android.util.Log
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

sealed class HomeUiState{
    data class Success(val buku: List<Buku>) : HomeUiState()
    object Error : HomeUiState()
    object Loading : HomeUiState()
}

class HomeBukuViewModel(private val Bk: BukuRepository) : ViewModel() {
    var BkUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getBk()
    }

    fun getBk() {
        viewModelScope.launch {
            BkUiState = HomeUiState.Loading
            BkUiState = try {
                HomeUiState.Success(Bk.getBuku().data)
            } catch (e: IOException) {
                Log.e("GetBkError", "IOException occurred: ${e.message}", e)
                HomeUiState.Error
            } catch (e: HttpException) {
                Log.e("GetBkError", "HttpException occurred: ${e.message}", e)
                HomeUiState.Error
            }
        }
    }


    fun deleteBk(id_buku: String){
        viewModelScope.launch {
            try {
                Bk.deleteBuku(id_buku)
            } catch (e: IOException){
                HomeUiState.Error
            } catch (e: HttpException){
                HomeUiState.Error
            }
        }
    }
}