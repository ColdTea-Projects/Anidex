package de.coldtea.anidex.data

import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.CoroutineScope

class SharedPreferencesRepository(context: Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(
            ANIDEX_APP_SHARED_PREFERENCES,
            Context.MODE_PRIVATE
        )
    }

    var lastFetchedGenres: List<Int>?
        get() = sharedPreferences
            .getStringSet(LAST_FETCHED_GENRES, setOf())
            ?.map { it.toInt() }
            ?.toList()
        set(value) = sharedPreferences.edit().apply {
            val valueAsSet = value?.map { it.toString() }?.toSet()
            putStringSet(LAST_FETCHED_GENRES, valueAsSet)
        }.apply()

    companion object {
        const val ANIDEX_APP_SHARED_PREFERENCES = "anidex_app_shared_preferences"
        const val LAST_FETCHED_GENRES = "last_fetched_genres"
    }
}