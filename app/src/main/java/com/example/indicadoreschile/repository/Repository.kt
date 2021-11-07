package com.example.indicadoreschile.repository

import com.example.indicadoreschile.network.IndiceApi


class Repository(private val api: IndiceApi) {



    ////suspend fun ufDeHoy(fecha:String) = api.ufDeHoy(fecha)

   // suspend fun indiceDeHoy(indice:String) = api.indiceDeHoy(indice, HOY)

    suspend fun listadoIndicador(indicador: String) = api.listadoIndicador(indicador)
}

/*
    suspend fun listadoUf() = api.listadoUf()
 */