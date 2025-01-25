package com.example.finalprojecta11.repository

import com.example.finalprojecta11.model.AllAnggotaResponse
import com.example.finalprojecta11.model.Anggota
import com.example.finalprojecta11.service.AnggotaService
import okio.IOException

interface AnggotaRepository {
    suspend fun insertAnggota(anggota: Anggota)

    suspend fun getAnggota(): AllAnggotaResponse

    suspend fun updateAnggota(id_anggota: String, anggota: Anggota)

    suspend fun deleteAnggota(id_anggota: String)

    suspend fun getAnggotaByid(id_anggota: String): Anggota
}

class NetworkAnggotaRepository(
    private val anggotaApiService: AnggotaService
) : AnggotaRepository {

    override suspend fun insertAnggota(anggota: Anggota) {
        anggotaApiService.insertAnggota(anggota)
    }

    override suspend fun updateAnggota(id_anggota: String, anggota: Anggota) {
        anggotaApiService.updateAnggota(id_anggota, anggota)
    }

    override suspend fun getAnggota(): AllAnggotaResponse {
        return anggotaApiService.getAllAnggota()
    }

    override suspend fun deleteAnggota(id_anggota: String) {
        try {
            val reponse = anggotaApiService.deleteAnggota(id_anggota)
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

    override suspend fun getAnggotaByid(id_anggota: String): Anggota {
        return anggotaApiService.getAnggotaByid(id_anggota).data
    }
}