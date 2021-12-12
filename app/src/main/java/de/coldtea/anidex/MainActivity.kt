package de.coldtea.anidex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import de.coldtea.anidex.base.data.SharedPreferencesRepository
import de.coldtea.anidex.base.ui.navigation.NavigationCentral
import de.coldtea.anidex.base.ui.theme.AnidexTheme
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

