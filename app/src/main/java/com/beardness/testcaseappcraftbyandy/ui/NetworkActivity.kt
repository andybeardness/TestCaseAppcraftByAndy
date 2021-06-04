package com.beardness.testcaseappcraftbyandy.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beardness.testcaseappcraftbyandy.R
import com.beardness.testcaseappcraftbyandy.adapters.AlbumsRecyclerAdapter
import com.beardness.testcaseappcraftbyandy.models.Album
import com.beardness.testcaseappcraftbyandy.retrofit.RetroAlbums
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkActivity : AppCompatActivity() {

    lateinit var retrofit: Retrofit

    lateinit var recycler: RecyclerView
    lateinit var progressBar: ProgressBar
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        recycler = findViewById(R.id.albums_recycler)
        progressBar = findViewById(R.id.pb_network)
        context = this

        retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retroAlbums: RetroAlbums = retrofit.create(RetroAlbums::class.java)

        val albums = retroAlbums.getAlbums()
        albums.enqueue(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                if (response.isSuccessful) {
                    val album = response.body()
                    if (album != null) {
                        Log.d("NetworkActivity", " $album")
                        recycler.layoutManager = LinearLayoutManager(context)
                        recycler.adapter = AlbumsRecyclerAdapter(album, context)
                        progressBar.visibility = View.INVISIBLE
                    }
                }
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {}

        })


    }
}