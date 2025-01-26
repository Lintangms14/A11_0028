package com.example.finalprojecta11.ui.view.anggota

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
import com.example.finalprojecta11.ui.viewmodel.anggota.InsertAnggotaUiEvent

object DestinasiEntryAnggota: DestinasiNavigasi {
    override val route = "item_anggota"
    override val titleRes = "Insert Anggota"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInput(
    insertAnggotaUiEvent: InsertAnggotaUiEvent,
    modifier: Modifier = Modifier,
    onValueChange: (InsertAnggotaUiEvent) -> Unit = {},
    enabled: Boolean = true

){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        OutlinedTextField(
            value = insertAnggotaUiEvent.id_anggota,
            onValueChange = {onValueChange(insertAnggotaUiEvent.copy(id_anggota = it))},
            label = { Text(text = "Id Anggota") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertAnggotaUiEvent.nama,
            onValueChange = {onValueChange(insertAnggotaUiEvent.copy(nama = it))},
            label = { Text(text = "Nama") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertAnggotaUiEvent.email,
            onValueChange = {onValueChange(insertAnggotaUiEvent.copy(email = it))},
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertAnggotaUiEvent.nomor_telepon,
            onValueChange = {onValueChange(insertAnggotaUiEvent.copy(nomor_telepon = it))},
            label = { Text(text = "Nomor Telepon") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}