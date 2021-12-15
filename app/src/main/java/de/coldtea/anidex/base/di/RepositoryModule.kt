package de.coldtea.anidex.base.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import de.coldtea.anidex.base.data.SharedPreferencesRepository
import de.coldtea.anidex.base.data.api.JikanApi
import de.coldtea.anidex.base.data.db.AnidexDatabase
import de.coldtea.anidex.character.domain.CharacterRepository
import de.coldtea.anidex.content.domain.ContentRepository
import de.coldtea.anidex.contentdetail.domain.ContentDetailRepository
import de.coldtea.anidex.search.domain.SearchRepository
import de.coldtea.anidex.watchlist.domain.WatchlistRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSharedPreferencesRepository(@ApplicationContext appContext: Context) = SharedPreferencesRepository(appContext)

    @Provides
    @Singleton
    fun provideSearchRepository(jikanApi: JikanApi): SearchRepository = SearchRepository(jikanApi)

    @Provides
    @Singleton
    fun provideContentDetailRepository(jikanApi: JikanApi, anidexDatabase: AnidexDatabase): ContentDetailRepository = ContentDetailRepository(jikanApi, anidexDatabase)

    @Provides
    @Singleton
    fun provideContentRepository(jikanApi: JikanApi, anidexDatabase: AnidexDatabase): ContentRepository = ContentRepository(jikanApi, anidexDatabase)

    @Provides
    @Singleton
    fun provideCharacterRepository(jikanApi: JikanApi, anidexDatabase: AnidexDatabase): CharacterRepository = CharacterRepository(jikanApi, anidexDatabase)

    @Provides
    @Singleton
    fun provideWatchlistRepository(anidexDatabase: AnidexDatabase): WatchlistRepository = WatchlistRepository(anidexDatabase)

}