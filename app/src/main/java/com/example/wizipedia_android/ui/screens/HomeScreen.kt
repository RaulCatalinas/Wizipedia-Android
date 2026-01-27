package com.example.wizipedia_android.ui.screens

// Compose
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Components
import com.example.wizipedia_android.components.CategoryCard
import com.example.wizipedia_android.enums.Category

@Composable
fun HomeScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(Category.entries.toTypedArray()) { category ->
                CategoryCard(
                    category = category,
                    onClick = {
                        when (category) {
                            Category.Characters -> println("Searching characters...")
                            Category.Houses -> println("Searching houses...")
                            Category.Spells -> println("Searching spells...")
                            Category.Media -> println("Searching media...")
                        }
                    }
                )
            }
        }
    }
}


