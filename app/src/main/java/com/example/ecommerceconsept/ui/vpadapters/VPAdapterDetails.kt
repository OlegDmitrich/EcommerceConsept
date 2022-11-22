package com.example.ecommerceconsept.ui.vpadapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.ecommerceconsept.ui.fragments.screenFragments.ProductDetailsFragment
import com.example.ecommerceconsept.ui.fragments.screenFragments.SelectCategoryFragment

class VPAdapterDetails(fa: ProductDetailsFragment, private val list: List<Fragment>): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return list.size
    }

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}