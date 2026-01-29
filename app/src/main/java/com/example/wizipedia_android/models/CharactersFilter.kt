package com.example.wizipedia_android.models

sealed class CharactersFilter(val displayName: String) {
    object All : CharactersFilter("All")
    object Students : CharactersFilter("Students")
    object Staff : CharactersFilter("Staff")
    data class House(val houseName: String) : CharactersFilter(houseName)
    object Alive : CharactersFilter("Alive")
    object Dead : CharactersFilter("Dead")

    companion object {
        fun getAllFilters(): List<CharactersFilter> = listOf(
            All,
            Students,
            Staff,
            House("Gryffindor"),
            House("Slytherin"),
            House("Ravenclaw"),
            House("Hufflepuff"),
            Alive,
            Dead
        )
    }
}