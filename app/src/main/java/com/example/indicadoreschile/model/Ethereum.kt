package com.example.indicadoreschile.model


import com.google.gson.annotations.SerializedName

data class Ethereum(
    @SerializedName("usd")
    var usd: Double = 0.0,
    @SerializedName("usd_24h_change")
    var usd24hChange: Double = 0.0
)