package com.example.pokedex.ui.screens.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.example.pokedex.di.PokemonProvider
import com.example.pokedex.ui.viewModel.PokemonViewModelFactory
import com.example.pokedex.viewModel.PokemonViewModel

@Composable
fun PokemonScreen(name: String, navController: NavHostController) {

    val viewModel: PokemonViewModel = viewModel(
        factory = PokemonViewModelFactory(PokemonProvider.repository)
    )

    val pokemon by viewModel.pokemon.collectAsState()

    LaunchedEffect(name) {
        viewModel.loadPokemon(name)
    }

    Column {

        StandardTopBar(name) { navController.popBackStack() }

        pokemon?.let { p ->
            Column(Modifier.padding(16.dp)) {
                AsyncImage(model = p.imageUrl, contentDescription = p.name)
                Text("ID: ${p.id}")
                Text("Tipos: ${p.types.joinToString()}")
            }
        }
    }
}


