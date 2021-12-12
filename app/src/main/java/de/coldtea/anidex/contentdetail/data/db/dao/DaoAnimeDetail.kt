package de.coldtea.anidex.contentdetail.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import de.coldtea.anidex.base.data.db.DaoBase
import de.coldtea.anidex.contentdetail.data.db.entity.AnimeDetailEntity
import de.coldtea.anidex.contentdetail.data.db.relations.AnimeDetailBundle

@Dao
interface DaoAnimeDetail: DaoBase<AnimeDetailEntity> {

    @Transaction
    @Query("SELECT * FROM anime_detail WHERE anime_id = :animeId")
    suspend fun getAnimeDetails(animeId: Int): List<AnimeDetailBundle>
}