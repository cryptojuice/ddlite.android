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
import com.example.doordashlite.databinding.DiscoverFragmentBinding
import com.example.doordashlite.di.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class DiscoverFragment @Inject constructor(): Fragment() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[DiscoverViewModel::class.java]
    }

    private lateinit var binding: DiscoverFragmentBinding

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.discover_fragment, container, false)

        binding.restaurantsRecyclerView.also {
            it.layoutManager = LinearLayoutManager(this.context)
            it.adapter = RestaurantsAdapter(arrayListOf(), viewModel)
            it.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.restaurantMutableLiveData.observe(this, Observer {
            (binding.restaurantsRecyclerView.adapter as RestaurantsAdapter).update(it)
        })
    }
}
