package com.coolcats.sherlockcoolcats.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MainViewPagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> AppFragment.getInstance(AppFragment.SherlockFragment.CLOSED_CASES)
            1 -> AppFragment.getInstance(AppFragment.SherlockFragment.OPEN_CASES)
            else -> AppFragment.getInstance(AppFragment.SherlockFragment.CASE_LOCATIONS)
        }
    }
}