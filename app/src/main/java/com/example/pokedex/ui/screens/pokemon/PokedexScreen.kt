package com.example.pokedex.ui.screens.pokemon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.pokedex.viewModel.PokemonViewModel
import kotlinx.coroutines.launch
/**
@Composable
fun PokedexScreen(
navController: NavHostController,
viewModel: PokemonViewModel
) {
val pokemonList by viewModel.pokemonList.collectAsState()
val error by viewModel.error.collectAsState()

var query by remember { mutableStateOf("") }
val listState = rememberLazyListState()
val coroutineScope = rememberCoroutineScope()

// Filtrado dinámico por nombre o tipo
val filteredList = pokemonList.filter { pokemon ->
pokemon.name.contains(query, ignoreCase = true) ||
pokemon.types.any { it.contains(query, ignoreCase = true) }
}

Box(modifier = Modifier.fillMaxSize()) {
Column(
modifier = Modifier
.align(Alignment.Center)
.fillMaxWidth(0.9f)
) {
// 🔎 Buscador arriba
OutlinedTextField(
value = query,
onValueChange = { query = it },
label = { Text("Buscar Pokémon") },
modifier = Modifier
.fillMaxWidth()
.padding(8.dp)
)

if (error != null) {
Text(text = error ?: "ERROR al cargar pokemones", color = MaterialTheme.colorScheme.error)
} else {
LazyColumn(
state = listState,
modifier = Modifier.fillMaxWidth()
) {
items(filteredList) { pokemon ->
Card(
modifier = Modifier
.fillMaxWidth()
.padding(vertical = 8.dp)
) {
Row(
modifier = Modifier
.fillMaxWidth()
.padding(12.dp),
verticalAlignment = Alignment.CenterVertically,
horizontalArrangement = Arrangement.SpaceBetween
) {
Text(text = "#${pokemon.id}")
Text(text = pokemon.name)
Text(text = pokemon.types.joinToString(", "))
Image(
painter = rememberAsyncImagePainter(pokemon.imageUrl),
contentDescription = pokemon.name,
modifier = Modifier.size(64.dp)
)
}
}
}
}
}
}

// Botón arriba a la derecha
Button(
onClick = {
coroutineScope.launch {
listState.animateScrollToItem(0)
}
},
modifier = Modifier
.align(Alignment.TopEnd)
.padding(16.dp)
) {
Text("↑ Primero")
}

// Botón abajo a la derecha
Button(
onClick = {
coroutineScope.launch {
if (filteredList.isNotEmpty()) {
listState.animateScrollToItem(filteredList.lastIndex)
}
}
},
modifier = Modifier
.align(Alignment.BottomEnd)
.padding(16.dp)
) {
Text("↓ Último")
}
}
}
 * */

