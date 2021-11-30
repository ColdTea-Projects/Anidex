package de.coldtea.anidex.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.coldtea.anidex.data.JikanRepository
import de.coldtea.anidex.data.api.SharedPreferencesRepository
import de.coldtea.anidex.domain.paingsource.PagingSourceManager
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PagingModule {

    @Provides
    @Singleton
    fun providePagingSourceManager(
        jikanRepository: JikanRepository,
        sharedPreferencesRepository: SharedPreferencesRepository
    ) =
        PagingSourceManager(jikanRepository, sharedPreferencesRepository)

}