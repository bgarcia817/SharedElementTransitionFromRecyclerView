package com.example.sharedelementtransitionfromrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Set Up RecyclerView
        recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 4)
            adapter = ImageAdapter(getPhotosFromWebsite(), ::selectedPhoto)
        }

    }

    private fun selectedPhoto(url: String, image: View) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, image, image.transitionName).toBundle()
        Intent(this, ImageActivity::class.java)
            .putExtra("Image", url)
            .let {
                startActivity(it, options)
            }
    }

    //Retrieve 20 photos from the website picsum.photos
    private fun getPhotosFromWebsite() = (100..123)
        .map{"https://picsum.photos/1000/700?image=$it"}
}
