package com.shoshin.moviereviews.di.review

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shoshin.data.interfaces.services.IReviewsService
import com.shoshin.moviereviews.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ReviewService {

    @Named("baseUrl")
    @Provides
    fun baseUrl() = "https://api.nytimes.com/"

    @Singleton
    @Provides
    fun provideReviewService(retrofit: Retrofit): IReviewsService =
        retrofit.create(IReviewsService::class.java)

    @Singleton
    @Provides
    fun providesRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    if (BuildConfig.DEBUG) level = HttpLoggingInterceptor.Level.BASIC
                }
            )
            .build()

    @Singleton
    @Provides
    fun providesGsonClient(): Gson = GsonBuilder().create()

    @Singleton
    @Provides
    fun providesRetrofit(
        @Named("baseUrl") baseUrl: String,
        builder: Retrofit.Builder,
        okHttpClient: OkHttpClient,
        gson: Gson
    ): Retrofit = builder
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .baseUrl(baseUrl)
        .build()
}