package de.coldtea.anidex.base.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.coldtea.anidex.base.data.SharedPreferencesRepository
import de.coldtea.anidex.content.domain.ContentRepository
import de.coldtea.anidex.content.domain.paingsource.PagingSourceManager
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PagingModule {

    @Provides
    @Singleton
    fun providePagingSourceManager(
        contentRepository: ContentRepository,
        sharedPreferencesRepository: SharedPreferencesRepository
    ) =
        PagingSourceManager(contentRepository, sharedPreferencesRepository)

}