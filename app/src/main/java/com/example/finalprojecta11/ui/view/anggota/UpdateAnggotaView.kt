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
import com.example.finalprojecta11.ui.viewmodel.anggota.UpdateAnggotaUiEvent

object DestinasiUpdateAnggota: DestinasiNavigasi {
    override val route = "update anggota"
    override val titleRes = "Update Anggota"
    const val id_anggota = "id_anggota"
    val routeWithArgs = "$route/{$id_anggota}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateFormInput(
    updateAnggotaUiEvent: UpdateAnggotaUiEvent,
    modifier: Modifier = Modifier,
    onValueChange: (UpdateAnggotaUiEvent) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = updateAnggotaUiEvent.nama,
            onValueChange = { onValueChange(updateAnggotaUiEvent.copy(nama = it)) },
            label = { Text(text = "Nama") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = updateAnggotaUiEvent.id_anggota,
            onValueChange = { onValueChange(updateAnggotaUiEvent.copy(id_anggota = it)) },
            label = { Text(text = "Id Anggota") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false,
            singleLine = true
        )
        OutlinedTextField(
            value = updateAnggotaUiEvent.email,
            onValueChange = { onValueChange(updateAnggotaUiEvent.copy(email = it)) },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = updateAnggotaUiEvent.nomor_telepon,
            onValueChange = { onValueChange(updateAnggotaUiEvent.copy(nomor_telepon = it)) },
            label = { Text(text = "Nomor Telepon") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}