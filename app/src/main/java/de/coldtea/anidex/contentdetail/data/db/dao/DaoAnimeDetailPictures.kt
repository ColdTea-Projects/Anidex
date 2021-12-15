package de.coldtea.anidex.contentdetail.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import de.coldtea.anidex.base.data.db.DaoBase
import de.coldtea.anidex.contentdetail.data.db.entity.AnimeDetailPicturesEntitiy

@Dao
interface DaoAnimeDetailPictures: DaoBase<AnimeDetailPicturesEntitiy>{
    @Transaction
    @Query("SELECT COUNT(*) FROM anime_detail_pictures WHERE fk_anime_id = :animeId")
    suspend fun getAnimeDetailPictureCount(animeId: Int): Int
}