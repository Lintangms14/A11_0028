package com.example.finalprojecta11.repository

import com.example.finalprojecta11.model.AllAnggotaResponse
import com.example.finalprojecta11.model.Anggota

interface AnggotaRepository {
    suspend fun insertAnggota(anggota: Anggota)

    suspend fun getAnggota(): AllAnggotaResponse

    suspend fun updateAnggota(id_anggota: String, anggota: Anggota)

    suspend fun deleteAnggota(id_anggota: String)

    suspend fun getAnggotaByid(id_anggota: String): Anggota
}