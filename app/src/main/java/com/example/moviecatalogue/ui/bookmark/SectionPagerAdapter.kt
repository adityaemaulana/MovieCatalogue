package com.example.moviecatalogue.ui.bookmark

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.moviecatalogue.R
import com.example.moviecatalogue.ui.bookmarkmovie.BookmarkMovieFragment
import com.example.moviecatalogue.ui.bookmarktvshow.BookmarkTvshowFragment

class SectionPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.bookmarktv)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> BookmarkMovieFragment()
            1 -> BookmarkTvshowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? =
        context.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2
}