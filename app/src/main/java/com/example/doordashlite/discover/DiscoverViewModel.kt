package com.example.doordashlite.discover

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.example.doordashlite.data.Menu
import com.example.doordashlite.data.PopularItem
import com.example.doordashlite.data.Restaurant
import javax.inject.Inject

class DiscoverViewModel @Inject constructor() : ViewModel() {
    val restaurantMutableLiveData = MutableLiveData<ArrayList<Restaurant>>()

    init {
        loadRestaurants()
    }

    private fun loadRestaurants() {

        // TODO: restaurantsInteractor.getRestaurants().subscribe({}, {})

        val restaurants = arrayListOf<Restaurant>()
        restaurants.add(
            Restaurant(
                "A Good Morning Cafe",
                "American, Breakfast & Brunch",
                "Pre-order for Pre-order",
                2.00,
                listOf(
                    Menu(
                        listOf(PopularItem("https://res.cloudinary.com/doordash/image/fetch/c_fill,w_1200,h_672,q_auto:eco,f_auto/https://doordash-static.s3.amazonaws.com/media/photos/87b07dce-d492-4223-8847-1615744c8032-retina-large.jpg"))
                    )
                ))
        )
        restaurants.add(
            Restaurant(
                "A Good Morning Cafe",
                "American, Breakfast & Brunch",
                "41 mins",
                2.00,
                listOf(
                    Menu(
                        listOf(PopularItem("https://res.cloudinary.com/doordash/image/fetch/c_fill,w_1200,h_672,q_auto:eco,f_auto/https://doordash-static.s3.amazonaws.com/media/photos/87b07dce-d492-4223-8847-1615744c8032-retina-large.jpg"))
                    )
                ))
        )
        restaurants.add(
            Restaurant(
                "A Good Morning Cafe",
                "American, Breakfast & Brunch",
                "Pre-order for Pre-order",
                2.00,
                listOf(
                    Menu(
                        listOf(PopularItem("https://res.cloudinary.com/doordash/image/fetch/c_fill,w_1200,h_672,q_auto:eco,f_auto/https://doordash-static.s3.amazonaws.com/media/photos/87b07dce-d492-4223-8847-1615744c8032-retina-large.jpg"))
                    )
                ))
        )
        restaurants.add(
            Restaurant(
                "A Good Morning Cafe",
                "American, Breakfast & Brunch",
                "Pre-order for Pre-order",
                2.00,
                listOf(
                    Menu(
                        listOf(PopularItem("https://res.cloudinary.com/doordash/image/fetch/c_fill,w_1200,h_672,q_auto:eco,f_auto/https://doordash-static.s3.amazonaws.com/media/photos/87b07dce-d492-4223-8847-1615744c8032-retina-large.jpg"))
                    )
                ))
        )

        restaurantMutableLiveData.postValue(restaurants)
    }
}