package com.karendamore.metabile


import com.google.gson.annotations.SerializedName

data class LugarItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("puntuacion")
    val puntuacion: String,
    @SerializedName("urlimagen")
    val urlimagen: String
)