package com.example.pokedex.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.remote.dto.PokemonSpeciesRef
import com.example.pokedex.data.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegionViewModel(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _pokemon = MutableStateFlow<List<PokemonSpeciesRef>>(emptyList())
    val pokemon: StateFlow<List<PokemonSpeciesRef>> = _pokemon

    fun loadRegion(region: String) {
        viewModelScope.launch {
            _pokemon.value = repository.getPokemonByRegion(region)
        }
    }
}

