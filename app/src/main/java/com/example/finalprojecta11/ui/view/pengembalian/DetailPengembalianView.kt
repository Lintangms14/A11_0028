package com.example.finalprojecta11.ui.view.pengembalian

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalprojecta11.model.Pengembalian
import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi
import com.example.finalprojecta11.ui.view.peminjaman.ComponentDetailAgt
import com.example.finalprojecta11.ui.viewmodel.pengembalian.DetailPengembalianUiState

object DestinasiDetailPemngembalian: DestinasiNavigasi {
    override val route = "detail pengembalian"
    override val titleRes = "Detail Pengembalian"
    const val id_pengembalian = "id_pengembalian"
    val routeWithArgs = "$route/{$id_pengembalian}"
}

@Composable
fun BodyDetailPngmbln(
    modifier: Modifier = Modifier,
    detailPengembalianUiState: DetailPengembalianUiState,
    onDeleteClick: () -> Unit = { }
) {
    when (detailPengembalianUiState) {
        is DetailPengembalianUiState.Loading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is DetailPengembalianUiState.Success -> {
            Column(
                modifier = modifier.fillMaxWidth().padding(16.dp)
            ) {
                ItemDetailPngmbln(
                    pengembalian = detailPengembalianUiState.pengembalian,
                    modifier = Modifier
                )
            }
        }
        is DetailPengembalianUiState.Error -> {
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
fun ItemDetailPngmbln(
    modifier: Modifier = Modifier,
    pengembalian: Pengembalian,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            ComponentDetailAgt(judul = "Id Pengembalian", isinya = pengembalian.id_pengembalian)
            Spacer(modifier = Modifier.padding(4.dp))

            ComponentDetailAgt(judul = "Id Peminjaman", isinya = pengembalian.id_peminjaman)
            Spacer(modifier = Modifier.padding(4.dp))

            ComponentDetailAgt(
                judul = "Tanggal Di kembalikan",
                isinya = pengembalian.tanggal_dikembalikan
            )
            Spacer(modifier = Modifier.padding(4.dp))
        }
    }

    @Composable
    fun ComponentDetailPngmbln(
        modifier: Modifier = Modifier,
        judul: String,
        isinya: String
    ) {
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
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
}