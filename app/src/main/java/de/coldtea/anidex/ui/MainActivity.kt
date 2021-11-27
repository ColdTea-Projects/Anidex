package de.coldtea.anidex.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import de.coldtea.anidex.ui.navigation.NavigationCentral
import de.coldtea.anidex.ui.theme.AnidexTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnidexTheme {
                NavigationCentral()
            }
        }
    }
}

