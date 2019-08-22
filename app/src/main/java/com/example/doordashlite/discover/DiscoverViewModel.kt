package com.example.doordashlite.discover

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.doordashlite.domain.RestaurantInteractor
import com.example.doordashlite.domain.entity.Restaurant
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DiscoverViewModel @Inject constructor(
    private val scheduler: Scheduler,
    private val restaurantInteractor: RestaurantInteractor) : ViewModel() {
    val restaurantMutableLiveData = MutableLiveData<ArrayList<Restaurant>>()
    private val compositeDisposableContainer = CompositeDisposable()

    init {
        loadRestaurants()
    }

    private fun loadRestaurants() {
        compositeDisposableContainer.add(restaurantInteractor.getRestaurants("37.422740","-122.139956")
            .subscribeOn(scheduler)
            .subscribe({
                restaurantMutableLiveData.postValue(ArrayList(it))
            }, {
                // TODO: handle error
            })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposableContainer.clear()
    }
}