package com.example.wizipedia_android.ui.view_models

// Androidx
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

// Kotlinx
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// Network
import com.example.wizipedia_android.network.ApiManager

// Types
import com.example.wizipedia_android.types.Characters

// Models
import com.example.wizipedia_android.models.CharactersFilter

sealed class CharactersUiState {
    object Loading : CharactersUiState()
    data class Success(val characters: Characters) : CharactersUiState()
    data class Error(val message: String) : CharactersUiState()
}

class CharactersViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<CharactersUiState>(CharactersUiState.Loading)
    private var allCharacters = Characters()

    val uiState = _uiState.asStateFlow()

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            _uiState.value = CharactersUiState.Loading

            try {
                val characters = ApiManager.getAllCharacters()

                if (characters == null || characters.isEmpty()) {
                    _uiState.value = CharactersUiState.Error("No characters found")
                    return@launch
                }

                allCharacters = characters
                _uiState.value = CharactersUiState.Success(characters)
            } catch (e: Exception) {
                _uiState.value = CharactersUiState.Error(
                    e.message ?: "Unknown error occurred"
                )
            }
        }
    }

    fun applyFilter(filter: CharactersFilter) {
        if (allCharacters.isEmpty()) {
            Log.w("CharactersViewModel", "⚠️ No characters loaded to filter.")
            return
        }

        val filtered = when (filter) {
            is CharactersFilter.All -> {
                allCharacters
            }

            is CharactersFilter.Students -> {
                allCharacters.filter { it.hogwartsStudent }
            }

            is CharactersFilter.Staff -> {
                allCharacters.filter { it.hogwartsStaff }
            }

            is CharactersFilter.House -> {
                allCharacters.filter {
                    it.house.equals(filter.houseName, ignoreCase = true)
                }
            }

            is CharactersFilter.Alive -> {
                allCharacters.filter { it.alive }
            }

            is CharactersFilter.Dead -> {
                allCharacters.filter { !it.alive }
            }
        }

        if (filtered.isEmpty()) {
            Log.w("CharactersViewModel", "⚠️ No characters found for filter: ${filter.displayName}")
        }

        _uiState.value = CharactersUiState.Success(
            Characters().apply { addAll(filtered) }
        )
    }

    fun retry() {
        loadCharacters()
    }
}