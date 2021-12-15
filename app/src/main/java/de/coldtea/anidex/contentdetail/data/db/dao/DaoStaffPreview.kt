package de.coldtea.anidex.contentdetail.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import de.coldtea.anidex.base.data.db.DaoBase
import de.coldtea.anidex.contentdetail.data.db.entity.StaffPreviewEntity

@Dao
interface DaoStaffPreview: DaoBase<StaffPreviewEntity>{
    @Transaction
    @Query("SELECT COUNT(*) FROM staff_preview WHERE fk_anime_id = :animeId")
    suspend fun getStaffCount(animeId: Int): Int
}