package com.example.pokedex.data.remote.api.pokeApi

import com.example.pokedex.data.remote.dto.PokedexResponse
import com.example.pokedex.data.remote.dto.PokemonDto
import com.example.pokedex.data.remote.dto.RegionResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokeApiService {

    @GET("region/{region}")
    suspend fun getRegion(@Path("region") region: String): RegionResponse

    @GET("pokedex/{id}")
    suspend fun getPokedex(@Path("id") id: String): PokedexResponse
}

