package com.example.pokedex.ui.screens.pokemon


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pokedex.viewModel.PokemonViewModel

@Composable
fun PokedexScreen(
    navController: NavHostController,
    viewModel: PokemonViewModel
) {
    val pokemonList by viewModel.pokemonList.collectAsState()
    val error by viewModel.error.collectAsState()

    Column {
        if (error != null) {
            Text(text = error ?: "", color = Color.Red)
        } else {
            LazyColumn {
                items(pokemonList) { pokemon ->
                    Text(text = pokemon.name)
                }
            }
        }
    }
}

