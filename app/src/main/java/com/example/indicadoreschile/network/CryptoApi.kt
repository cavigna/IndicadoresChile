package com.example.indicadoreschile.network

import com.example.indicadoreschile.model.Crypto
import com.example.indicadoreschile.model.Ethereum
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {

    @GET("simple/price")
    suspend fun ethereum(
        @Query("ids", encoded = true) ids: String = "ethereum",
        @Query("vs_currencies", encoded = true) vs_currencies:String = "usd",
        @Query("include_24hr_change") include_24hr_change:String = "true"
    ): Crypto


}
// https://api.coingecko.com/api/v3/simple/price?ids=ethereum&vs_currencies=usd&include_24hr_change=true
/*
https://api.coingecko.com/api/v3/simple/price?ids=ethereum&vs_currencies=usd&include_24hr_change=true
 */