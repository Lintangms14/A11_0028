package com.example.finalprojecta11.ui.view.pengembalian

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojecta11.model.Pengembalian
import com.example.finalprojecta11.ui.customewidget.CostumeTopAppBar
import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi
import com.example.finalprojecta11.ui.view.peminjaman.ComponentDetailAgt
import com.example.finalprojecta11.ui.viewmodel.PenyediaViewModel
import com.example.finalprojecta11.ui.viewmodel.pengembalian.DetailPengembalianUiState
import com.example.finalprojecta11.ui.viewmodel.pengembalian.DetailPengembalianViewModel

object DestinasiDetailPemngembalian: DestinasiNavigasi {
    override val route = "detail pengembalian"
    override val titleRes = "Detail Pengembalian"
    const val id_pengembalian = "id_pengembalian"
    val routeWithArgs = "$route/{$id_pengembalian}"
}

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailPengembalianView(
    id_pengembalian: String,
    modifier: Modifier = Modifier,
    viewModel: DetailPengembalianViewModel = viewModel(factory = PenyediaViewModel.Factory),
    navigateBack: () -> Unit,
    onEditClick: (String) -> Unit = { },
    onDeleteClick: () -> Unit = { }
) {

    LaunchedEffect(id_pengembalian) {
        viewModel.getPengembalianByid(id_pengembalian)
    }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CostumeTopAppBar(
                title = DestinasiDetailPemngembalian.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ) { innerPadding ->
        val detailUiState by viewModel.detailUiState.collectAsState()

        BodyDetailPngmbln(
            modifier = modifier.padding(innerPadding),
            detailPengembalianUiState = detailUiState,
        )
    }
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