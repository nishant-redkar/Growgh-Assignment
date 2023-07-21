package com.example.growghassignment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.growghassignment.Home.MyAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {
    private var isFabVisible = true
    private val SCROLL_THRESHOLD = 20

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.activity_home, container, false)

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager
        val fabAdd: FloatingActionButton = rootView.findViewById(R.id.fab_add)

        val adapter = MyAdapter(requireContext())
        recyclerView.adapter = adapter

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > SCROLL_THRESHOLD && isFabVisible) {
                    fabAdd.hide()
                    isFabVisible = false
                } else if (dy < -SCROLL_THRESHOLD && !isFabVisible) {
                    // Scrolling up, show the FAB
                    fabAdd.show()
                    isFabVisible = true
                }
            }
        })

        fabAdd.setOnClickListener {
            val intent = Intent(requireContext(), ImageUpload::class.java)
            startActivityForResult(intent, 101)
        }

        return rootView
    }
}
