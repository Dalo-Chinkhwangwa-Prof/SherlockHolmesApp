package com.coolcats.sherlockcoolcats.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager.widget.ViewPager
import com.coolcats.sherlockcoolcats.R
import com.coolcats.sherlockcoolcats.view.AppFragment.SherlockFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: MainViewPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainViewPagerAdapter(supportFragmentManager)
        main_viewpager.adapter = adapter

        main_viewpager.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                //Do nothing...
            }

            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> bottom_nav.selectedItemId = R.id.solved_cases_item
                    1 -> bottom_nav.selectedItemId = R.id.open_cases_item
                    else -> bottom_nav.selectedItemId = R.id.case_locations_item
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                //Do nothing
            }

        })

        bottom_nav.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.solved_cases_item -> openFragment(0)
                R.id.open_cases_item -> openFragment(1)
                else -> openFragment(2)
            }
            true
        }
    }

    private fun openFragment(frag: Int) {
        main_viewpager.setCurrentItem(frag, true)
    }
}