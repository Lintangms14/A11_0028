package com.example.finalprojecta11.ui.viewmodel.pengembalian

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojecta11.model.Pengembalian
import com.example.finalprojecta11.repository.PengembalianRepository
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed class HomePengembalianUiState{
    data class Success(val pengembalian: List<Pengembalian>) : HomePengembalianUiState()
    object Error : HomePengembalianUiState()
    object Loading : HomePengembalianUiState()
}

class HomePengembalianViewModel(private val Pngmbln: PengembalianRepository) : ViewModel() {
    var PngmblnUiState: HomePengembalianUiState by mutableStateOf(HomePengembalianUiState.Loading)
        private set

    init {
        getPngmbln()
    }

    fun getPngmbln() {
        viewModelScope.launch {
            PngmblnUiState = HomePengembalianUiState.Loading
            PngmblnUiState = try {
                HomePengembalianUiState.Success(Pngmbln.getPengembalian().data)
            } catch (e: IOException) {
                Log.e("GetPngmblnError", "IOException occurred: ${e.message}", e)
                HomePengembalianUiState.Error
            } catch (e: HttpException) {
                Log.e("GetPngmblnError", "HttpException occurred: ${e.message}", e)
                HomePengembalianUiState.Error
            }
        }
    }
}