package com.example.pokedex.data.remote.api.pokeApi

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.example.pokedex.data.remote.dto.Pokemon

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int = 151): List<Pokemon>

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): Pokemon
}
