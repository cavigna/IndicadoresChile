package com.example.indicadoreschile.network

import com.example.indicadoreschile.BuildConfig
import com.example.indicadoreschile.model.viejos.ResIndicador2
import retrofit2.http.GET
import retrofit2.http.Path


interface IndiceApi {

    companion object{
        val APIKEY = BuildConfig.API_KEY
    }

    @GET("{indicador2}")
    suspend fun listadoIndicador(@Path("indicador2") indicador: String): ResIndicador2


    //https://api.sbif.cl/api-sbifv3/recursos_api/uf?apikey=bfc3457479b4d58d94e2aebef7412bcca903668d&formato=json
}