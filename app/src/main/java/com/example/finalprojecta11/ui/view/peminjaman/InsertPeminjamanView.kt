package com.example.finalprojecta11.ui.view.peminjaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finalprojecta11.ui.customewidget.CostumeTopAppBar
import com.example.finalprojecta11.ui.navigation.DestinasiNavigasi
import com.example.finalprojecta11.ui.viewmodel.PenyediaViewModel
import com.example.finalprojecta11.ui.viewmodel.peminjaman.InsertPeminjamanUiEvent
import com.example.finalprojecta11.ui.viewmodel.peminjaman.InsertPeminjamanUiState
import com.example.finalprojecta11.ui.viewmodel.peminjaman.InsertPeminjamanViewModel
import kotlinx.coroutines.launch

object DestinasiEntryPeminjaman: DestinasiNavigasi {
    override val route = "item_peminjaman"
    override val titleRes = "Insert Peminjaman"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryPmjmnScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: InsertPeminjamanViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CostumeTopAppBar(
                title = DestinasiEntryPeminjaman.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ){
            innerPadding ->
        EntryBody(
            insertPeminjamanUiState = viewModel.uiState,
            onPeminjamanValueChange = viewModel::updateInsertPmjmnState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.insertPmjmn()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )
    }
}

@Composable
fun EntryBody(
    insertPeminjamanUiState: InsertPeminjamanUiState,
    onPeminjamanValueChange: (InsertPeminjamanUiEvent) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.spacedBy(18.dp),
        modifier = modifier.padding(12.dp)
    ){
        FormInput(
            insertPeminjamanUiEvent = insertPeminjamanUiState.insertPeminjamanUiEvent,
            onValueChange = onPeminjamanValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = onSaveClick,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ){
            Text(text = "Simpan")
        }
    }
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