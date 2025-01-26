package com.example.finalprojecta11.ui.view.peminjaman

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
import com.example.finalprojecta11.ui.viewmodel.peminjaman.InsertPeminjamanUiEvent

object DestinasiEntryPeminjaman: DestinasiNavigasi {
    override val route = "item_peminjaman"
    override val titleRes = "Insert Peminjaman"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput(
    insertPeminjamanUiEvent: InsertPeminjamanUiEvent,
    modifier: Modifier = Modifier,
    onValueChange: (InsertPeminjamanUiEvent) -> Unit = {},
    enabled: Boolean = true

){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        OutlinedTextField(
            value = insertPeminjamanUiEvent.id_peminjaman,
            onValueChange = {onValueChange(insertPeminjamanUiEvent.copy(id_peminjaman = it))},
            label = { Text(text = "Id Peminjaman") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertPeminjamanUiEvent.nama,
            onValueChange = {onValueChange(insertPeminjamanUiEvent.copy(nama = it))},
            label = { Text(text = "Nama") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertPeminjamanUiEvent.id_anggota,
            onValueChange = {onValueChange(insertPeminjamanUiEvent.copy(id_anggota = it))},
            label = { Text(text = "Id Anggota") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertPeminjamanUiEvent.tanggal_peminjaman,
            onValueChange = {onValueChange(insertPeminjamanUiEvent.copy(tanggal_peminjaman = it))},
            label = { Text(text = "Tanggal Peminjaman") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertPeminjamanUiEvent.tanggal_pengembalian,
            onValueChange = {onValueChange(insertPeminjamanUiEvent.copy(tanggal_pengembalian = it))},
            label = { Text(text = "Tanggal Pengembalian") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}