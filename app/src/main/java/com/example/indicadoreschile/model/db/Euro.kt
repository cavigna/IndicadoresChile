package com.example.indicadoreschile.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "euro_tabla")
data class Euro(
    @PrimaryKey
    var fecha: String = "",

    var valor: Double = 0.0
)
