package com.example.finalprojecta11.repository

import com.example.finalprojecta11.model.AllPeminjamanResponse
import com.example.finalprojecta11.model.Peminjaman
import com.example.finalprojecta11.service.PeminjamanService
import okio.IOException

interface PeminjamanRepository {
    suspend fun insertPeminjaman(peminjaman: Peminjaman)

    suspend fun getPeminjaman(): AllPeminjamanResponse

    suspend fun updatePeminjaman(id_peminjaman: String, peminjaman: Peminjaman)

    suspend fun deletePeminjaman(id_peminjaman: String)

    suspend fun getPeminjamanByid(id_peminjaman: String): Peminjaman
}

class NetworkPeminjamanRepository(
    private val peminjamanApiService: PeminjamanService
) : PeminjamanRepository {

    override suspend fun insertPeminjaman(peminjaman: Peminjaman) {
        peminjamanApiService.insertPeminjaman(peminjaman)
    }

    override suspend fun updatePeminjaman(id_peminjaman: String, peminjaman: Peminjaman) {
        peminjamanApiService.updatePeminjaman(id_peminjaman, peminjaman)
    }

    override suspend fun getPeminjaman(): AllPeminjamanResponse {
        return peminjamanApiService.getAllPeminjaman()
    }

    override suspend fun deletePeminjaman(id_peminjaman: String) {
        try {
            val reponse = peminjamanApiService.deletePeminjaman(id_peminjaman)
            if (!reponse.isSuccessful) {
                throw IOException("Failed to delete kontak. HTTP Status code: " +
                        "${reponse.code()}")
            } else {
                reponse.message()
                println(reponse.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getPeminjamanByid(id_peminjaman: String): Peminjaman {
        return peminjamanApiService.getPeminjamanByid(id_peminjaman).data
    }
}