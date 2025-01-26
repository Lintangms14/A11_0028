package com.example.finalprojecta11.ui.view.pengembalian

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
import com.example.finalprojecta11.ui.viewmodel.pengembalian.InsertPengembalianUiEvent

object DestinasiEntryPengembalian: DestinasiNavigasi {
    override val route = "item_pengembalian"
    override val titleRes = "Insert Pengembalian"
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