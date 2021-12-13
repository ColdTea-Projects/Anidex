package de.coldtea.anidex.base.data.api

import de.coldtea.anidex.character.data.api.model.character.CharacterResponse
import de.coldtea.anidex.character.data.api.model.media.CharacterPicturesResponse
import de.coldtea.anidex.content.data.api.model.animesbygenre.AnimesByGenreResponse
import de.coldtea.anidex.contentdetail.data.api.model.animedetail.AnimeDetailResponse
import de.coldtea.anidex.contentdetail.data.api.model.charactersandstaff.CharacterStaffResponse
import de.coldtea.anidex.contentdetail.data.api.model.media.PictureBundleResponse
import de.coldtea.anidex.contentdetail.data.api.model.media.VideoBundleResponse
import de.coldtea.anidex.search.data.api.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface JikanApi {
    // region Content
    @GET("genre/anime/{genre_id}/{page_number}")
    suspend fun getAnimeByGenre(@Path("genre_id") genreId: Int, @Path("page_number") pageNumber: Int): AnimesByGenreResponse?
    // endregion

    // region Anime Details
    @GET("anime/{anime_id}")
    suspend fun getAnimeDetailById(@Path("anime_id") animeId: Int): AnimeDetailResponse?

    @GET("anime/{anime_id}/characters_staff")
    suspend fun getCharactersAndStaff(@Path("anime_id") animeId: Int): CharacterStaffResponse?

    @GET("anime/{anime_id}/pictures")
    suspend fun getAnimeDetailPictures(@Path("anime_id") animeId: Int): PictureBundleResponse?

    @GET("anime/{anime_id}/videos")
    suspend fun getAnimeDetailVideos(@Path("anime_id") animeId: Int): VideoBundleResponse?

    // endregion

    // region characters
    @GET("character/{character_id}")
    suspend fun getCharacterById(@Path("character_id") characterId: Int): CharacterResponse

    @GET("character/{character_id}/pictures")
    suspend fun getCharcterPictures(@Path("character_id") characterId: Int): CharacterPicturesResponse
    // endregion

    // region search
    @GET("search/anime")
    suspend fun getSearchResults(@Query("q") q: String, @Query("page") page: Int): SearchResponse

    // endregion
}