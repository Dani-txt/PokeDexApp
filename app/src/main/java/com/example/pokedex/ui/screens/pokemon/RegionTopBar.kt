package com.example.pokedex.ui.screens.pokemon

import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegionTopBar(region: String, onBack: () -> Unit) {
    androidx.compose.material3.TopAppBar(
        title = { Text(region.replaceFirstChar { it.uppercase() }) },
        navigationIcon = {
            androidx.compose.material3.IconButton(onClick = onBack) {
                androidx.compose.material3.Icon(
                    imageVector = androidx.compose.material.icons.Icons.Default.ArrowBack,
                    contentDescription = "Volver"
                )
            }
        }
    )
}
