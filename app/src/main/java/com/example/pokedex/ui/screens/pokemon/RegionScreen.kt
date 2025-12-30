package com.example.pokedex.ui.screens.pokemon

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.pokedex.navigation.Routes
import com.example.pokedex.ui.viewModel.RegionViewModel
import com.example.pokedex.ui.viewModel.RegionViewModelFactory
import com.example.pokedex.di.PokemonProvider


@Composable
fun RegionScreen(region: String, navController: NavHostController) {

    val viewModel: RegionViewModel = viewModel(
        factory = RegionViewModelFactory(PokemonProvider.repository)
    )

    val pokemon by viewModel.pokemon.collectAsState()

    LaunchedEffect(region) {
        viewModel.loadRegion(region)
    }

    Column {
        StandardTopBar(region) { navController.popBackStack() }
        LazyColumn {
            items(pokemon) { p ->
                Text(
                    text = p.name.replaceFirstChar { it.uppercase() },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(Routes.pokemon(p.name))
                        }
                        .padding(12.dp)
                )
            }
        }
    }
}






