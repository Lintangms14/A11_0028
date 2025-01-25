package com.example.finalprojecta11.service

import com.example.finalprojecta11.model.AllPeminjamanResponse
import com.example.finalprojecta11.model.AllPengembalianResponse
import com.example.finalprojecta11.model.Peminjaman
import com.example.finalprojecta11.model.PeminjamanDetailResponse
import com.example.finalprojecta11.model.Pengembalian
import com.example.finalprojecta11.model.PengembalianDetailResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PengembalianService {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )

    @POST("store")
    suspend fun insertPengembalian( @Body pengembalian: Pengembalian)

    @GET(".")
    suspend fun getAllPengembalian(): AllPengembalianResponse

    @GET("{id_pengembalian}")
    suspend fun getPengembalianByid(@Path("id_pengembalian") id_pengembalian: String): PengembalianDetailResponse
}