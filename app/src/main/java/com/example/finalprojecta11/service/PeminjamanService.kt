package com.example.finalprojecta11.service

import com.example.finalprojecta11.model.AllBukuResponse
import com.example.finalprojecta11.model.AllPeminjamanResponse
import com.example.finalprojecta11.model.Buku
import com.example.finalprojecta11.model.BukuDetailResponse
import com.example.finalprojecta11.model.Peminjaman
import com.example.finalprojecta11.model.PeminjamanDetailResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PeminjamanService {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )

    @POST("store")
    suspend fun insertPeminjaman( @Body peminjaman: Peminjaman)

    @GET(".")
    suspend fun getAllPeminjaman(): AllPeminjamanResponse

    @GET("{id_peminjaman}")
    suspend fun getPeminjamanByid(@Path("id_peminjaman") id_peminjaman: String): PeminjamanDetailResponse

    @PUT("{id_peminjaman}")
    suspend fun updatePeminjaman(@Path("id_peminjaman") id_peminjaman: String, @Body peminjaman: Peminjaman)

    @DELETE("{id_peminjaman}")
    suspend fun deletePeminjaman(@Path("id_peminjaman") id_peminjaman: String): retrofit2.Response<Void>
}