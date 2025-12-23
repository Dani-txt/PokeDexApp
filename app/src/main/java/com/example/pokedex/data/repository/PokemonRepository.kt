package com.example.pokedex.data.repository

import com.example.pokedex.data.remote.api.pokeApi.PokeApiService
import com.example.pokedex.data.remote.dto.PokemonSpeciesRef

class PokemonRepository(
    private val api: PokeApiService
) {

    suspend fun getPokemonByRegion(region: String): List<PokemonSpeciesRef> {

        // 1. Obtener región
        val regionResponse = api.getRegion(region)

        // 2. Obtener el primer pokedex de esa región
        val pokedexUrl = regionResponse.pokedexes.first().url
        val pokedexId = pokedexUrl.split("/").filter { it.isNotEmpty() }.last()

        // 3. Obtener entries
        val pokedexResponse = api.getPokedex(pokedexId)

        // 4. Mapear a lista limpia
        return pokedexResponse.pokemon_entries
            .sortedBy { it.entry_number }
            .map { it.pokemon_species }
    }
}




