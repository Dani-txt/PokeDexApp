package com.example.pokedex.data.remote.api.pokeApi

import com.example.pokedex.data.remote.dto.PokedexResponse
import com.example.pokedex.data.remote.dto.PokemonDto
import com.example.pokedex.data.remote.dto.RegionResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokeApiService {

    @GET("region/{id}")
    suspend fun getRegion(@Path("id") id: String): RegionResponse

    @GET("pokedex/{id}")
    suspend fun getPokedex(@Path("id") id: String): PokedexResponse

    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String): PokemonDto
}


