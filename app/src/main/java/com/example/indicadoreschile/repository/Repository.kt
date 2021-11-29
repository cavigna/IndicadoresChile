package com.example.indicadoreschile.repository

import androidx.lifecycle.asLiveData
import com.example.indicadoreschile.db.IndiceDao
import com.example.indicadoreschile.network.CryptoApi
import com.example.indicadoreschile.network.IndiceApi
import com.example.indicadoreschile.utils.*


class Repository(
    private val api: IndiceApi,
    private val cryptoApi: CryptoApi,
    private val dao: IndiceDao
) {





    suspend fun listadoIndicador(indicador: String) = api.listadoIndicador(indicador)

    suspend fun ethereum() = cryptoApi.ethereum()


    private suspend fun listadoUFAPI() = api.listadoIndicadorAnual("uf", 2021)
    private suspend fun listadoDolarAPI() = api.listadoIndicadorAnual("dolar", 2021)
    private suspend fun listadoEuroAPI() = api.listadoIndicadorAnual("euro", 2021)
    private suspend fun listadoUTMAPI() = api.listadoIndicadorAnual("utm", 2021)
    private suspend fun listadoBitcoinApi() = api.listadoIndicadorAnual("bitcoin", 2021)

    suspend fun agregarDB() {
        dao.agregarListadoUF(convertirUfEntidad(listadoUFAPI().indicador))
        dao.agregarListadoDolar(convertirDolarEntidad(listadoDolarAPI().indicador))
        dao.agregarListadoEuro(convertirEuroEntidad(listadoEuroAPI().indicador))
        dao.agregarListadoUTM(convertirUTMEntidad(listadoUTMAPI().indicador))
        if(listadoUTM().asLiveData().value?.isEmpty() == true) {

        }
        dao.agregarListadoBitcoin(convertirBitcoinEntidad(listadoBitcoinApi().indicador))
    }


    fun listadoUF() = dao.listadoUFDB()
    fun listadoDolar() = dao.listadoDolar()
    fun listadoEuro() = dao.listadoEuro()
    fun listadoUTM() = dao.listadoUTMDB()
    fun listadoBitcoin() = dao.listadoBitcoinDB()
    fun ufHoy() = dao.ufHoy(hoyDia())
    fun dolarHoy() = dao.dolarHoy(hoyDia())
}

/*
    suspend fun listadoUf() = api.listadoUf()

        ////suspend fun ufDeHoy(fecha:String) = api.ufDeHoy(fecha)

   // suspend fun indiceDeHoy(indice:String) = api.indiceDeHoy(indice, HOY)
 */