package com.atakanmadanoglu.nasa_rover_vehicles.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.atakanmadanoglu.nasa_rover_vehicles.R
import com.atakanmadanoglu.nasa_rover_vehicles.databinding.ActivityMainBinding
import com.atakanmadanoglu.nasa_rover_vehicles.view.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        val names = resources.getStringArray(R.array.tabNames)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = names[position]
        }.attach()
    }
}