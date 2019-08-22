package com.example.doordashlite.discover

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.example.doordashlite.domain.RestaurantInteractor
import com.example.doordashlite.domain.entity.Restaurant

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DiscoverViewModel @Inject constructor(private val restaurantInteractor: RestaurantInteractor) : ViewModel() {
    val restaurantMutableLiveData = MutableLiveData<ArrayList<Restaurant>>()

    init {
        loadRestaurants()
    }

    private fun loadRestaurants() {
        restaurantInteractor.getRestaurants()
            .subscribeOn(Schedulers.io())
            .subscribe({
                restaurantMutableLiveData.postValue(ArrayList(it))
            }, {
                println(it)
            })
    }
}