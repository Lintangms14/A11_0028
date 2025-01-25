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
import com.example.finalprojecta11.ui.viewmodel.buku.InsertUiEvent

object DestinasiEntry: DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = "Insert Buku"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput(
    insertUiEvent: InsertUiEvent,
    modifier: Modifier = Modifier,
    onValueChange: (InsertUiEvent) -> Unit = {},
    enabled: Boolean = true

){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        OutlinedTextField(
            value = insertUiEvent.judul,
            onValueChange = {onValueChange(insertUiEvent.copy(judul = it))},
            label = { Text(text = "Judul")},
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.id_buku,
            onValueChange = {onValueChange(insertUiEvent.copy(id_buku = it))},
            label = { Text(text = "ID Buku")},
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.penulis,
            onValueChange = {onValueChange(insertUiEvent.copy(penulis = it))},
            label = { Text(text = "Penulis")},
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.kategori,
            onValueChange = {onValueChange(insertUiEvent.copy(kategori = it))},
            label = { Text(text = "Kategori")},
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertUiEvent.status,
            onValueChange = {onValueChange(insertUiEvent.copy(status = it))},
            label = { Text(text = "Status")},
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}