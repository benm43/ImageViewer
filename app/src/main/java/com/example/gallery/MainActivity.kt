package com.example.gallery

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.gallery.R

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private val imageResources = listOf(
        R.drawable.demo_obs,
        R.drawable.monetization,
        R.drawable.realtime_obs
    )
    private var currentPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        updateImage()

        val prevButton: Button = findViewById(R.id.prevButton)
        prevButton.setOnClickListener {
            currentPosition = (currentPosition - 1 + imageResources.size) % imageResources.size
            updateImage()
        }

        val nextButton: Button = findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            currentPosition = (currentPosition + 1) % imageResources.size
            updateImage()
        }

        val exitButton: Button = findViewById(R.id.exitButton)
        exitButton.setOnClickListener {
            finish() // Close the activity and exit the app
        }
    }

    private fun updateImage() {
        imageView.setImageResource(imageResources[currentPosition])
    }
}
