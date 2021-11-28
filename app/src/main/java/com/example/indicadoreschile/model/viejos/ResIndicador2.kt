package com.example.indicadoreschile.model.viejos



import com.google.gson.annotations.SerializedName

data class ResIndicador2(
    @SerializedName("autor")
    var autor: String = "",
    @SerializedName("codigo")
    var codigo: String = "",
    @SerializedName("nombre")
    var nombre: String = "",
    @SerializedName("serie")
    var indicador2: List<Indicador2> = listOf(),
    @SerializedName("unidad_medida")
    var unidadMedida: String = "",
    @SerializedName("version")
    var version: String = ""
)