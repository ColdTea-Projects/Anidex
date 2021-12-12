package de.coldtea.anidex.contentdetail.data.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import de.coldtea.anidex.contentdetail.data.db.entity.AnimeDetailEntity
import de.coldtea.anidex.contentdetail.data.db.entity.AnimeDetailPicturesEntitiy
import de.coldtea.anidex.contentdetail.data.db.entity.AnimeDetailVideosEntitiy
import de.coldtea.anidex.contentdetail.data.db.entity.CharacterPreviewEntity
import de.coldtea.anidex.contentdetail.data.db.entity.StaffPreviewEntity
import de.coldtea.anidex.contentdetail.domain.model.AnimeDetail
import de.coldtea.anidex.contentdetail.domain.model.AnimePictures
import de.coldtea.anidex.contentdetail.domain.model.AnimeVideos
import de.coldtea.anidex.contentdetail.domain.model.CharacterPreview
import de.coldtea.anidex.contentdetail.domain.model.StaffPreview

data class AnimeDetailBundle(
    @Embedded val animeDetail: AnimeDetailEntity,

    @Relation(
        entity = CharacterPreviewEntity::class,
        parentColumn = "anime_id",
        entityColumn = "fk_anime_id"
    )
    val characters: List<CharacterPreviewEntity>,

    @Relation(
        entity = StaffPreviewEntity::class,
        parentColumn = "anime_id",
        entityColumn = "fk_anime_id"
    )
    val staff: List<StaffPreviewEntity>,

    @Relation(
        entity = AnimeDetailPicturesEntitiy::class,
        parentColumn = "anime_id",
        entityColumn = "fk_anime_id"
    )
    val pictures: List<AnimeDetailPicturesEntitiy>,

    @Relation(
        entity = AnimeDetailVideosEntitiy::class,
        parentColumn = "anime_id",
        entityColumn = "fk_anime_id"
    )
    val videos: List<AnimeDetailVideosEntitiy>
) {
    fun convertToDomainObject(): AnimeDetail =
        AnimeDetail(
            animeId = animeDetail.animeId,
            title = animeDetail.title,
            date = animeDetail.date,
            imageUrl = animeDetail.imageUrl,
            background = animeDetail.background,
            duration = animeDetail.duration,
            rating = animeDetail.rating,
            score = animeDetail.score,
            genres = animeDetail.genres,
            producers = animeDetail.producers,
            episodes = animeDetail.episodes,
            characters = characters.map { it.convertToDomainObject() },
            staff = staff.map { it.convertToDomainObject() },
            pictures = pictures.map { it.convertToDomainObject() },
            videos = videos.map { it.convertToDomainObject() },
        )

    private fun CharacterPreviewEntity.convertToDomainObject() =
        CharacterPreview(
            characterId = characterId,
            animeId = animeId,
            name = name,
            imageUrl = imageUrl
        )

    private fun StaffPreviewEntity.convertToDomainObject() =
        StaffPreview(
            staffId = staffId,
            animeId = animeId,
            name = name,
            imageUrl = imageUrl
        )

    private fun AnimeDetailPicturesEntitiy.convertToDomainObject() =
        AnimePictures(
            animeId = animeId,
            large = large,
            small = small
        )

    private fun AnimeDetailVideosEntitiy.convertToDomainObject() =
        AnimeVideos(
            animeId = animeId,
            url = url
        )
}