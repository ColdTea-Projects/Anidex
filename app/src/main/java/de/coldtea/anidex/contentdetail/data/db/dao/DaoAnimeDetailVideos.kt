package de.coldtea.anidex.contentdetail.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import de.coldtea.anidex.base.data.db.DaoBase
import de.coldtea.anidex.contentdetail.data.db.entity.AnimeDetailVideosEntitiy

@Dao
interface DaoAnimeDetailVideos: DaoBase<AnimeDetailVideosEntitiy>{
    @Transaction
    @Query("SELECT COUNT(*) FROM anime_detail_videos WHERE fk_anime_id = :animeId")
    suspend fun getAnimeDetailVideosCount(animeId: Int): Int
}