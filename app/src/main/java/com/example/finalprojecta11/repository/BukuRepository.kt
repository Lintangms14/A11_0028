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

class NetworkBukuRepository(
    private val bukuApiService: BukuService
) : BukuRepository {

    override suspend fun insertBuku(buku: Buku) {
        bukuApiService.insertBuku(buku)
    }

    override suspend fun updateBuku(id_buku: String, buku: Buku) {
        bukuApiService.updateBuku(id_buku, buku)
    }

    override suspend fun getBuku(): AllBukuResponse {
        return bukuApiService.getAllBuku()
    }

    override suspend fun deleteBuku(id_buku: String) {
        try {
            val reponse = bukuApiService.deleteBuku(id_buku)
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

    override suspend fun getBukuByid(id_buku: String): Buku {
        return bukuApiService.getBukuByid(id_buku).data
    }
}