package de.coldtea.anidex.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import de.coldtea.anidex.data.db.entity.AnimeEntity

@Dao
abstract class DaoAnime : DaoBase<AnimeEntity> {

    @Transaction
    @Query("SELECT * FROM anime")
    abstract suspend fun getAnimesByGenre() : List<AnimeEntity>

}