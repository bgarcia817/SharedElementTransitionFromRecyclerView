package com.example.sharedelementtransitionfromrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {

    private val url by lazy {
        intent.getStringExtra("Image")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        image_transition.transitionName = url
        Glide.with(image_transition).load(url).into(image_transition)
    }
}
