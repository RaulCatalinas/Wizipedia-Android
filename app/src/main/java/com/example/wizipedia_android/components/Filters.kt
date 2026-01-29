package com.example.wizipedia_android.components

// Compose
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

// Models
import com.example.wizipedia_android.models.CharactersFilter

// View models
import com.example.wizipedia_android.ui.view_models.CharactersViewModel

@Composable
fun Filters(viewModel: CharactersViewModel) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(
            12.dp,
            alignment = Alignment.CenterHorizontally
        )
    ) {
        items(items = CharactersFilter.getAllFilters()) { filter ->
            Text(
                text = filter.displayName,
                color = Color.White,
                modifier = Modifier
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color.Gray)
                    .padding(horizontal = 16.dp, vertical = 4.dp)
                    .clickable {
                        viewModel.applyFilter(filter)
                    }
            )
        }
    }
}