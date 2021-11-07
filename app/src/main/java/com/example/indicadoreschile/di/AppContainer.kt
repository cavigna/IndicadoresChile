package com.example.indicadoreschile.di

import com.example.indicadoreschile.network.IndiceApi
import com.example.indicadoreschile.repository.Repository
import com.example.indicadoreschile.viewmodel.IndiceViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppContainer {


    private val retrofit by lazy    {
        Retrofit.Builder()
            .baseUrl("https://mindicador.cl/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(IndiceApi::class.java)

    }

    val repository = Repository(retrofit)

    //val factory = IndiceViewModel(repository)
}