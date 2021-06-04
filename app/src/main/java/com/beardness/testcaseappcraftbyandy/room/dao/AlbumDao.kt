package com.beardness.testcaseappcraftbyandy.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.beardness.testcaseappcraftbyandy.models.Album

@Dao
interface AlbumDao {
    @Query(value = "SELECT * FROM album")
    fun getAll(): List<Album>

    @Query(value = "SELECT * FROM album WHERE album_id = :id")
    fun getAlbumByID(id: Int): List<Album>

    @Insert
    fun insertAlbums(vararg albums: Album)

    @Query(value = "DELETE FROM album WHERE album_id = :id")
    fun deleteAlbumByID(id: Int)

    @Delete
    fun deleteAlbum(album: Album)
}