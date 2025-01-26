package com.example.finalprojecta11.ui.view.pengembalian

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi
import com.example.finalprojecta11.ui.viewmodel.anggota.InsertAnggotaUiEvent
import com.example.finalprojecta11.ui.viewmodel.pengembalian.InsertPengembalianUiEvent
import com.example.finalprojecta11.ui.viewmodel.pengembalian.InsertPengembalianUiState

object DestinasiEntryPengembalian: DestinasiNavigasi {
    override val route = "item_pengembalian"
    override val titleRes = "Insert Pengembalian"
}

@Composable
fun EntryBody(
    insertPengembalianUiState: InsertPengembalianUiState,
    onPengembaliaValueChange: (InsertPengembalianUiEvent) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.spacedBy(18.dp),
        modifier = modifier.padding(12.dp)
    ){
        FormInput(
            insertPengembalianUiEvent = insertPengembalianUiState.insertPengembalianUiEvent,
            onValueChange = onPengembaliaValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Simpan")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput(
    insertPengembalianUiEvent: InsertPengembalianUiEvent,
    modifier: Modifier = Modifier,
    onValueChange: (InsertPengembalianUiEvent) -> Unit = {},
    enabled: Boolean = true

){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        OutlinedTextField(
            value = insertPengembalianUiEvent.id_pengembalian,
            onValueChange = {onValueChange(insertPengembalianUiEvent.copy(id_pengembalian = it))},
            label = { Text(text = "Id Pengembalian") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertPengembalianUiEvent.id_peminjaman,
            onValueChange = {onValueChange(insertPengembalianUiEvent.copy(id_peminjaman = it))},
            label = { Text(text = "Id Peminjaman") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertPengembalianUiEvent.tanggal_dikembalikan,
            onValueChange = {onValueChange(insertPengembalianUiEvent.copy(tanggal_dikembalikan = it))},
            label = { Text(text = "Tanggal Di kembalikan") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}