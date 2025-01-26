package com.example.finalprojecta11.ui.view.peminjaman

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalprojecta11.model.Peminjaman
import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi
import com.example.finalprojecta11.ui.viewmodel.peminjaman.DetailPeminjamanUiState

object DestinasiDetailPeminjaman: DestinasiNavigasi {
    override val route = "detail peminjaman"
    override val titleRes = "Detail Peminjaman"
    const val id_peminjaman = "id_peminjaman"
    val routeWithArgs = "$route/{$id_peminjaman}"
}

@Composable
fun BodyDetailPmjmn(
    modifier: Modifier = Modifier,
    detailPeminjamanUiState: DetailPeminjamanUiState,
    onDeleteClick: () -> Unit = { }
) {
    var deleteConfirmationRequired by rememberSaveable { mutableStateOf(false) }

    when (detailPeminjamanUiState) {
        is DetailPeminjamanUiState.Loading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is DetailPeminjamanUiState.Success -> {
            Column(
                modifier = modifier.fillMaxWidth().padding(16.dp)
            ) {
                ItemDetailPmjmn(
                    peminjaman = detailPeminjamanUiState.peminjaman,
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Button(
                    onClick = { deleteConfirmationRequired = true },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Delete")
                }

                if (deleteConfirmationRequired) {
                    DeleteConfirmationDialog(
                        onDeleteConfirm = {
                            deleteConfirmationRequired = false
                            onDeleteClick()
                        },
                        onDeleteCancel = { deleteConfirmationRequired = false },
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
        is DetailPeminjamanUiState.Error -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Data Tidak Ditemukan",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}


@Composable
fun ItemDetailPmjmn(
    modifier: Modifier = Modifier,
    peminjaman: Peminjaman,
) {
    Card (
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Column (
            modifier = Modifier.padding(16.dp)
        ){
            ComponentDetailAgt(judul = "Id Peminjaman", isinya = peminjaman.id_peminjaman)
            Spacer(modifier = Modifier.padding(4.dp))

            ComponentDetailAgt(judul = "Nama", isinya = peminjaman.nama)
            Spacer(modifier = Modifier.padding(4.dp))

            ComponentDetailAgt(judul = "Id Anggota", isinya = peminjaman.id_anggota)
            Spacer(modifier = Modifier.padding(4.dp))

            ComponentDetailAgt(judul = "Tanggal Peminjaman", isinya = peminjaman.tanggal_peminjaman)
            Spacer(modifier = Modifier.padding(4.dp))

            ComponentDetailAgt(judul = "Tanggal Pengembalian", isinya = peminjaman.tanggal_pengembalian)
            Spacer(modifier = Modifier.padding(4.dp))
        }
    }
}


@Composable
fun ComponentDetailAgt(
    modifier: Modifier = Modifier,
    judul: String,
    isinya: String
) {
    Column (
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = "$judul : ",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )

        Text(
            text = isinya,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
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
