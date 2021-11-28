package com.example.indicadoreschile.repository

import android.os.Build
import com.example.indicadoreschile.db.IndicadorDao
import com.example.indicadoreschile.model.db.UFEntity
import com.example.indicadoreschile.model.db.USDEntity
import com.example.indicadoreschile.network.CmfApiService
import com.example.indicadoreschile.network.CryptoApi
import com.example.indicadoreschile.network.IndiceApi
import com.example.indicadoreschile.utils.Utilidades
import com.example.indicadoreschile.utils.formateameElValor
import com.example.indicadoreschile.utils.formateamelafecha
import com.example.indicadoreschile.utils.fromTimestamp
import java.text.ParseException


class Repository(
    private val api: IndiceApi,
    private val cryptoApi: CryptoApi,
    private val apiCmf: CmfApiService,
    private val dao: IndicadorDao
) {


    suspend fun listadoIndicador(indicador: String) = api.listadoIndicador(indicador)

    suspend fun ethereum() = cryptoApi.ethereum()

    suspend fun traerListadoUFAPI() = apiCmf.listadoUFAnual()

    suspend fun traerListadoUSDAPI() = apiCmf.listadoAnual("dolar")

    suspend fun agregarListadoUFDB(listaUF: List<UFEntity>) = dao.agregarListadoUF(listaUF)


    fun ufHoy() = dao.UfHoy(fromTimestamp(Utilidades.hoyLong))


    suspend fun agregarListadoUSDB() {

        val listadoUSD = traerListadoUSDAPI().indicadores
        val listadoUSDB = mutableListOf<USDEntity>()

        listadoUSD.forEach { indicadorApi->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                    listadoUSDB.add(
                        USDEntity(formateameElValor(indicadorApi.valor)?:0.0,
                            formateamelafecha(indicadorApi.fecha)
                        )
                    )

            }
        }


        dao.agregarListadoUSD(listadoUSDB)
    }

    fun usdHOY () = dao.usdHoy(fromTimestamp(Utilidades.hoyLong))



}

/*
    suspend fun listadoUf() = api.listadoUf()

        ////suspend fun ufDeHoy(fecha:String) = api.ufDeHoy(fecha)

   // suspend fun indiceDeHoy(indice:String) = api.indiceDeHoy(indice, HOY)
 */

/*
    suspend fun agregarListadoUSDB() {

        val listadoUSD = traerListadoUSDAPI().indicadores
        val listadoUSDB = mutableListOf<USDEntity>()

        listadoUSD.forEach { indicadorApi->
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                try {
                    listadoUSDB.add(
                        USDEntity(formateameElValor(indicadorApi.valor),
                            formateamelafecha(indicadorApi.valor)
                        )
                    )
                }catch (e: ParseException){

                }
            }
        }


        dao.agregarListadoUSD(listadoUSDB)
    }
 */