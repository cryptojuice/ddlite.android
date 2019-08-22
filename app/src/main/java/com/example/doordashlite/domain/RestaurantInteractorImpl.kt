package com.example.doordashlite.domain

import com.example.doordashlite.domain.entity.Menu
import com.example.doordashlite.domain.entity.PopularItem
import com.example.doordashlite.domain.entity.Restaurant
import com.example.doordashlite.network.DoorDashAPIRepository
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RestaurantInteractorImpl @Inject constructor(private val doorDashAPIRepository: DoorDashAPIRepository) : RestaurantInteractor {

    override fun getRestaurants(): Observable<List<Restaurant>> {
        return doorDashAPIRepository.fetchRestaurants("37.422740", " -122.139956", "0", "100")
            .observeOn(Schedulers.io())
//        val restaurants = arrayListOf<Restaurant>()
//        restaurants.add(
//            Restaurant(
//                "A Good Morning Cafe",
//                "American, Breakfast & Brunch",
//                "Pre-order for Pre-order",
//                2.00,
//                listOf(
//                    Menu(
//                        listOf(PopularItem("https://res.cloudinary.com/doordash/image/fetch/c_fill,w_1200,h_672,q_auto:eco,f_auto/https://doordash-static.s3.amazonaws.com/media/photos/87b07dce-d492-4223-8847-1615744c8032-retina-large.jpg"))
//                    )
//                )
//            )
//        )
//        restaurants.add(
//            Restaurant(
//                "A Good Morning Cafe",
//                "American, Breakfast & Brunch",
//                "41 mins",
//                2.00,
//                listOf(
//                    Menu(
//                        listOf(PopularItem("https://res.cloudinary.com/doordash/image/fetch/c_fill,w_1200,h_672,q_auto:eco,f_auto/https://doordash-static.s3.amazonaws.com/media/photos/87b07dce-d492-4223-8847-1615744c8032-retina-large.jpg"))
//                    )
//                )
//            )
//        )
//        restaurants.add(
//            Restaurant(
//                "A Good Morning Cafe",
//                "American, Breakfast & Brunch",
//                "Pre-order for Pre-order",
//                2.00,
//                listOf(
//                    Menu(
//                        listOf(PopularItem("https://res.cloudinary.com/doordash/image/fetch/c_fill,w_1200,h_672,q_auto:eco,f_auto/https://doordash-static.s3.amazonaws.com/media/photos/87b07dce-d492-4223-8847-1615744c8032-retina-large.jpg"))
//                    )
//                )
//            )
//        )
//        restaurants.add(
//            Restaurant(
//                "A Good Morning Cafe",
//                "American, Breakfast & Brunch",
//                "Pre-order for Pre-order",
//                2.00,
//                listOf(
//                    Menu(
//                        listOf(PopularItem("https://res.cloudinary.com/doordash/image/fetch/c_fill,w_1200,h_672,q_auto:eco,f_auto/https://doordash-static.s3.amazonaws.com/media/photos/87b07dce-d492-4223-8847-1615744c8032-retina-large.jpg"))
//                    )
//                )
//            )
//        )
//
//        return Observable.just(restaurants.toList())
    }
}