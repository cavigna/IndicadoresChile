package com.example.indicadoreschile.network

import com.example.indicadoreschile.BuildConfig
import com.example.indicadoreschile.model.ResIndicador
import retrofit2.http.GET
import retrofit2.http.Path


interface IndiceApi {

    companion object{
        val APIKEY = BuildConfig.API_KEY
    }

    @GET("{indicador}")
    suspend fun listadoIndicador(@Path("indicador") indicador: String): ResIndicador


    @GET("{indicador}/{year}")
    suspend fun listadoIndicadorAnual(
        @Path("indicador") indicador :String,
        @Path("year") year: Int

    ) : ResIndicador
}