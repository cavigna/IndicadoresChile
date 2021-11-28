package com.example.indicadoreschile.model.api


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "indicadores_diarios")
data class IndicadorUF(

    @SerializedName("Fecha")
    var fecha: String = "",

    @SerializedName("Valor")
    var valor: String = "",

    var nombre: String = "",

    @PrimaryKey
    var fechaLong: Long = 0L
)