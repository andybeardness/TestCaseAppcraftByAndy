package com.beardness.testcaseappcraftbyandy.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.beardness.testcaseappcraftbyandy.R
import com.beardness.testcaseappcraftbyandy.models.Photo
import com.squareup.picasso.Picasso

class PhotosRecyclerAdapter(private val photos: List<Photo>, private val context: Context) :
    RecyclerView.Adapter<PhotosRecyclerAdapter.PhotosRecyclerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosRecyclerViewHolder {
        val itemView: View =
            LayoutInflater.from(parent.context).inflate(R.layout.photo_list_item, parent, false)
        return PhotosRecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhotosRecyclerViewHolder, position: Int) {
        Picasso.get().load(photos[position].miniUrl).into(holder.photoPreview)
        holder.photoID.text = photos[position].photoID.toString()
        holder.photoTitle.text = photos[position].title
    }

    override fun getItemCount(): Int = photos.size

    class PhotosRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var photoPreview: ImageView = itemView.findViewById(R.id.photo_preview)
        var photoID: TextView = itemView.findViewById(R.id.photo_id)
        var photoTitle: TextView = itemView.findViewById(R.id.photo_title)
    }
}