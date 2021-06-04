package com.beardness.testcaseappcraftbyandy.retrofit

import com.beardness.testcaseappcraftbyandy.models.Photo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetroPhotos {
    @GET("photos")
    fun getPhotos(@Query("albumId") id: Int): Call<List<Photo>>
}