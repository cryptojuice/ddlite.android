package com.example.doordashlite.discover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.doordashlite.R
import kotlinx.android.synthetic.main.item_popular_item_image.view.*

class PopularItemsImageAdapter(private val data: List<String>) : RecyclerView.Adapter<PopularItemsImageAdapter.PopularItemImagesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularItemImagesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_item_image, parent, false)
        return PopularItemImagesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (data.size <= 5) data.size else 5
    }

    override fun onBindViewHolder(holder: PopularItemImagesViewHolder, position: Int) {
        Glide.with(holder.view)
            .load(data[position])
            .transform(CenterCrop(), RoundedCorners(10))
            .into(holder.view.imageView)
    }

    class PopularItemImagesViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}