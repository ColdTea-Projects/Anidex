package de.coldtea.anidex.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.coldtea.anidex.BuildConfig
import de.coldtea.anidex.data.JikanApi
import de.coldtea.anidex.domain.JikanRepository
import de.coldtea.anidex.data.json
import de.coldtea.anidex.domain.paingsource.ActionPagingSource
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object PagingModule {

    @Provides
    @Singleton
    fun provideActionPagingSource(jikanRepository: JikanRepository) = ActionPagingSource(jikanRepository)

}