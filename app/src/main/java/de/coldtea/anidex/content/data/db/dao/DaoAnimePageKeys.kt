package de.coldtea.anidex.content.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import de.coldtea.anidex.base.data.db.DaoBase
import de.coldtea.anidex.content.data.db.entity.AnimePageKeysEntity

@Dao
abstract class DaoAnimePageKeys: DaoBase<AnimePageKeysEntity> {

    @Query("SELECT COUNT(genre_id) FROM anime_page_keys WHERE genre_id = :genreId AND next_key = :nextKey")
    abstract suspend fun getAnimeCountForPage(genreId: Int, nextKey: Int): Int

    @Query("SELECT * FROM anime_page_keys WHERE anime_id = :animeId AND genre_id = :genreId")
    abstract suspend fun getAnimePageKeys(animeId: Int, genreId: Int): AnimePageKeysEntity?

    @Query("DELETE FROM anime_page_keys WHERE genre_id = :genreId")
    abstract suspend fun clearAnimePageKeysByGenre(genreId: Int)
}