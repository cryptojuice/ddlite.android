package com.example.doordashlite.discover

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.doordashlite.R
import com.example.doordashlite.data.Menu
import com.example.doordashlite.data.PopularItem
import com.example.doordashlite.data.Restaurant
import com.example.doordashlite.databinding.DiscoverFragmentBinding
import com.example.doordashlite.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DiscoverFragment @Inject constructor(): Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[DiscoverViewModel::class.java]
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DiscoverFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.discover_fragment, container, false)

        binding.restaurantsRecyclerView.also {
            it.layoutManager = LinearLayoutManager(this.context)
            it.adapter = RestaurantsAdapter(arrayListOf())
            it.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        }

        viewModel.restaurantMutableLiveData.observe(this, Observer {
            (binding.restaurantsRecyclerView.adapter as RestaurantsAdapter).update(it)
        })

        return binding.root
    }

}
