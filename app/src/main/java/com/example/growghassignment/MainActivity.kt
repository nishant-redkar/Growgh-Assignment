package com.example.growghassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import com.example.growghassignment.Maps.MapsActivity
import com.example.growghassignment.Shorts.ShortsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, homeFragment)
            .commit()



        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.navigation_item2 -> {
                    // Create an instance of the Home fragment
                    val homeFragment = HomeFragment()

                    // Replace the existing fragment in the FrameLayout with the Home fragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container_fragment, homeFragment)
                        .commit()

                    // Return true to indicate that the item selection has been handled
                    true
                }

                R.id.navigation_item3 -> {
                    val shortsFragment = ShortsFragment()

                    // Replace the existing fragment in the FrameLayout with the Home fragment
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container_fragment, shortsFragment)
                        .commit()

                    // Return true to indicate that the item selection has been handled
                    true
                }

                R.id.navigation_item4 -> {
                    val intent = Intent(this, MapsActivity::class.java)
                    startActivity(intent)
                    true
                }
                // Add more cases for other menu items if needed
                else -> false
            }
        }


    }
}