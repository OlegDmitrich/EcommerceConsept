package com.example.ecommerceconsept.ui.fragments.filterFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerceconsept.databinding.FilterFargmentBinding

class FilterFragment:Fragment() {

    private lateinit var binding: FilterFargmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FilterFargmentBinding.inflate(inflater,container,false)
        return binding.root
    }
}