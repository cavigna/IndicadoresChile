package com.example.indicadoreschile.model.viejos


import com.google.gson.annotations.SerializedName

data class Indicador2(
    @SerializedName("fecha")
    var fecha: String = "",
    @SerializedName("valor")
    var valor: Double = 0.0
)