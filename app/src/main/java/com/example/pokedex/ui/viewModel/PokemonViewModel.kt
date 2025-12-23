package com.example.pokedex.viewModel

import androidx.lifecycle.ViewModel
import com.example.pokedex.data.repository.PokemonRepository

class PokemonViewModel(
    private val repository: PokemonRepository
) : ViewModel() {
    }



