package de.coldtea.anidex.base.data.db

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.coldtea.anidex.character.data.db.dao.DaoAnimePreview
import de.coldtea.anidex.character.data.db.dao.DaoCharacterPicture
import de.coldtea.anidex.character.data.db.dao.DaoCharacters
import de.coldtea.anidex.character.data.db.dao.DaoVoiceActorsPreview
import de.coldtea.anidex.character.data.db.entity.AnimePreviewEntity
import de.coldtea.anidex.character.data.db.entity.CharacterEntity
import de.coldtea.anidex.character.data.db.entity.CharacterPictureEntity
import de.coldtea.anidex.character.data.db.entity.VoiceActorPreviewEntity
import de.coldtea.anidex.content.data.db.dao.DaoAnime
import de.coldtea.anidex.content.data.db.dao.DaoAnimePageKeys
import de.coldtea.anidex.content.data.db.entity.AnimeEntity
import de.coldtea.anidex.content.data.db.entity.AnimePageKeysEntity
import de.coldtea.anidex.contentdetail.data.db.dao.DaoAnimeDetail
import de.coldtea.anidex.contentdetail.data.db.dao.DaoAnimeDetailPictures
import de.coldtea.anidex.contentdetail.data.db.dao.DaoAnimeDetailVideos
import de.coldtea.anidex.contentdetail.data.db.dao.DaoCharacterPreview
import de.coldtea.anidex.contentdetail.data.db.dao.DaoStaffPreview
import de.coldtea.anidex.contentdetail.data.db.entity.AnimeDetailEntity
import de.coldtea.anidex.contentdetail.data.db.entity.AnimeDetailPicturesEntitiy
import de.coldtea.anidex.contentdetail.data.db.entity.AnimeDetailVideosEntitiy
import de.coldtea.anidex.contentdetail.data.db.entity.CharacterPreviewEntity
import de.coldtea.anidex.contentdetail.data.db.entity.StaffPreviewEntity
import de.coldtea.anidex.watchlist.data.db.dao.DaoWatchlist
import de.coldtea.anidex.watchlist.data.db.entity.WatchlistEntity

@SuppressLint("RestrictedApi")
@Database(
    entities = [
        //Content
        AnimeEntity::class,
        AnimePageKeysEntity::class,
        //Content Detail
        AnimeDetailEntity::class,
        CharacterPreviewEntity::class,
        StaffPreviewEntity::class,
        AnimeDetailPicturesEntitiy::class,
        AnimeDetailVideosEntitiy::class,
        //Character
        CharacterEntity::class,
        AnimePreviewEntity::class,
        VoiceActorPreviewEntity::class,
        CharacterPictureEntity::class,
        //Watchlist
        WatchlistEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AnidexDatabase : RoomDatabase() {

    //Content
    abstract val daoAnime: DaoAnime
    abstract val daoAnimePageKeys: DaoAnimePageKeys

    //Content Detail
    abstract val daoAnimeDetail: DaoAnimeDetail
    abstract val daoCharacterPreview: DaoCharacterPreview
    abstract val daoStaffPreview: DaoStaffPreview
    abstract val daoAnimeDetailPictures: DaoAnimeDetailPictures
    abstract val daoAnimeDetailVideos: DaoAnimeDetailVideos

    //Character
    abstract val daoCharacters: DaoCharacters
    abstract val daoAnimePreview: DaoAnimePreview
    abstract val daoVoiceActorsPreview: DaoVoiceActorsPreview
    abstract val daoCharacterPicture: DaoCharacterPicture

    //My List
    abstract val daoWatchlist: DaoWatchlist

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
