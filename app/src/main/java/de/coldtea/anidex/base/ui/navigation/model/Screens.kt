package de.coldtea.anidex.base.ui.navigation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import de.coldtea.anidex.R

sealed class ScreenGroups(val route: String, @StringRes val textResourceId: Int, @DrawableRes val iconResourceId: Int)

object Group1: ScreenGroups(GROUP_CONTENT, R.string.group_content, R.drawable.ic_anime_manga)
object Group2: ScreenGroups(GROUP_WATCHLIST, R.string.group_watchlist, R.drawable.ic_bokmark_outline)

val screenGroups = listOf(
    Group1,
    Group2
)

const val GROUP_CONTENT = "groupContent"
const val SCREEN_CONTENT = "contentScreen"

const val GROUP_WATCHLIST = "groupWatchlist"
const val SCREEN_WATCHLIST = "watchlistScreen"

const val SCREEN_CONTENT_DETAIL = "contentDetailScreen"
const val SCREEN_SEARCH = "searchScreen"
const val SCREEN_CHARACTER = "characterScreen"
