package com.example.indicadoreschile.network

import com.example.indicadoreschile.BuildConfig
import com.example.indicadoreschile.model.api.IndResponseUF
import com.example.indicadoreschile.model.api.IndResponseUSD
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CmfApiService {

    companion object{
        val APIKEY = BuildConfig.API_KEY
    }


    @GET("uf/2021")
    suspend fun listadoUFAnual(
        //@Query(value = "year") year: Int = 2021,

        @Query(value = "apikey") apikey: String = APIKEY,
        @Query(value = "formato") formato:String = "json"
    ) : IndResponseUF


    @GET("{tipoIndicador}/2021")
    suspend fun listadoAnual(
        //@Query(value = "year") year: Int = 2021,
        @Path(value = "tipoIndicador") tipoIndicador :String,
        @Query(value = "apikey") apikey: String = APIKEY,
        @Query(value = "formato") formato:String = "json"
    ) : IndResponseUSD


}





//https://api.sbif.cl/api-sbifv3/recursos_api/uf?apikey=bfc3457479b4d58d94e2aebef7412bcca903668d&formato=json

//Por año
//https://api.sbif.cl/api-sbifv3/recursos_api/uf/2021?apikey=bfc3457479b4d58d94e2aebef7412bcca903668d&formato=json