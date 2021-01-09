package com.example.moviecatalogue.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.moviecatalogue.databinding.FragmentBookmarkBinding

class BookmarkFragment : Fragment() {
    private lateinit var fragmentBookmarkBinding: FragmentBookmarkBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentBookmarkBinding = FragmentBookmarkBinding.inflate(layoutInflater, container, false)
        return fragmentBookmarkBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sectionPagerAdapter = SectionPagerAdapter(requireContext(), childFragmentManager)
        fragmentBookmarkBinding.viewPager.adapter = sectionPagerAdapter
        fragmentBookmarkBinding.tabs.setupWithViewPager(fragmentBookmarkBinding.viewPager)
    }
}