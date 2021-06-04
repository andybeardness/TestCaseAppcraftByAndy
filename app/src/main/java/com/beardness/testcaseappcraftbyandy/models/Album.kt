package com.beardness.testcaseappcraftbyandy.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Album(
    @SerializedName(value = "id")
    @ColumnInfo(name = "album_id")
    val albumID: Int?,

    @SerializedName(value = "userId")
    @ColumnInfo(name = "user_id")
    val userID: Int?,

    @SerializedName(value = "title")
    @ColumnInfo(name = "album_title")
    val albumTitle: String?,

    @PrimaryKey(autoGenerate = true)
    val aid: Int = 0
) {

}