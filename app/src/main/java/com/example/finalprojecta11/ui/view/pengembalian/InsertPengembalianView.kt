package com.example.finalprojecta11.ui.view.pengembalian

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
import com.example.finalprojecta11.ui.view.anggota.DestinasiEntryAnggota
import com.example.finalprojecta11.ui.viewmodel.PenyediaViewModel
import com.example.finalprojecta11.ui.viewmodel.anggota.InsertAnggotaViewModel
import com.example.finalprojecta11.ui.viewmodel.pengembalian.InsertPengembalianUiEvent
import com.example.finalprojecta11.ui.viewmodel.pengembalian.InsertPengembalianUiState
import com.example.finalprojecta11.ui.viewmodel.pengembalian.InsertPengembalianViewModel
import kotlinx.coroutines.launch

object DestinasiEntryPengembalian: DestinasiNavigasi {
    override val route = "item_pengembalian"
    override val titleRes = "Insert Pengembalian"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryPngmblnScreen(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: InsertPengembalianViewModel = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CostumeTopAppBar(
                title = DestinasiEntryAnggota.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ){
            innerPadding ->
        EntryBody(
            insertPengembalianUiState = viewModel.uiState,
            onPengembaliaValueChange = viewModel::updateInsertPngmblnState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.insertPngmbln()
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
    insertPengembalianUiState: InsertPengembalianUiState,
    onPengembaliaValueChange: (InsertPengembalianUiEvent) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.spacedBy(18.dp),
        modifier = modifier.padding(12.dp)
    ){
        FormInput(
            insertPengembalianUiEvent = insertPengembalianUiState.insertPengembalianUiEvent,
            onValueChange = onPengembaliaValueChange,
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
    insertPengembalianUiEvent: InsertPengembalianUiEvent,
    modifier: Modifier = Modifier,
    onValueChange: (InsertPengembalianUiEvent) -> Unit = {},
    enabled: Boolean = true

){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        OutlinedTextField(
            value = insertPengembalianUiEvent.id_pengembalian,
            onValueChange = {onValueChange(insertPengembalianUiEvent.copy(id_pengembalian = it))},
            label = { Text(text = "Id Pengembalian") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertPengembalianUiEvent.id_peminjaman,
            onValueChange = {onValueChange(insertPengembalianUiEvent.copy(id_peminjaman = it))},
            label = { Text(text = "Id Peminjaman") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = insertPengembalianUiEvent.tanggal_dikembalikan,
            onValueChange = {onValueChange(insertPengembalianUiEvent.copy(tanggal_dikembalikan = it))},
            label = { Text(text = "Tanggal Di kembalikan") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}