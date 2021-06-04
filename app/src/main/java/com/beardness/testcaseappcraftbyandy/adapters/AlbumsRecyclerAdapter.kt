package com.beardness.testcaseappcraftbyandy.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.beardness.testcaseappcraftbyandy.R
import com.beardness.testcaseappcraftbyandy.models.Album
import com.beardness.testcaseappcraftbyandy.ui.PhotosActivity

class AlbumsRecyclerAdapter(private val albums: List<Album>, private val context: Context) :
    RecyclerView.Adapter<AlbumsRecyclerAdapter.AlbumsRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsRecyclerViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.network_list_item, parent, false)
        return AlbumsRecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AlbumsRecyclerViewHolder, position: Int) {
        holder.albumTitle.text = albums[position].albumTitle
        holder.albumID.text = albums[position].albumID.toString()
        holder.userID.text = albums[position].userID.toString()

        holder.itemView.setOnClickListener {
            val intent = Intent(context, PhotosActivity::class.java)
            intent.putExtra(PhotosActivity.extraAlbumTitle, holder.albumTitle.text)
            intent.putExtra(PhotosActivity.extraAlbumID, holder.albumID.text)
            intent.putExtra(PhotosActivity.extraUserID, holder.userID.text)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = albums.size

    class AlbumsRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var albumTitle: TextView = itemView.findViewById(R.id.li_album_title)
        var albumID: TextView = itemView.findViewById(R.id.li_album_name)
        var userID: TextView = itemView.findViewById(R.id.li_user_name)
    }
}