package com.beardness.testcaseappcraftbyandy.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.beardness.testcaseappcraftbyandy.R
import com.beardness.testcaseappcraftbyandy.adapters.PhotosRecyclerAdapter
import com.beardness.testcaseappcraftbyandy.models.Album
import com.beardness.testcaseappcraftbyandy.models.Photo
import com.beardness.testcaseappcraftbyandy.retrofit.RetroPhotos
import com.beardness.testcaseappcraftbyandy.room.AppDatabase
import com.beardness.testcaseappcraftbyandy.room.dao.AlbumDao
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotosActivity : AppCompatActivity() {

    val recyclerSpanCount: Int = 2

    lateinit var retrofit: Retrofit

    lateinit var recycler: RecyclerView
    lateinit var fabSave: FloatingActionButton
    lateinit var fabDelete: FloatingActionButton
    lateinit var progressBar: ProgressBar
    lateinit var context: Context

    private var albumTitle: String = ""
    private var albumID: Int = -1
    private var userID: Int = -1

    lateinit var db: AppDatabase
    lateinit var albumDao: AlbumDao

    companion object {
        const val extraAlbumTitle: String = "albumTitle"
        const val extraAlbumID: String = "albumID"
        const val extraUserID: String = "userID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        recycler = findViewById(R.id.photos_recycler)
        fabSave = findViewById(R.id.fab_save_album)
        fabDelete = findViewById(R.id.fab_delete_album)
        progressBar = findViewById(R.id.pb_photos)
        context = this

        albumTitle = intent.getStringExtra(extraAlbumTitle) ?: "Unknown album title"
        albumID = intent.getStringExtra(extraAlbumID)?.toInt() ?: -1
        userID = intent.getStringExtra(extraUserID)?.toInt() ?: -1

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "album"
        ).allowMainThreadQueries().build() // TODO remove allowMainThreadQueries !

        albumDao = db.albumDao()

        if (albumID == -1) fabSave.visibility = View.INVISIBLE
        else {
            if (albumDao.getAlbumByID(albumID).isEmpty()) fabDelete.visibility = View.INVISIBLE
            else fabSave.visibility = View.INVISIBLE
        }

        retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retroPhotos: RetroPhotos = retrofit.create(RetroPhotos::class.java)

        val photos = retroPhotos.getPhotos(intent.getIntExtra(extraAlbumID, 1))

        photos.enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                if (response.isSuccessful) {
                    val photo = response.body()
                    if (photo != null) {
                        Log.d("PhotosActivity", " $photo")
                        recycler.layoutManager = GridLayoutManager(context, recyclerSpanCount)
                        recycler.adapter = PhotosRecyclerAdapter(photo, context)
                        progressBar.visibility = View.INVISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {}

        })

        fabSave.setOnClickListener {
            Toast.makeText(
                this,
                "SAVE album ID : $albumID; title : $albumTitle; user ID : $userID",
                Toast.LENGTH_SHORT
            ).show()

            albumDao.insertAlbums(Album(albumID, userID, albumTitle))

            fabSave.visibility = View.INVISIBLE
            fabDelete.visibility = View.VISIBLE
        }

        fabDelete.setOnClickListener {
            Toast.makeText(
                this,
                "DELETE album ID : $albumID; title : $albumTitle; user ID : $userID",
                Toast.LENGTH_SHORT
            ).show()

            albumDao.deleteAlbumByID(albumID)

            fabSave.visibility = View.VISIBLE
            fabDelete.visibility = View.INVISIBLE
        }

    }
}