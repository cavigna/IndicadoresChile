package com.example.indicadoreschile.model


import com.google.gson.annotations.SerializedName

data class Indicador(
    @SerializedName("fecha")
    var fecha: String = "",
    @SerializedName("valor")
    var valor: Double = 0.0
)