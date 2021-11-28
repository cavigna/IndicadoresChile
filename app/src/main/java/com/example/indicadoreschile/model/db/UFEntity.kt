package com.example.indicadoreschile.model.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "uf_tabla")
data class UFEntity(

    val valor: Double,

    @PrimaryKey
    val fecha: Date
)
