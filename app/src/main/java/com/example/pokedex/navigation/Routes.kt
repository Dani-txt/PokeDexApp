package com.example.pokedex.navigation

object Routes {
    const val HOME = "home"
    const val REGION = "region/{regionId}"
    const val POKEMON = "pokemon/{name}"
    const val SEARCH = "pokemon"
    const val PROFILE = "profile"

    fun region(id: String) = "region/$id"
    fun pokemon(name: String) = "pokemon/$name"
}


