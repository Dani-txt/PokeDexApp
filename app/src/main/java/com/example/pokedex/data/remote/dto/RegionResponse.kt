package com.example.pokedex.data.remote.dto

data class RegionResponse(
    val name: String,
    val pokedexes: List<PokedexRef>
)

data class PokedexRef(
    val name: String,
    val url: String
)
