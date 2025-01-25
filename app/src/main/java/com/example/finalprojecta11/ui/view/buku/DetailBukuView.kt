package com.example.finalprojecta11.ui.view.buku

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi

object DestinasiDetail: DestinasiNavigasi {
    override val route = "detail buku"
    override val titleRes = "Detail Buku"
    const val id_buku = "id_buku"
    val routeWithArgs = "$route/{$id_buku}"
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
