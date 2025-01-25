package com.example.finalprojecta11.repository

import com.example.finalprojecta11.model.AllPengembalianResponse
import com.example.finalprojecta11.model.Pengembalian

interface PengembalianRepository {
    suspend fun insertPengembalian(pengembalian: Pengembalian)

    suspend fun getPengembalian(): AllPengembalianResponse

    suspend fun getPengembalianByid(id_pengembalian: String): Pengembalian
}