package com.example.pokedex.data.repository

import com.example.pokedex.data.remote.api.pokeApi.PokeApiService
import com.example.pokedex.domain.model.Pokemon
import com.example.pokedex.data.remote.dto.toDomain

class PokemonRepository(
    private val api: PokeApiService
) {
    suspend fun getPokemonById(id: Int): Pokemon {
        val dto = api.getPokemonById(id)
        return dto.toDomain()
    }

    suspend fun getPokemonList(limit: Int = 151): List<Pokemon> {
        return (1..limit).map { id ->
            api.getPokemonById(id).toDomain()
        }
    }
}

