package com.example.wizipedia_android.components

// Compose
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

// Navigation 3
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.wizipedia_android.R

// Screens
import com.example.wizipedia_android.ui.screens.CharactersScreen
import com.example.wizipedia_android.ui.screens.HomeScreen
import com.example.wizipedia_android.ui.screens.HousesScreen
import com.example.wizipedia_android.ui.screens.MediaScreen
import com.example.wizipedia_android.ui.screens.SpellsScreen

@Composable
fun Navigation() {
    val backStack = rememberNavBackStack(NavigationKeys.NavigationMenu)
    val currentScreen = backStack.lastOrNull()

    BackHandler(enabled = currentScreen != NavigationKeys.NavigationMenu) {
        backStack.clear()
        backStack.add(NavigationKeys.NavigationMenu)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BottomNavItem(
                        icon = R.drawable.home,
                        label = "Home",
                        isSelected = currentScreen == NavigationKeys.NavigationMenu,
                        onClick = {}
                    )
                    BottomNavItem(
                        icon = R.drawable.characters,
                        label = "Characters",
                        isSelected = currentScreen == NavigationKeys.Characters,
                        onClick = {
                            backStack.clear()
                            backStack.add(NavigationKeys.Characters)
                        }
                    )
                    BottomNavItem(
                        icon = R.drawable.houses,
                        label = "Houses",
                        isSelected = currentScreen == NavigationKeys.Houses,
                        onClick = {
                            backStack.clear()
                            backStack.add(NavigationKeys.Houses)
                        }
                    )
                    BottomNavItem(
                        icon = R.drawable.spells,
                        label = "Spells",
                        isSelected = currentScreen == NavigationKeys.Spells,
                        onClick = {
                            backStack.clear()
                            backStack.add(NavigationKeys.Spells)
                        }
                    )
                    BottomNavItem(
                        icon = R.drawable.media,
                        label = "Media",
                        isSelected = currentScreen == NavigationKeys.Media,
                        onClick = {
                            backStack.clear()
                            backStack.add(NavigationKeys.Media)
                        }
                    )
                }
            }
        }
    ) { padding ->
        NavDisplay(
            modifier = Modifier.padding(padding),
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry(NavigationKeys.NavigationMenu) { HomeScreen(backStack = backStack) }
                entry(NavigationKeys.Characters) { CharactersScreen() }
                entry(NavigationKeys.Houses) { HousesScreen() }
                entry(NavigationKeys.Spells) { SpellsScreen() }
                entry(NavigationKeys.Media) { MediaScreen() }
            }
        )
    }
}
