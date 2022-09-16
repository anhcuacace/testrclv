package com.codefresher.gapotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.codefresher.gapotest.databinding.ActivityMainBinding
import com.codefresher.gapotest.viewpager2.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        window.statusBarColor = this.getColor(R.color.white)
        setUpTabBar()
    }
    private fun setUpTabBar()
    {
        val adapter = ViewPagerAdapter(this, mainBinding.tabLayout.tabCount)
        mainBinding.viewPager.adapter = adapter

        mainBinding.viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback()
        {
            override fun onPageSelected(position: Int) {
                mainBinding.tabLayout.selectTab(mainBinding.tabLayout.getTabAt(position))
            }
        })

        mainBinding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener
        {
            override fun onTabSelected(tab: TabLayout.Tab)
            {
                mainBinding.viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}