package com.example.threetabapp.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.example.threetabapp.android.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    private fun configTabLayout() {
        val adapter = ViewPagerAdapter(this)
        binding.viewPager.setAdapter(adapter)

        adapter.addFragment(OneFragment(),"Tab1")
        adapter.addFragment(TwoFragment(),"Tab2")

        binding.viewPager.setOffscreenPageLimit(adapter.itemCount)

        val mediator = TabLayoutMediator(
            binding.tabs, binding.viewPager
        ){tab:TabLayout.Tab, position:Int->tab.text=adapter.getTitle(position)}
        mediator.attach()
    }

}

