package com.example.pokedex.data.repository

import com.example.pokedex.data.remote.api.pokeApi.PokeApiService
import com.example.pokedex.data.remote.dto.PokedexResponse
import com.example.pokedex.data.remote.dto.PokemonDto
import com.example.pokedex.domain.model.Pokemon
import com.example.pokedex.domain.model.PokemonListItem

class PokemonRepository(
    private val api: PokeApiService
) {

    suspend fun getPokemonByRegion(regionId: String): List<PokemonListItem> {

        val region = api.getRegion(regionId)

        val pokedexId = region.pokedexes.first().url
            .split("/").filter { it.isNotBlank() }.last()

        val pokedex = api.getPokedex(pokedexId)

        return pokedex.pokemon_entries.map {
            PokemonListItem(
                name = it.pokemon_species.name,
                url = it.pokemon_species.url
            )
        }
    }


    suspend fun getPokemonDetail(name: String): Pokemon {
        val dto = api.getPokemon(name)

        return Pokemon(
            id = dto.id,
            name = dto.name,
            types = dto.types.map { it.type.name },
            imageUrl = dto.sprites.front_default ?: ""
        )
    }
}





