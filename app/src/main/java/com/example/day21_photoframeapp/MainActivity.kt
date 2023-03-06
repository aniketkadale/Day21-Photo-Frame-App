package com.example.day21_photoframeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.example.day21_photoframeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image: ImageView
    val names = arrayOf("Virat Kohli", "Jenna Ortega", "Tommy Shelby")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        val prev = findViewById<ImageButton>(R.id.imgPrev)
        val next = findViewById<ImageButton>(R.id.imgNext)
        val text = findViewById<TextView>(R.id.textView2)

        prev.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f

            currentImage = (3+ currentImage-1)%3
            val idImageToShowString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f
            text.text = names[currentImage]
        }

        next.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrentImageInt)
            image.alpha= 0f

            currentImage = (3 + currentImage + 1) % 3
            val idImageToShowString = "pic$currentImage"
            // convert string id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha= 1f
            text.text = names[currentImage]

        }


    }
}