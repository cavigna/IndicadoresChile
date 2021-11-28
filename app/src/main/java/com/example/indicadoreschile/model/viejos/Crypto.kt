package com.example.indicadoreschile.model.viejos


import com.google.gson.annotations.SerializedName

data class Crypto(
    @SerializedName("ethereum")
    var ethereum: Ethereum = Ethereum()
)