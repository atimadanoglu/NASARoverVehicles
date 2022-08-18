package com.atakanmadanoglu.nasa_rover_vehicles.di

import android.content.Context
import com.atakanmadanoglu.nasa_rover_vehicles.R
import com.atakanmadanoglu.nasa_rover_vehicles.api.NASAMarsAPI
import com.atakanmadanoglu.nasa_rover_vehicles.util.Constants.BASE_URL
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectRetrofit(): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    @Singleton
    @Provides
    fun injectGlide(
        @ApplicationContext context : Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions().placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
    )

    @Singleton
    @Provides
    fun injectNasaApiService(
        retrofit: Retrofit
    ): NASAMarsAPI = retrofit.create(NASAMarsAPI::class.java)

}