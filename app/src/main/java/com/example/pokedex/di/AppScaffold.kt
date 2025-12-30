package com.example.pokedex.di

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pokedex.navigation.NavGraph
import com.example.pokedex.navigation.Routes
import com.example.pokedex.ui.screens.home.BottomNavBar

@Composable
fun AppScaffold() {

    val navController = rememberNavController()
    val backStack by navController.currentBackStackEntryAsState()
    val route = backStack?.destination?.route

    val showBottomBar = route in listOf(
        Routes.HOME,
        Routes.SEARCH,
        Routes.PROFILE
    )

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavBar(
                    onHomeClick = { navController.navigate(Routes.HOME) },
                    onCartClick = { navController.navigate(Routes.SEARCH) },
                    onProfileClick = { navController.navigate(Routes.PROFILE) }
                )
            }
        }
    ) { padding ->
        NavGraph(navController, padding)
    }
}

