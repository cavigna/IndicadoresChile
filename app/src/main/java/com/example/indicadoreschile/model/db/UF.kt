package com.example.indicadoreschile.model.db


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "uf_tabla")
data class UF(
    @PrimaryKey
    var fecha: String = "",

    var valor: Double = 0.0
)