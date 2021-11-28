package com.example.indicadoreschile.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "usd_tabla")
data class USDEntity(
    val valor: Double,

    @PrimaryKey
    val fecha: Date
)