package com.example.soccereleven.favorite.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.soccereleven.favorite.MatchFavFragment

class FavoritePagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager){
    override fun getItem(p0: Int): Fragment {
        return when (p0){
            0 -> {
                MatchFavFragment()
            }
            else -> {
                return MatchFavFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Match Favorites"
            else ->""
        }
    }
}