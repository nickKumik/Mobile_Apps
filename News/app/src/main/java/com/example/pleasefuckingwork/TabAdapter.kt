package com.example.pleasefuckingwork

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NewsListFrag()
            1 -> RecFrag()
            2 -> LatestFrag()
            else -> NewsListFrag()
        }
    }

}