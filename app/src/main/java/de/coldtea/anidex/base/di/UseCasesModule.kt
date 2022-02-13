package de.coldtea.anidex.base.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.coldtea.anidex.character.data.CharacterRepository
import de.coldtea.anidex.character.domain.AcquireCharacterUseCase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UseCasesModule {

    @Provides
    @Singleton
    fun provideSharedPreferencesRepository(characterRepository: CharacterRepository) = AcquireCharacterUseCase(characterRepository)

}