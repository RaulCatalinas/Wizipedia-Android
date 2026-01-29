package com.example.wizipedia_android.ui.screens

// Compose
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

// Screens
import com.example.wizipedia_android.ui.screens.characters.CharactersContentView

// ViewModels
import com.example.wizipedia_android.ui.view_models.CharactersUiState
import com.example.wizipedia_android.ui.view_models.CharactersViewModel


@Composable
fun CharactersScreen(viewModel: CharactersViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (val state = uiState) {
                is CharactersUiState.Loading -> {
                    // Estado de carga
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator()
                        Text(
                            "Loading characters...",
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }
                }

                is CharactersUiState.Error -> {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text("Error: ${state.message}")
                        Button(
                            onClick = { viewModel.retry() },
                            modifier = Modifier.padding(top = 16.dp)
                        ) {
                            Text("Retry")
                        }
                    }
                }

                is CharactersUiState.Success -> {
                    CharactersContentView(state.characters!!, viewModel)
                }
            }
        }
    }
}