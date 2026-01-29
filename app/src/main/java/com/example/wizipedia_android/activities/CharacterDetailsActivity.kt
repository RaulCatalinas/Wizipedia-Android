package com.example.wizipedia_android.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.wizipedia_android.activities.ui.screens.CharacterDetailScreen
import com.example.wizipedia_android.activities.ui.theme.WizipediaAndroidTheme

class CharacterDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WizipediaAndroidTheme {
                CharacterDetailScreen(intent.getStringExtra("characterName"))
            }
        }
    }
}