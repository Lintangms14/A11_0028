package com.example.finalprojecta11.repository

import com.example.finalprojecta11.model.AllPengembalianResponse
import com.example.finalprojecta11.model.Pengembalian
import com.example.finalprojecta11.service.PengembalianService

interface PengembalianRepository {
    suspend fun insertPengembalian(pengembalian: Pengembalian)

    suspend fun getPengembalian(): AllPengembalianResponse

    suspend fun getPengembalianByid(id_pengembalian: String): Pengembalian
}

class NetworkPengembalianRepository(
    private val pengembalianApiService: PengembalianService
) : PengembalianRepository {

    override suspend fun insertPengembalian(pengembalian: Pengembalian) {
        pengembalianApiService.insertPengembalian(pengembalian)
    }

    override suspend fun getPengembalian(): AllPengembalianResponse {
        return pengembalianApiService.getAllPengembalian()
    }

    override suspend fun getPengembalianByid(id_pengembalian: String): Pengembalian {
        return pengembalianApiService.getPengembalianByid(id_pengembalian).data
    }
}