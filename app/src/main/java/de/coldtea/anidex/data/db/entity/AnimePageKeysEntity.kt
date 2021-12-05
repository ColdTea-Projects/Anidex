package de.coldtea.anidex.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "anime_page_keys", primaryKeys = ["genre_id", "anime_id"])
data class AnimePageKeysEntity(
    @ColumnInfo(name = "genre_id")
    val genreId: Int,
    @ColumnInfo(name = "anime_id")
    val animeId: Int,
    @ColumnInfo(name = "prev_key")
    val prevKey: Int?,
    @ColumnInfo(name = "next_key")
    val nextKey: Int?
)