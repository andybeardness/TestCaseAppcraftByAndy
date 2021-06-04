package com.beardness.testcaseappcraftbyandy.retrofit

import com.beardness.testcaseappcraftbyandy.models.Album
import retrofit2.Call
import retrofit2.http.GET

interface RetroAlbums {
    @GET("albums")
    fun getAlbums(): Call<List<Album>>

}

