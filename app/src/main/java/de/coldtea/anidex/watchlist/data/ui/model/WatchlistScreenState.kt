package de.coldtea.anidex.watchlist.data.ui

import de.coldtea.anidex.watchlist.data.domain.model.Watchlist

sealed class WatchlistScreenState

object Failed: WatchlistScreenState()
object Loading: WatchlistScreenState()

data class Success(val watchlist: List<Watchlist>): WatchlistScreenState()
