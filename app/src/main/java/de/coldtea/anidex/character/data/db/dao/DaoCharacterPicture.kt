package de.coldtea.anidex.character.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import de.coldtea.anidex.base.data.db.DaoBase
import de.coldtea.anidex.character.data.db.entity.CharacterPictureEntity

@Dao
interface DaoCharacterPicture: DaoBase<CharacterPictureEntity>{

    @Transaction
    @Query("SELECT COUNT(*) FROM character_picture WHERE fk_character_id = :characterId")
    suspend fun getCharacterPictureCount(characterId: Int): Int
}