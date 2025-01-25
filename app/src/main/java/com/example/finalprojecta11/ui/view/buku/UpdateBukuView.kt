package com.example.finalprojecta11.ui.view.buku

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi
import com.example.finalprojecta11.ui.viewmodel.buku.UpdateUiEvent


object DestinasiUpdate: DestinasiNavigasi {
    override val route = "update"
    override val titleRes = "Update Buku"
    const val id_buku = "id_buku"
    val routeWithArgs = "$route/{$id_buku}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateFormInput(
    updateUiEvent: UpdateUiEvent,
    modifier: Modifier = Modifier,
    onValueChange: (UpdateUiEvent) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = updateUiEvent.judul,
            onValueChange = { onValueChange(updateUiEvent.copy(judul = it)) },
            label = { Text(text = "Judul") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = updateUiEvent.id_buku,
            onValueChange = { onValueChange(updateUiEvent.copy(id_buku = it)) },
            label = { Text(text = "Id Buku") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false,
            singleLine = true
        )
        OutlinedTextField(
            value = updateUiEvent.penulis,
            onValueChange = { onValueChange(updateUiEvent.copy(penulis = it)) },
            label = { Text(text = "Penulis") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = updateUiEvent.kategori,
            onValueChange = { onValueChange(updateUiEvent.copy(kategori = it)) },
            label = { Text(text = "Kategori") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = updateUiEvent.status,
            onValueChange = { onValueChange(updateUiEvent.copy(status = it)) },
            label = { Text(text = "Status") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}