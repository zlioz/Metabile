package com.example.jardin.data

import com.example.jardin.model.Lugar
import retrofit2.http.GET

interface ApiService {

    @GET("Ciclo4Metabile/Metabile/lugares")
    suspend fun getLugares():Lugar

}