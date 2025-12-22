package com.example.pokedex.data.remote.dto

import com.example.pokedex.domain.model.Pokemon

// Extensión para convertir DTO -> Modelo de dominio
fun PokemonDto.toDomain(): Pokemon {
    return Pokemon(
        id = id,
        name = name,
        types = types.map { it.type.name },
        imageUrl = sprites.front_default
    )
}
