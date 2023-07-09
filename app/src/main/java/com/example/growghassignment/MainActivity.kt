package com.example.growghassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val button1: Button = findViewById(R.id.Button1)
        button1.setOnClickListener {
            val intent = Intent(this, Feed::class.java)
            startActivity(intent)
        }

        val button2: Button = findViewById(R.id.Button2)
        button2.setOnClickListener {
            val intent = Intent(this, ImageUpload::class.java)
            startActivity(intent)
        }

    }
}