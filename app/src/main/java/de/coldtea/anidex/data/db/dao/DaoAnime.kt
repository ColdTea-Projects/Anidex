package de.coldtea.anidex.data.db.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import de.coldtea.anidex.data.db.entity.AnimeEntity

@Dao
abstract class DaoAnime : DaoBase<AnimeEntity> {

    @Transaction
    @Query("SELECT * FROM anime WHERE genre_id = :genreId ORDER BY created_at")
    abstract fun pagingSourceByGenre(genreId: Int): PagingSource<Int, AnimeEntity>

    @Transaction
    @Query("DELETE FROM anime WHERE genre_id = :genreId")
    abstract suspend fun clearAllByGenre(genreId: Int)
}