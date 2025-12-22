package com.example.pokedex.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.pokedex.navigation.Routes

@Composable
fun HomeScreen(navController: NavHostController) {
    Column {
        Text("Bienvenido a la Pokédex")
        Button(onClick = { navController.navigate(Routes.POKEDEX) }) {
            Text("Ver Pokémon")
        }
    }
}
