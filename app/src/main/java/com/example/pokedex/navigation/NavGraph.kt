package com.example.pokedex.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pokedex.ui.screens.home.HomeScreen
import com.example.pokedex.ui.screens.pokemon.RegionScreen


@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.HOME) {

        composable(Routes.HOME) {
            HomeScreen(navController)
        }

        composable(Routes.REGION) { backStack ->
            val region = backStack.arguments?.getString("region") ?: "kanto"
            RegionScreen(region, navController)
        }
    }
}


