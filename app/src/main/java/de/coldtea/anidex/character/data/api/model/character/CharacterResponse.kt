package de.coldtea.anidex.character.data.api.model.character


import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class CharacterResponse(
    @SerialName("request_hash")
    var requestHash: String?,
    @SerialName("request_cached")
    var requestCached: Boolean?,
    @SerialName("request_cache_expiry")
    var requestCacheExpiry: Int?,
    @SerialName("mal_id")
    var malId: Int?,
    @SerialName("url")
    var url: String?,
    @SerialName("name")
    var name: String?,
    @SerialName("name_kanji")
    var nameKanji: String?,
    @SerialName("nicknames")
    var nicknames: List<String>?,
    @SerialName("about")
    var about: String?,
    @SerialName("member_favorites")
    var memberFavorites: Int?,
    @SerialName("image_url")
    var imageUrl: String?,
    @SerialName("animeography")
    var animeography: List<AnimeographyResponse>?,
    @SerialName("mangaography")
    var mangaography: List<MangaographyResponse>?,
    @SerialName("voice_actors")
    var voiceActors: List<VoiceActorResponse>?
)