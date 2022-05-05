package com.atakanmadanoglu.nasa_rover_vehicles.api

import com.atakanmadanoglu.nasa_rover_vehicles.model.PhotosResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NASAMarsAPI {

    @GET("/mars-photos/api/v1/rovers/curiosity/")
    suspend fun getCuriosityPhotos(
        @Query("page")
        page: Int = 1,
        @Query("sol")
        sol: Int = 1000,
        @Query("api_key")
        api_key: String = "DEMO_KEY"
    ): Single<PhotosResponse>

    @GET("/mars-photos/api/v1/rovers/opportunity/")
    suspend fun getOpportunityPhotos(
        @Query("page")
        page: Int = 1,
        @Query("sol")
        sol: Int = 1000,
        @Query("api_key")
        api_key: String = "DEMO_KEY"
    ): Single<PhotosResponse>

    @GET("/mars-photos/api/v1/rovers/spirit/")
    suspend fun getSpiritPhotos(
        @Query("page")
        page: Int = 1,
        @Query("sol")
        sol: Int = 1000,
        @Query("api_key")
        api_key: String = "DEMO_KEY"
    ): Single<PhotosResponse>

    @GET("/mars-photos/api/v1/rovers/spirit/")
    suspend fun getSpecificCameraPhotosForSpirit(
        @Query("page")
        page: Int = 1,
        @Query("sol")
        sol: Int = 1000,
        @Query("camera")
        camera: String,
        @Query("api_key")
        api_key: String = "DEMO_KEY"
    ): Single<PhotosResponse>

    @GET("/mars-photos/api/v1/rovers/spirit/")
    suspend fun getSpecificCameraPhotosForCuriosity(
        @Query("page")
        page: Int = 1,
        @Query("sol")
        sol: Int = 1000,
        @Query("camera")
        camera: String,
        @Query("api_key")
        api_key: String = "DEMO_KEY"
    ): Single<PhotosResponse>

    @GET("/mars-photos/api/v1/rovers/spirit/")
    suspend fun getSpecificCameraPhotosForOpportunity(
        @Query("page")
        page: Int = 1,
        @Query("sol")
        sol: Int = 1000,
        @Query("camera")
        camera: String,
        @Query("api_key")
        api_key: String = "DEMO_KEY"
    ): Single<PhotosResponse>

}