package com.example.finalprojecta11.ui.view.peminjaman

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi

object DestinasiDetailPeminjaman: DestinasiNavigasi {
    override val route = "detail peminjaman"
    override val titleRes = "Detail Peminjaman"
    const val id_peminjaman = "id_peminjaman"
    val routeWithArgs = "$route/{$id_peminjaman}"
}

@Composable
private fun DeleteConfirmationDialog(
    onDeleteConfirm: () -> Unit,
    onDeleteCancel: () -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(
        onDismissRequest = { },
        title = { Text("Delete Data") },
        text = { Text("Apakah Anda Yakin Ingin Menghapus Data Ini?") },
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeleteCancel) {
                Text(text = "Cancel")
            }
        },
        confirmButton = {
            TextButton(onClick = onDeleteConfirm) {
                Text(text = "Yes")
            }
        }
    )
}
