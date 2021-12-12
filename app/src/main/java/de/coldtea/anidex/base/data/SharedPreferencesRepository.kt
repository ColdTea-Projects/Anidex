package de.coldtea.anidex.base.data

import android.content.Context
import android.content.SharedPreferences
import de.coldtea.anidex.content.domain.model.AnimeGenre

class SharedPreferencesRepository(context: Context) {
    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(
            ANIDEX_APP_SHARED_PREFERENCES,
            Context.MODE_PRIVATE
        )
    }

    var lastFetchedGenres: List<Int>?
        get() = sharedPreferences
            .getStringSet(
                LAST_FETCHED_GENRES, setOf(
                    AnimeGenre.ACTION.genreId.toString(),
                    AnimeGenre.COMEDY.genreId.toString(),
                    AnimeGenre.FANTASY.genreId.toString(),
                    AnimeGenre.SHOUNEN.genreId.toString(),
                    AnimeGenre.SUPER_POWER.genreId.toString(),
                    AnimeGenre.MILITARY.genreId.toString(),
                    AnimeGenre.BOYS_LOVE.genreId.toString(),
                    AnimeGenre.GIRLS_LOVE.genreId.toString(),
                    AnimeGenre.VAMPIRE.genreId.toString()
                )
            )
            ?.map { it.toInt() }
            ?.toList()
        set(value) = sharedPreferences.edit().apply {
            val valueAsSet = value?.map { it.toString() }?.toSet()
            putStringSet(LAST_FETCHED_GENRES, valueAsSet)
        }.apply()

    var isGenreRandomized: Boolean
        get() = sharedPreferences
            .getBoolean(IS_GENRE_RANDOMIZED, true)
        set(value) = sharedPreferences.edit().apply{
            putBoolean(IS_GENRE_RANDOMIZED, value)
        }.apply()

    companion object {
        const val ANIDEX_APP_SHARED_PREFERENCES = "anidex_app_shared_preferences"
        const val LAST_FETCHED_GENRES = "last_fetched_genres"
        const val IS_GENRE_RANDOMIZED = "is_genre_randomized"
    }
}