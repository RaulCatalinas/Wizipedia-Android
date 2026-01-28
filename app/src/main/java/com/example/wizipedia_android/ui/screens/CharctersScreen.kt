package com.example.wizipedia_android.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.wizipedia_android.network.ApiManager
import com.example.wizipedia_android.types.Characters
import com.example.wizipedia_android.ui.screens.characters.CharacterContentView

@Composable
fun CharactersScreen() {
    var characters by remember { mutableStateOf<Characters?>(null) }
    var isLoading by remember { mutableStateOf(true) }
    var error by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        try {
            isLoading = true
            characters = ApiManager.getAllCharacters()
            isLoading = false
        } catch (e: Exception) {
            error = e.message
            characters = null
            isLoading = false
        }
    }

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            when {
                isLoading -> {
                    CircularProgressIndicator()
                    Text("Loading characters...", modifier = Modifier.padding(top = 16.dp))
                }
                error != null -> {
                    Text("Error: $error")
                }
                characters == null -> {
                    Text("No characters found")
                }
                else -> {
                    CharacterContentView(characters!!)
                }
            }
        }
    }
}