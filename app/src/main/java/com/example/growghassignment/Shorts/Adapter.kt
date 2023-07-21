package com.example.growghassignment.Shorts

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.growghassignment.R

class Adapter(private val videoItemList: List<Model>, private val context: Context) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shorts_back, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(position)
        holder.textChannel.text = videoItemList[position].channel
        holder.textDescription.text = videoItemList[position].description
        Glide.with(context).load(videoItemList[position].channelImage).into(holder.imageChannel)
        Glide.with(context).load(videoItemList[position].musicImage).into(holder.imageMusic)
        holder.textDescription.isSelected = true
    }

    override fun getItemCount(): Int {
        return videoItemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val videoView: VideoView = itemView.findViewById(R.id.videoView)
        val textDescription: TextView = itemView.findViewById(R.id.description)
        val textChannel: TextView = itemView.findViewById(R.id.channel)
        val progressBar: ProgressBar = itemView.findViewById(R.id.progressBar)
        val imageMusic: ImageView = itemView.findViewById(R.id.musicImage)
        val imageChannel: ImageView = itemView.findViewById(R.id.channelImage)

        fun setData(position: Int) {
            if (videoItemList[position].videoUrl != null) {
                videoView.setVideoURI(Uri.parse(videoItemList[position].videoUrl))
            }
            videoView.setOnPreparedListener { mediaPlayer: MediaPlayer ->
                progressBar.visibility = View.GONE
                mediaPlayer.start()
            }
            videoView.setOnCompletionListener { mediaPlayer: MediaPlayer ->
                mediaPlayer.start()
            }
            videoView.setOnErrorListener { mediaPlayer: MediaPlayer?, what: Int, extra: Int ->
                Toast.makeText(context, "Error loading the video", Toast.LENGTH_SHORT).show()
                true
            }
        }
    }
}