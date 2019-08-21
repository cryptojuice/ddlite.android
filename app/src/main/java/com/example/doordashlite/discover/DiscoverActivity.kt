package com.example.doordashlite.discover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.doordashlite.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class DiscoverActivity : AppCompatActivity() {

    @Inject
    lateinit var discoverFragment: DiscoverFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_discover)


        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fragment_container, discoverFragment)
        ft.commit()
    }
}
