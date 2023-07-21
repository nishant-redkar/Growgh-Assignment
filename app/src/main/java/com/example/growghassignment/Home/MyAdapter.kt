package com.example.growghassignment.Home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.growghassignment.R


class MyAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val headerViewType = 0
    private val middleViewType = 1
    private val itemViewType = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            headerViewType -> {
                val headerView =
                    LayoutInflater.from(context).inflate(R.layout.home_heading, parent, false)
                HeaderViewHolder(headerView)
            }
            middleViewType -> {
                val middleView =
                    LayoutInflater.from(context).inflate(R.layout.home_browse, parent, false)
                MiddleViewHolder(middleView)
            }
            else -> {
                val itemView =
                    LayoutInflater.from(context).inflate(R.layout.home_post, parent, false)
                ItemViewHolder(itemView)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> headerViewType
            1 -> middleViewType
            else -> itemViewType
        }
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class MiddleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

