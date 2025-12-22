package com.example.pokedex.data.remote.api.pokeApi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitPokeApi {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    val pokeApiService: PokeApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokeApiService::class.java)
    }
}
