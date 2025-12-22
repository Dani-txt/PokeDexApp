package com.example.pokedex.data.remote.dto

data class PokemonDto(
    val id: Int,
    val name: String,
    val types: List<TypeSlot>,
    val sprites: Sprites
)

data class TypeSlot(
    val slot: Int,
    val type: TypeInfo
)

data class TypeInfo(
    val name: String,
    val url: String
)

data class Sprites(
    val front_default: String
)


