package com.danielg07.newsapp.tablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.danielg07.newsapp.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)

class MainFragment : Fragment() {

    private lateinit var adapter: MainAdapter
    private lateinit var viewPager: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = MainAdapter(this)
        viewPager = view.findViewById(R.id.pager)
        viewPager.adapter = adapter

        val tabLayout: TabLayout = view.findViewById(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = context?.resources?.getString(TAB_TITLES[position]) ?: ""
        }.attach()

    }

}