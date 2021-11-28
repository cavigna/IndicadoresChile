package com.example.indicadoreschile.model.api


import com.google.gson.annotations.SerializedName

data class IndResponseUSD(
    @SerializedName("Dolares")
    var indicadores: List<IndicadorUSD> = listOf()
)