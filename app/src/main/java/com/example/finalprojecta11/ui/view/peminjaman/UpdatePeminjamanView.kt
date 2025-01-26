package com.example.finalprojecta11.ui.view.peminjaman

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
import com.example.finalprojecta11.ui.viewmodel.peminjaman.UpdatePeminjamanUiEvent
import com.example.finalprojecta11.ui.viewmodel.peminjaman.UpdatePeminjamanUiState

object DestinasiUpdatePeminjaman : DestinasiNavigasi {
    override val route = "update_peminjaman"
    override val titleRes = "Update Peminjaman"
    const val id_peminjaman = "id_peminjaman"
    val routeWithArgs = "$route/{$id_peminjaman}"
}

@Composable
fun UpdatePeminjamanBody(
    updateUiState: UpdatePeminjamanUiState,
    onValueChange: (UpdatePeminjamanUiEvent) -> Unit,
    onUpdateClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.padding(24.dp)
    ) {
        UpdatePeminjamanForm(
            updateUiEvent = updateUiState.updatePeminjamanUiEvent,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onUpdateClick,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Update")
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdatePeminjamanForm(
    updateUiEvent: UpdatePeminjamanUiEvent,
    modifier: Modifier = Modifier,
    onValueChange: (UpdatePeminjamanUiEvent) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OutlinedTextField(
            value = updateUiEvent.id_peminjaman,
            onValueChange = { onValueChange(updateUiEvent.copy(id_peminjaman = it)) },
            label = { Text(text = "ID Peminjaman") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false,
            singleLine = true
        )
        OutlinedTextField(
            value = updateUiEvent.id_anggota,
            onValueChange = { onValueChange(updateUiEvent.copy(id_anggota = it)) },
            label = { Text(text = "ID Anggota") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false,
            singleLine = true
        )
        OutlinedTextField(
            value = updateUiEvent.nama,
            onValueChange = { onValueChange(updateUiEvent.copy(nama = it)) },
            label = { Text(text = "Nama") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = updateUiEvent.tanggal_peminjaman,
            onValueChange = { onValueChange(updateUiEvent.copy(tanggal_peminjaman = it)) },
            label = { Text(text = "Tanggal Peminjaman") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = updateUiEvent.tanggal_pengembalian,
            onValueChange = { onValueChange(updateUiEvent.copy(tanggal_pengembalian = it)) },
            label = { Text(text = "Tanggal Pengembalian") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}