package de.coldtea.anidex.character.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import de.coldtea.anidex.base.data.db.DaoBase
import de.coldtea.anidex.character.data.db.entity.CharacterEntity
import de.coldtea.anidex.character.data.db.relations.CharacterBundle

@Dao
interface DaoCharacters: DaoBase<CharacterEntity> {

    @Transaction
    @Query("SELECT * FROM character WHERE character_id = :characterId")
    suspend fun getCharacter(characterId: Int): List<CharacterBundle>

    @Transaction
    @Query("SELECT COUNT(*) FROM character WHERE character_id = :characterId")
    suspend fun getCharacterCount(characterId: Int): Int
}