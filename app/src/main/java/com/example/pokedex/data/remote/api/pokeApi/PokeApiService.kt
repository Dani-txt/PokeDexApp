package com.example.pokedex.data.remote.api.pokeApi

import com.example.pokedex.data.remote.dto.PokemonDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int = 151): List<PokemonDto>

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): PokemonDto
}
