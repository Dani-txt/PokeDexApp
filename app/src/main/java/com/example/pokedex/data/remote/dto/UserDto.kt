package com.example.pokedex.data.remote.dto

data class UserDto(
    val uid: String,
    val username: String,
    val email: String,
    val favorites: List<String> = emptyList() // IDs de Pokémon favoritos
)