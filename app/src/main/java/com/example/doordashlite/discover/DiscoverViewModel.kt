package com.example.doordashlite.discover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel;
import com.example.doordashlite.domain.RestaurantInteractor
import com.example.doordashlite.domain.entity.Restaurant
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.internal.disposables.DisposableContainer

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DiscoverViewModel @Inject constructor(private val restaurantInteractor: RestaurantInteractor) : ViewModel() {
    val restaurantMutableLiveData = MutableLiveData<ArrayList<Restaurant>>()
    private val compositeDisposableContainer = CompositeDisposable()

    init {
        loadRestaurants()
    }

    private fun loadRestaurants() {
        compositeDisposableContainer.add(restaurantInteractor.getRestaurants("37.422740"," -122.139956")
            .subscribeOn(Schedulers.io())
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