package de.coldtea.anidex.data.db

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.coldtea.anidex.data.db.dao.DaoAnime
import de.coldtea.anidex.data.db.entity.AnimeEntity

@SuppressLint("RestrictedApi")
@Database(
    entities = [
        AnimeEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AnidexDatabase : RoomDatabase() {

    abstract val daoAnime: DaoAnime

    companion object {
        @Volatile
        private var INSTANCE: AnidexDatabase? = null
        internal fun getInstance(context: Context): AnidexDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AnidexDatabase::class.java,
                        "db_moin_app"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}
