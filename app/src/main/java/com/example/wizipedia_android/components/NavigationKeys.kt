package com.example.wizipedia_android.components

// Navigation3
import androidx.navigation3.runtime.NavKey

// Kotlinx
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationKeys : NavKey {
    @Serializable
    data object NavigationMenu : NavigationKeys

    @Serializable
    data object Characters : NavigationKeys

    @Serializable
    data object Houses : NavigationKeys

    @Serializable
    data object Spells : NavigationKeys

    @Serializable
    data object Media : NavigationKeys
}
