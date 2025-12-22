package com.example.pokedex.data.repository

import com.example.pokedex.data.remote.api.pokeApi.PokeApiService
import com.example.pokedex.data.remote.dto.Pokemon

class PokemonRepository(
    private val api: PokeApiService
) {
    suspend fun getPokemonList(limit: Int = 151): List<Pokemon> = api.getPokemonList(limit)

    suspend fun getPokemonById(id: Int): Pokemon = api.getPokemonById(id)
}
