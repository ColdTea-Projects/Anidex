package de.coldtea.anidex.ui.content.model

import de.coldtea.anidex.domain.model.AnimeByGenreBundle


sealed class ContentScreenState

object Idle: ContentScreenState()
data class GenreLoaded(val animeByGenreBundle: AnimeByGenreBundle): ContentScreenState()