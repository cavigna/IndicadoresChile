package com.example.indicadoreschile.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.indicadoreschile.model.db.USDEntity
import com.example.indicadoreschile.model.db.UFEntity
import kotlinx.coroutines.flow.Flow
import java.util.*


@Dao
interface IndicadorDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun agregarUf(uf: UFEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun agregarListadoUF(listauf: List<UFEntity>)

    @Query("SELECT * FROM uf_tabla")
    fun listarUF(): Flow<List<UFEntity>>

    @Query("SELECT * FROM uf_tabla where fecha =:fecha") //SELECT * FROM uf_tabla where fecha =1637118000000
    fun UfHoy(fecha: Date?): Flow<UFEntity>


    /* <============= DOLAR =========> */

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun agregarListadoUSD(listaUSD: List<USDEntity>)

    @Query("SELECT * FROM usd_tabla where fecha =:fecha") //SELECT * FROM uf_tabla where fecha =1637118000000
    fun usdHoy(fecha: Date?): Flow<USDEntity>



}