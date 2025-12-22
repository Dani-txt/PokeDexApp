package com.example.pokedex.data.remote.dto

data class Pokemon(
    val id: Int,
    val name: String,
    val types: List<String>,
    val imageUrl: String
)

