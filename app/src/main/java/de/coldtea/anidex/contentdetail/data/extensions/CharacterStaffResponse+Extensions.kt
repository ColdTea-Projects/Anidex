package de.coldtea.anidex.contentdetail.data.extensions

import de.coldtea.anidex.base.data.extensions.orInvalidId
import de.coldtea.anidex.contentdetail.data.api.model.charactersandstaff.CharacterStaffResponse
import de.coldtea.anidex.contentdetail.data.db.entity.CharacterPreviewEntity
import de.coldtea.anidex.contentdetail.data.db.entity.StaffPreviewEntity

fun CharacterStaffResponse.extractCharacter(animeId: Int): List<CharacterPreviewEntity> =
    characters?.map {
        CharacterPreviewEntity(
            characterId = it.malId.orInvalidId(),
            animeId = animeId,
            name = it.name.orEmpty(),
            imageUrl = it.imageUrl.orEmpty()
        )
    }.orEmpty()

fun CharacterStaffResponse.extractStaff(animeId: Int): List<StaffPreviewEntity> =
    staff?.map {
        StaffPreviewEntity(
            staffId = it.malId.orInvalidId(),
            animeId = animeId,
            name = it.name.orEmpty(),
            imageUrl = it.imageUrl.orEmpty()
        )
    }.orEmpty()