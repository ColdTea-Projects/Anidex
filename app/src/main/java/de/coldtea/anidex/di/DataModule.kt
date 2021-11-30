package de.coldtea.anidex.di

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import de.coldtea.anidex.BuildConfig
import de.coldtea.anidex.data.JikanRepository
import de.coldtea.anidex.data.api.JikanApi
import de.coldtea.anidex.data.api.SharedPreferencesRepository
import de.coldtea.anidex.data.json
import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun provideSharedPreferencesRepository(@ApplicationContext appContext: Context) = SharedPreferencesRepository(appContext)

    @Provides
    @Singleton
    fun provideGamesRepository(jikanApi: JikanApi): JikanRepository = JikanRepository(jikanApi)

    @Provides
    @Singleton
    fun provideGamesApi(retrofit: Retrofit): JikanApi = retrofit.create(JikanApi::class.java)

    @ExperimentalSerializationApi
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.ROOT_URL_JIKAN_API)
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient().newBuilder().apply {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(httpLoggingInterceptor)
        }.build()

}