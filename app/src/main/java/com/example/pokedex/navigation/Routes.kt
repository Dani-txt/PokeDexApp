package com.example.pokedex.navigation

object Routes {
    const val HOME = "home"
    const val REGION = "region/{region}"

    fun region(region: String) = "region/$region"
}

