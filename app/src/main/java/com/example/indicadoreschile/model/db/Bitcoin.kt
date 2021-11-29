package com.example.indicadoreschile.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bitcoin_tabla")
data class Bitcoin(
    @PrimaryKey
    var fecha: String = "",

    var valor: Double = 0.0
)
