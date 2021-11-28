package com.example.indicadoreschile.model.api


import com.google.gson.annotations.SerializedName

data class IndResponseUF(
    @SerializedName("UFs")
    var indicadorUFS: List<IndicadorUF> = listOf()
)