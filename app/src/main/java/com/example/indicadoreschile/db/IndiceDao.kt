package com.example.indicadoreschile.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.indicadoreschile.model.db.*

import kotlinx.coroutines.flow.Flow

@Dao
interface IndiceDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun agregarListadoUF(listadoUF: List<UF>)

    @Query ("SELECT * FROM uf_tabla")
    fun listadoUFDB(): Flow<List<UF>>

    @Query("SELECT * FROM uf_tabla WHERE fecha =:hoy")
    fun ufHoy(hoy:String): Flow<UF>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun agregarListadoDolar(listadoDolar: List<Dolar>)

    @Query ("SELECT * FROM dolar_tabla")
    fun listadoDolar(): Flow<List<Dolar>>

    @Query("SELECT * FROM dolar_tabla WHERE fecha =:hoy")
    fun dolarHoy(hoy:String): Flow<Dolar>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun agregarListadoEuro(listadoEuro: List<Euro>)

    @Query ("SELECT * FROM euro_tabla")
    fun listadoEuro(): Flow<List<Euro>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun agregarListadoUTM(listadoUTM: List<UTM>)

    @Query ("SELECT * FROM utm_tabla")
    fun listadoUTMDB(): Flow<List<UTM>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun agregarListadoBitcoin(listadoBitcoin: List<Bitcoin>)

    @Query ("SELECT * FROM bitcoin_tabla")
    fun listadoBitcoinDB(): Flow<List<Bitcoin>>


}

/*
@Query("SELECT * FROM uf_tabla WHERE fecha LIKE '%' || :hoy || '%'")
    fun ufHoy(hoy:String): Flow<List<UF>>
 */