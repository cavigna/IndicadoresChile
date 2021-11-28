package com.example.indicadoreschile.di

import android.app.Application
import com.example.indicadoreschile.db.BaseDeDatos
import com.example.indicadoreschile.network.CmfApiService
import com.example.indicadoreschile.network.CryptoApi
import com.example.indicadoreschile.network.IndiceApi
import com.example.indicadoreschile.repository.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IndiceApplication: Application() {

    val appContainer = AppContainer()

    private val retrofit by lazy    {
        Retrofit.Builder()
            .baseUrl("https://mindicador.cl/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IndiceApi::class.java)

    }


    private val retrofitCrypto by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)

    }

    private val retrofitCliente by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.sbif.cl/api-sbifv3/recursos_api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CmfApiService::class.java)
    }

    private val database: BaseDeDatos by lazy { BaseDeDatos.getDataBase(this) }

    val repository by lazy { Repository(retrofit, retrofitCrypto, retrofitCliente, database.dao()) }
}