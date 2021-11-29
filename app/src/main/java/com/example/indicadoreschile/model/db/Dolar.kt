package com.example.indicadoreschile.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dolar_tabla")
data class Dolar(
    @PrimaryKey
    var fecha: String = "",

    var valor: Double = 0.0
)
