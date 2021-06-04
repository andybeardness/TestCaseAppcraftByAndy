package com.beardness.testcaseappcraftbyandy.models

import com.google.gson.annotations.SerializedName

data class Photo (
    @SerializedName("albumId") val albumID: Int,
    @SerializedName("id") val photoID: Int,
    @SerializedName("title") val title: String,
    @SerializedName("url") val photoUrl: String,
    @SerializedName("thumbnailUrl") val miniUrl: String
)