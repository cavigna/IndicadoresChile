package com.example.indicadoreschile.network

import com.example.indicadoreschile.model.ResIndicador
import retrofit2.http.GET
import retrofit2.http.Path

interface IndiceApi {

    @GET("{indicador}")
    suspend fun listadoIndicador(@Path("indicador") indicador: String): ResIndicador
}