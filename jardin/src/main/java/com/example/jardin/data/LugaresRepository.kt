package com.example.jardin.data

class LugaresRepository {
    suspend fun getLugares() = ApiFactory.retrofit.getLugares()
}