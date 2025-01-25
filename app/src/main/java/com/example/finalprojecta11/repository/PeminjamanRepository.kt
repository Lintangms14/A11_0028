package com.example.finalprojecta11.repository

import com.example.finalprojecta11.model.AllPeminjamanResponse
import com.example.finalprojecta11.model.Peminjaman

interface PeminjamanRepository {
    suspend fun insertPeminjaman(peminjaman: Peminjaman)

    suspend fun getPeminjaman(): AllPeminjamanResponse

    suspend fun updatePeminjaman(id_peminjaman: String, peminjaman: Peminjaman)

    suspend fun deletePeminjaman(id_peminjaman: String)

    suspend fun getPeminjamanByid(id_peminjaman: String): Peminjaman
}