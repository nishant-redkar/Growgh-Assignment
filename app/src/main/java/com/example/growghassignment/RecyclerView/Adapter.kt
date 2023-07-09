package com.example.growghassignment.RecyclerView

import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.growghassignment.R
import com.example.growghassignment.Wallpaper
import com.squareup.picasso.Picasso

class Adapter(private val wallpapers: List<Wallpaper>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wallpaper = wallpapers[position]

        Picasso.get()
            .load(wallpaper.imageUrl)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return wallpapers.size
    }

    class ItemSpacingDecoration(private val spacing: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.top = spacing
            outRect.bottom = spacing
            outRect.left = spacing
            outRect.right = spacing
        }
    }

}

