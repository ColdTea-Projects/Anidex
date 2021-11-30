package de.coldtea.anidex.data.api

import de.coldtea.anidex.data.api.model.animesbygenre.AnimesByGenreResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface JikanApi {
    @GET("genre/anime/{genre_id}/{page_number}")
    suspend fun getAnimeByGenre(@Path("genre_id") genreId: Int, @Path("page_number") pageNumber: Int): AnimesByGenreResponse?
}