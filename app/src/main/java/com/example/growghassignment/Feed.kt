package com.example.growghassignment

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.growghassignment.R
import com.example.growghassignment.RecyclerView.Adapter
import com.squareup.picasso.Picasso
import org.json.JSONException

class Feed : AppCompatActivity() {

    private lateinit var wallpapers: MutableList<Wallpaper>
    private lateinit var wallpaperAdapter: Adapter
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener {
            fetchWallpapers()
        }

        initializeRecyclerView()
        fetchWallpapers()
    }

    private fun initializeRecyclerView() {
        wallpapers = mutableListOf()
        wallpaperAdapter = Adapter(wallpapers)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = wallpaperAdapter

        val spacingInPixels = resources.getDimensionPixelSize(R.dimen.item_spacing)
        recyclerView.addItemDecoration(Adapter.ItemSpacingDecoration(spacingInPixels))
    }


    private fun fetchWallpapers() {
        val url =
            "https://api.unsplash.com/photos/random?query=programming&count=10&client_id=xqTXG8znx-qYjCRoO-6mOySGTFuVbND3qd-lWJnCMcE"

        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    wallpapers.clear() // Clear existing wallpapers
                    for (i in 0 until response.length()) {
                        val wallpaperObject = response.getJSONObject(i)
                        val urlsObject = wallpaperObject.getJSONObject("urls")
                        val regularUrl = urlsObject.getString("regular")
                        displayWallpaper(regularUrl)
                    }
                    wallpaperAdapter.notifyDataSetChanged()
                } catch (e: JSONException) {
                    Log.e(TAG, "JSON parsing error: " + e.message)
                } finally {
                    swipeRefreshLayout.isRefreshing = false
                }
            },
            { error ->
                Log.e(TAG, "API request error: " + error.message)
                swipeRefreshLayout.isRefreshing = false
            })

        val queue: RequestQueue = Volley.newRequestQueue(this)
        queue.add(request)
    }

    private fun displayWallpaper(imageUrl: String) {
        val wallpaper = Wallpaper(imageUrl)
        wallpapers.add(wallpaper)
    }
}

