package com.example.wizipedia_android

// Android
import android.os.Bundle

// Activity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

// Compose
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.wizipedia_android.components.Navigation

// Screens
import com.example.wizipedia_android.ui.screens.HomeScreen

// Themes
import com.example.wizipedia_android.ui.theme.WizipediaAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WizipediaAndroidTheme {
                Navigation()
            }
        }
    }
}