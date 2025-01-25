package com.example.finalprojecta11.ui.viewmodel.buku

import com.example.finalprojecta11.model.Buku

fun Buku.toUiStateBk(): InsertUiState = InsertUiState(
    insertUiEvent = toInsertUiEvent()
)

data class InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent()
)

fun Buku.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
    id_buku = id_buku,
    judul = judul,
    penulis = penulis,
    kategori = kategori,
    status = status
)

fun InsertUiEvent.toBk(): Buku = Buku(
    id_buku = id_buku,
    judul = judul,
    penulis = penulis,
    kategori = kategori,
    status = status
)

data class InsertUiEvent(
    val id_buku: String = "",
    val judul: String = "",
    val penulis: String = "",
    val kategori: String = "",
    val status: String = ""
)