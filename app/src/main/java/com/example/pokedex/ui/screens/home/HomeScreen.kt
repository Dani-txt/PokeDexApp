package com.example.pokedex.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.pokedex.navigation.Routes

@Composable
fun HomeScreen(navController: NavHostController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Selecciona una región")

        listOf("kanto","johto","hoenn","sinnoh","unova","kalos","alola","galar")
            .forEach { region ->
                Button(onClick = { navController.navigate(Routes.region(region)) }) {
                    Text(region.replaceFirstChar { it.uppercase() })
                }
            }
    }
}




