package com.example.indicadoreschile.app

import android.content.Context
import com.example.indicadoreschile.db.BaseDeDatos
import com.example.indicadoreschile.network.CryptoApi
import com.example.indicadoreschile.network.IndiceApi
import com.example.indicadoreschile.repository.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer(context: Context) {


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

    private val database by lazy { BaseDeDatos.getDataBase(context) }

    val repository = Repository(retrofit, retrofitCrypto, database.dao())

    /*
        DB

        repositorio = Repository(retrofit, DB)
     */



    //val factory = IndiceViewModel(repository)
}

/*
https://api.coingecko.com/api/v3/simple/price?ids=ethereum&vs_currencies=usd&include_24hr_change=true
 */