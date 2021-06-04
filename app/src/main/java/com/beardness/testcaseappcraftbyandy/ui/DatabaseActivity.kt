package com.beardness.testcaseappcraftbyandy.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.beardness.testcaseappcraftbyandy.R
import com.beardness.testcaseappcraftbyandy.adapters.AlbumsRecyclerAdapter
import com.beardness.testcaseappcraftbyandy.models.Album
import com.beardness.testcaseappcraftbyandy.room.AppDatabase
import com.beardness.testcaseappcraftbyandy.room.dao.AlbumDao

class DatabaseActivity : AppCompatActivity() {

    lateinit var recycler: RecyclerView
    lateinit var tvNoAlbums: TextView
    lateinit var context: Context

    lateinit var db: AppDatabase
    lateinit var albumDao: AlbumDao

    lateinit var albums: List<Album>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)

        recycler = findViewById(R.id.albums_db_recycler)
        tvNoAlbums = findViewById(R.id.tv_no_albums)
        context = this

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "album"
        ).allowMainThreadQueries().build() // TODO remove allowMainThreadQueries !
    }

    override fun onResume() {
        super.onResume()
        albumDao = db.albumDao()

        albums = albumDao.getAll()

        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = AlbumsRecyclerAdapter(albums, context)

        if (albums.isEmpty()) {
            recycler.visibility = View.INVISIBLE
            tvNoAlbums.visibility = View.VISIBLE
        }
        else {
            tvNoAlbums.visibility = View.INVISIBLE
            recycler.visibility = View.VISIBLE
        }
    }
}