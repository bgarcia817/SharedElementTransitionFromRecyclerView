package com.example.sharedelementtransitionfromrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ImageAdapter(private val images: List<String>, private val onClick: (String, View) -> Unit) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        Log.d("imagelist", "$images")
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_holder, parent, false)
        return ImageViewHolder(view)
    }

    override fun getItemCount() = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) = holder.bind(images[position])

    inner class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(url: String) {
            (itemView as ImageView).apply {
                Glide.with(this).load(url).into(this) //1
                transitionName = url //2
                setOnClickListener { onClick(url, it) }
            }
        }
    }
}