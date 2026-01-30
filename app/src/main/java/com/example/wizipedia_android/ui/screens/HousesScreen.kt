package com.example.wizipedia_android.ui.screens

// Compose
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wizipedia_android.R
import com.example.wizipedia_android.components.RenderLocalImage

// Enums
import com.example.wizipedia_android.enums.House

@Composable
fun HousesScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                "Hogwarts Houses",
                fontSize = 40.sp,
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            LazyVerticalGrid(
                GridCells.Fixed(1),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(House.entries.toTypedArray(), key = { it.displayName }) {
                    if (it == House.UNKNOWN) return@items

                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ),
                        modifier = Modifier
                            .aspectRatio(1.92f)
                            .clip(RoundedCornerShape(8))
                            .background(it.backgroundColor)
                    ) {
                        Row {
                            Column {
                                Text(
                                    it.displayName,
                                    color = it.foregroundColor,
                                    fontSize = 25.sp,
                                    textAlign = TextAlign.Center
                                )
                                Text(
                                    it.description.uppercase(),
                                    color = Color.Gray,
                                    fontSize = 15.sp,
                                    textAlign = TextAlign.Center
                                )
                            }

                            RenderLocalImage(
                                R.drawable.houses,
                                size = 36.dp,
                                modifier = Modifier.padding(start = 12.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}