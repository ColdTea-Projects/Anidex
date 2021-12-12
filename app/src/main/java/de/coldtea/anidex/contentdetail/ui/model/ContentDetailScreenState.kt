package de.coldtea.anidex.contentdetail.ui.model

import de.coldtea.anidex.contentdetail.domain.model.AnimeDetail

sealed class ContentDetailScreenState

object Loading: ContentDetailScreenState()
object Failed: ContentDetailScreenState()

data class Success(val animeDetail: AnimeDetail): ContentDetailScreenState()