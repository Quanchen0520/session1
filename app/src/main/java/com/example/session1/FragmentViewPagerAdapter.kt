package com.example.session1

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentViewPagerAdapter
    (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            FragmentA()
        } else if (position == 1) {
            FragmentB()
        } else {
            FragmentC()
        }
    }
    override fun getItemCount(): Int {
        return 3
    }
}