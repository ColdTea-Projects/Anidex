package de.coldtea.anidex.content.ui.model

import de.coldtea.anidex.content.domain.model.AnimeByGenreBundle


sealed class ContentScreenState

object Idle: ContentScreenState()
data class GenreLoaded(val animeByGenreBundle: AnimeByGenreBundle): ContentScreenState()