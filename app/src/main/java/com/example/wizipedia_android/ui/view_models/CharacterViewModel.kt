package com.example.wizipedia_android.ui.view_models

// Androidx
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wizipedia_android.network.ApiManager

// Types
import com.example.wizipedia_android.types.Character
import com.example.wizipedia_android.types.Characters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class CharacterUiState {
    object Loading : CharacterUiState()
    data class Success(val character: Character) : CharacterUiState()
    data class Error(val message: String) : CharacterUiState()
}

class CharacterViewModel(private val characterName: String) : ViewModel() {
    private val _uiState = MutableStateFlow<CharacterUiState>(CharacterUiState.Loading)

    val uiState = _uiState.asStateFlow()

    init {
        loadCharacterDetails()
    }

    private fun loadCharacterDetails() {
        viewModelScope.launch {
            _uiState.value = CharacterUiState.Loading

            try {
                val character = ApiManager.getCharacter(characterName)

                if (character == null) {
                    _uiState.value = CharacterUiState.Error("No characters found")
                    return@launch
                }

                _uiState.value = CharacterUiState.Success(character)
            } catch (e: Exception) {
                _uiState.value = CharacterUiState.Error(
                    e.message ?: "Unknown error occurred"
                )
            }
        }
    }

    fun retry() {
        loadCharacterDetails()
    }
}