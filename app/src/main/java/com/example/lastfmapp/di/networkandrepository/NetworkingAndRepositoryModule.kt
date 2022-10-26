package com.example.lastfmapp.di.networkandrepository

import android.content.Context
import com.example.lastfmapp.core.Dispatchers
import com.example.lastfmapp.core.HandleApiRequest
import com.example.lastfmapp.core.ProvideResources
import com.example.lastfmapp.data.api.ApiService
import com.example.lastfmapp.data.repository.albuminfoRepository.AlbumInfoRepo
import com.example.lastfmapp.data.repository.albuminfoRepository.AlbumInfoRepoImpl
import com.example.lastfmapp.data.repository.genresRepository.GenresRepo
import com.example.lastfmapp.data.repository.genresRepository.GenresRepoImpl
import com.example.lastfmapp.data.repository.topalbumRepository.TopAlbumRepo
import com.example.lastfmapp.data.repository.topalbumRepository.TopAlbumRepoImpl
import com.example.lastfmapp.data.repository.topalbumRepository.searchRepository.TopSearchRepo
import com.example.lastfmapp.data.repository.topalbumRepository.searchRepository.TopSearchRepoImpl
import com.example.lastfmapp.utils.CONSTANTS
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkingAndRepositoryModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
        .callTimeout(15, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .readTimeout(15, TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true).build()

    @Provides
    @Singleton
    fun provideRetrofitClient(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(CONSTANTS.BaseURL).addConverterFactory(
            MoshiConverterFactory.create(
                Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
            )
        ).client(okHttpClient).build()

    @Provides
    fun provideGenresRepository(
        apiService: ApiService,
        handleApiRequest: HandleApiRequest
    ): GenresRepo = GenresRepoImpl(apiService, handleApiRequest)



    @Provides
    @Singleton
    fun provideRetrofitGenres(retrofitClient: Retrofit): ApiService =
        retrofitClient.create(ApiService::class.java)

    @Provides
    fun provideTopAlbumRepository(
        apiService: ApiService,
        handleApiRequest: HandleApiRequest
    ): TopAlbumRepo = TopAlbumRepoImpl(apiService, handleApiRequest)

    @Provides
    fun provideTopSearchRepository(
        apiService: ApiService,
        handleApiRequest: HandleApiRequest
    ): TopSearchRepo = TopSearchRepoImpl(apiService, handleApiRequest)

    @Provides
    fun provideAlbumInfoRepository(
        apiService: ApiService,
        handleApiRequest: HandleApiRequest
    ): AlbumInfoRepo = AlbumInfoRepoImpl(apiService, handleApiRequest)

    @Provides
    fun provideResources(@ApplicationContext context: Context): ProvideResources =
        ProvideResources.Base(context)

    @Provides
    fun provideDispatchers(): Dispatchers = Dispatchers.Base()

    @Provides
    fun provideBaseApiRequest(provideResources: ProvideResources): HandleApiRequest =
        HandleApiRequest.Base(provideResources)


}