package com.example.indicadoreschile.model.api


import com.google.gson.annotations.SerializedName

data class IndicadorUSD(
    @SerializedName("Fecha")
    var fecha: String = "",
    @SerializedName("Valor")
    var valor: String = ""
)