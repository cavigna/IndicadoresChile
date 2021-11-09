package com.example.indicadoreschile.repository

import com.example.indicadoreschile.network.CryptoApi
import com.example.indicadoreschile.network.IndiceApi


class Repository(private val api: IndiceApi, private val cryptoApi: CryptoApi) {





    suspend fun listadoIndicador(indicador: String) = api.listadoIndicador(indicador)

    suspend fun ethereum() = cryptoApi.ethereum()
}

/*
    suspend fun listadoUf() = api.listadoUf()

        ////suspend fun ufDeHoy(fecha:String) = api.ufDeHoy(fecha)

   // suspend fun indiceDeHoy(indice:String) = api.indiceDeHoy(indice, HOY)
 */