package com.example.doordashlite.discover

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.doordashlite.R
import com.example.doordashlite.domain.entity.Restaurant
import kotlinx.android.synthetic.main.item_popular_item_image.view.*
import kotlinx.android.synthetic.main.item_restaurant_itemview.view.*

class RestaurantsAdapter(private var data: ArrayList<Restaurant>) : RecyclerView.Adapter<RestaurantsAdapter.RestaurantsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant_itemview, parent, false)
        return RestaurantsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        holder.view.textView_name.text = data[position].name
        holder.view.textView_description.text = data[position].description
        holder.view.textView_status.text = data[position].status

        holder.view.recyclerView_menu_images.apply {
            this.visibility = View.GONE
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            val imageUrls = mutableListOf<String>()

            data[position].menus?.flatMap {
                it.popularItems.orEmpty()
            }?.forEach {
                imageUrls.add(it.img_url)
            }

            if (imageUrls.size > 0) {
                this.visibility = View.VISIBLE
            }

            adapter = PopularItemsImageAdapter(imageUrls)
        }
    }

    fun update(newData: ArrayList<Restaurant>) {
        data = newData
        notifyDataSetChanged()
    }

    class RestaurantsViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}