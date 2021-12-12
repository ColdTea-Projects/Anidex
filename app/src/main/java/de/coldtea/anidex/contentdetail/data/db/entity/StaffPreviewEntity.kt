package de.coldtea.anidex.contentdetail.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "staff_preview", primaryKeys = ["staff_id"])
data class StaffPreviewEntity(
    @ColumnInfo(name = "staff_id")
    val staffId: Int,
    @ColumnInfo(name = "fk_anime_id")
    val animeId: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "image_url")
    val imageUrl: String
)