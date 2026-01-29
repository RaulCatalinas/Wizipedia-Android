package com.example.wizipedia_android.activities.ui.screens.character

// Compose
import android.util.Log
import androidx.compose.runtime.Composable

// Types
import com.example.wizipedia_android.types.Character

@Composable
fun CharacterDetailsContent(character: Character) {
    Log.i("CharacterDetailsContent", character.toString())
}