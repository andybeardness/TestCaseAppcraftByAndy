package com.beardness.testcaseappcraftbyandy.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.beardness.testcaseappcraftbyandy.models.Album
import com.beardness.testcaseappcraftbyandy.room.dao.AlbumDao

@Database(entities = [Album::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}