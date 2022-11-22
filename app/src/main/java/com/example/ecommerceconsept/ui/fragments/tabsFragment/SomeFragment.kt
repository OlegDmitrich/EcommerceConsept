package com.example.ecommerceconsept.ui.fragments.tabsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerceconsept.databinding.SomeFragmentBinding

class SomeFragment:Fragment() {

    private lateinit var binding: SomeFragmentBinding

    companion object{
        fun newInstance() = SomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SomeFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

}