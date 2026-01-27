package com.example.wizipedia_android.ui.screens

// Compose
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

// Navigation
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey

// Components
import com.example.wizipedia_android.components.CategoryCard
import com.example.wizipedia_android.components.NavigationKeys
import com.example.wizipedia_android.enums.Category

@Composable
fun HomeScreen(backStack: NavBackStack<NavKey>) {
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título
            Text(
                text = "Explore the\nWizarding World",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp),
                textAlign = TextAlign.Center
            )

            // Subtítulo
            Text(
                text = "Discover characters, spells, houses, and more\nfrom the magical universe.",
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            // Grid de categorías
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(Category.entries.toTypedArray()) { category ->
                    CategoryCard(
                        category = category,
                        onClick = {
                            when (category) {
                                Category.Characters -> {
                                    backStack.clear()
                                    backStack.add(NavigationKeys.Characters)
                                }
                                Category.Houses -> {
                                    backStack.clear()
                                    backStack.add(NavigationKeys.Houses)
                                }
                                Category.Spells -> {
                                    backStack.clear()
                                    backStack.add(NavigationKeys.Spells)
                                }
                                Category.Media -> {
                                    backStack.clear()
                                    backStack.add(NavigationKeys.Media)
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}