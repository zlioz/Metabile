package com.example.jardin.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LugarItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("puntuacion")
    val puntuacion: Double,
    @SerializedName("urlimagen")
    val urlimagen: String,
    @SerializedName("ubicacion")
    val ubicacion: String,
    @SerializedName("temperatura")
    val temperatura: String,
    @SerializedName("otros_lugares")
    val otros_lugares: String

):Serializable