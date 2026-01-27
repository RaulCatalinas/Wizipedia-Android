package com.example.wizipedia_android.components

// Compose
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

    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        RenderSvg(
                            R.drawable.characters,
                            modifier = Modifier.size(20.dp),
                            colorTint = Color.Black
                        )
                        Text("Characters")
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        RenderSvg(
                            R.drawable.houses,
                            modifier = Modifier.size(20.dp),
                            colorTint = Color.Black
                        )
                        Text("Houses")
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        RenderSvg(
                            R.drawable.spells,
                            modifier = Modifier.size(20.dp),
                            colorTint = Color.Black
                        )
                        Text("Spells")
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        RenderSvg(
                            R.drawable.media,
                            modifier = Modifier.size(20.dp),
                            colorTint = Color.Black
                        )
                        Text("Media")
                    }
                }
            }
        }
    ) { padding ->
        NavDisplay(
            modifier = Modifier.padding(padding),
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry(NavigationKeys.NavigationMenu) { HomeScreen() }
                entry(NavigationKeys.Characters) { CharactersScreen() }
                entry(NavigationKeys.Houses) { HousesScreen() }
                entry(NavigationKeys.Spells) { SpellsScreen() }
                entry(NavigationKeys.Media) { MediaScreen() }
            }
        )
    }
}
