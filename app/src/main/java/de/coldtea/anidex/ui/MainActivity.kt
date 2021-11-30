package de.coldtea.anidex.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import de.coldtea.anidex.data.api.SharedPreferencesRepository
import de.coldtea.anidex.ui.navigation.NavigationCentral
import de.coldtea.anidex.ui.theme.AnidexTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var sharedPreferencesRepository: SharedPreferencesRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferencesRepository.isGenreRandomized = true

        setContent {
            AnidexTheme {
                NavigationCentral()
            }
        }
    }
}

