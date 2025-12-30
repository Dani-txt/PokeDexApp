package com.example.pokedex.di

import com.example.pokedex.data.remote.api.pokeApi.PokeApiService
import com.example.pokedex.data.remote.api.pokeApi.RetrofitPokeApi
import com.example.pokedex.data.repository.PokemonRepository

object PokemonProvider {

    val repository: PokemonRepository by lazy {
        PokemonRepository(RetrofitPokeApi.pokeApiService)
    }
}
