package com.example.finalprojecta11.service

import com.example.finalprojecta11.model.AllAnggotaResponse
import com.example.finalprojecta11.model.AllBukuResponse
import com.example.finalprojecta11.model.Anggota
import com.example.finalprojecta11.model.AnggotaDetailResponse
import com.example.finalprojecta11.model.Buku
import com.example.finalprojecta11.model.BukuDetailResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface AnggotaService {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )

    @POST("store")
    suspend fun insertAnggota( @Body anggota: Anggota)

    @GET(".")
    suspend fun getAllAnggota(): AllAnggotaResponse

    @GET("{id_anggota}")
    suspend fun getAnggotaByid(@Path("id_anggota") id_anggota: String): AnggotaDetailResponse

    @PUT("{id_anggota}")
    suspend fun updateAnggota(@Path("id_anggota") id_anggota: String, @Body anggota: Anggota)

    @DELETE("{id_anggota}")
    suspend fun deleteAnggota(@Path("id_anggota") id_anggota: String): retrofit2.Response<Void>
}