package com.example.pokedex.data.remote.dto

data class PokedexResponse(
    val pokemon_entries: List<PokemonEntry>
)

data class PokemonEntry(
    val entry_number: Int,
    val pokemon_species: PokemonSpeciesRef
)

data class PokemonSpeciesRef(
    val name: String,
    val url: String
)

