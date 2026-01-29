package com.example.wizipedia_android.ui.screens

// Compose
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

// Androidx
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.wizipedia_android.ui.screens.character.CharacterDetailsContent
import com.example.wizipedia_android.ui.view_models.CharacterUiState

// View models
import com.example.wizipedia_android.ui.view_models.CharacterViewModel

@Composable
fun CharacterDetailScreen(characterName: String) {
    val viewModel: CharacterViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CharacterViewModel(characterName) as T
            }
        }
    )

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (val state = uiState) {
                is CharacterUiState.Loading -> {
                    CircularProgressIndicator()
                }

                is CharacterUiState.Error -> {
                    Column {
                        Text("Error: ${state.message}")
                        Button(onClick = { viewModel.retry() }) {
                            Text("Retry")
                        }
                    }
                }

                is CharacterUiState.Success -> {
                    CharacterDetailsContent(character = state.character)
                }
            }
        }
    }
}