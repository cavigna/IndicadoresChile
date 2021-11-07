package com.example.indicadoreschile.model



import com.google.gson.annotations.SerializedName

data class ResIndicador(
    @SerializedName("autor")
    var autor: String = "",
    @SerializedName("codigo")
    var codigo: String = "",
    @SerializedName("nombre")
    var nombre: String = "",
    @SerializedName("serie")
    var indicador: List<Indicador> = listOf(),
    @SerializedName("unidad_medida")
    var unidadMedida: String = "",
    @SerializedName("version")
    var version: String = ""
)