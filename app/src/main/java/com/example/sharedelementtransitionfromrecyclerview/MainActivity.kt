package com.example.sharedelementtransitionfromrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getPhotosFromWebsite()

    }

    //Retrieve 20 photos from the website picsum.photos
    private fun getPhotosFromWebsite() = (100..120)
        .map{"https://picsum.photos/1000/700?image=$it"}
}
