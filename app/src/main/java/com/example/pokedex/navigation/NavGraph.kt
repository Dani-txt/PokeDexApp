package com.example.pokedex.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokedex.ui.screens.home.HomeScreen
import com.example.pokedex.ui.screens.pokemon.PokemonScreen
import com.example.pokedex.ui.screens.pokemon.PokemonSearchScreen
import com.example.pokedex.ui.screens.pokemon.RegionScreen


@Composable
fun NavGraph(navController: NavHostController, padding: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = Routes.HOME,
        modifier = Modifier.padding(padding)
    ) {

        composable(Routes.HOME) { HomeScreen(navController) }
        composable(Routes.SEARCH) { PokemonSearchScreen(navController) }
        composable(Routes.REGION) { back ->
            RegionScreen(back.arguments?.getString("regionId")!!, navController)
        }
        composable(Routes.POKEMON) { back ->
            PokemonScreen(back.arguments?.getString("name")!!, navController)
        }
    }
}




