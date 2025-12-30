package com.example.pokedex.ui.screens.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pokedex.navigation.Routes
import com.example.pokedex.ui.screens.home.BottomNavBar

@Composable
fun PokemonSearchScreen(navController: NavHostController) {

    var query by remember { mutableStateOf("") }

    Column {

        StandardTopBar("Buscar Pokémon") { navController.popBackStack() }

        Column(Modifier.padding(16.dp)) {

            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                label = { Text("Nombre Pokémon") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = { navController.navigate(Routes.pokemon(query.lowercase())) },
                enabled = query.isNotBlank(),
                modifier = Modifier.padding(top = 12.dp)
            ) {
                Text("Buscar")
            }
        }
    }
}



