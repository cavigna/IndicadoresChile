package com.example.indicadoreschile.app

import android.app.Application
import com.example.indicadoreschile.db.BaseDeDatos
import com.example.indicadoreschile.network.CryptoApi
import com.example.indicadoreschile.network.IndiceApi
import com.example.indicadoreschile.repository.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IndiceApplication : Application() {

    //val appContainer = AppContainer(this)

    private val retrofit by lazy {
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

    private val database by lazy {  BaseDeDatos.getDataBase(this) }

    val repository by lazy { Repository(retrofit, retrofitCrypto, database.dao()) }
}