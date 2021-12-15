package de.coldtea.anidex.contentdetail.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import de.coldtea.anidex.base.data.db.DaoBase
import de.coldtea.anidex.contentdetail.data.db.entity.CharacterPreviewEntity

@Dao
interface DaoCharacterPreview: DaoBase<CharacterPreviewEntity>{
    @Transaction
    @Query("SELECT COUNT(*) FROM character_preview WHERE fk_anime_id = :animeId")
    suspend fun getCharacterCount(animeId: Int): Int
}