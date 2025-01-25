package com.example.finalprojecta11.repository

import com.example.finalprojecta11.model.AllBukuResponse
import com.example.finalprojecta11.model.Buku
import com.example.finalprojecta11.service.BukuService
import okio.IOException

interface BukuRepository {
    suspend fun insertBuku(buku: Buku)

    suspend fun getBuku(): AllBukuResponse

    suspend fun updateBuku(id_buku: String, buku: Buku)

    suspend fun deleteBuku(id_buku: String)

    suspend fun getBukuByid(id_buku: String): Buku
}