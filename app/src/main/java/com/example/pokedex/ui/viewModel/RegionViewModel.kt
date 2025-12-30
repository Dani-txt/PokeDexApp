package com.example.pokedex.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.domain.model.PokemonListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegionViewModel(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _pokemon = MutableStateFlow<List<PokemonListItem>>(emptyList())
    val pokemon: StateFlow<List<PokemonListItem>> = _pokemon


    fun loadRegion(regionId: String) {
        viewModelScope.launch {
            _pokemon.value = repository.getPokemonByRegion(regionId)
        }
    }
}


