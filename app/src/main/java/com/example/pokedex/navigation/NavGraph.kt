package com.example.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokedex.data.remote.api.pokeApi.RetrofitPokeApi
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.ui.screens.pokemon.PokedexScreen
import com.example.pokedex.ui.screens.home.HomeScreen
import com.example.pokedex.ui.viewModel.PokemonViewModelFactory
import com.example.pokedex.viewModel.PokemonViewModel

@Composable
fun NavGraph(navController: NavHostController) {

    val pokemonViewModel: PokemonViewModel = viewModel(
        factory = PokemonViewModelFactory(
            PokemonRepository(RetrofitPokeApi.pokeApiService)
        )
    )

    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(navController)
        }
        composable(Routes.POKEDEX) {
            // Aquí pasamos el ViewModel ya creado
            PokedexScreen(navController, pokemonViewModel)
        }
    }
}

