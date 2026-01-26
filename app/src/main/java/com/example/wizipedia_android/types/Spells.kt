package com.example.wizipedia_android.types

class Spells : ArrayList<Spell>()

data class Spell(
    val description: String,
    val id: String,
    val name: String
)

