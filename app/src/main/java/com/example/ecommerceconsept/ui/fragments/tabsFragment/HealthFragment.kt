package com.example.ecommerceconsept.ui.fragments.tabsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerceconsept.databinding.HealthFragmentBinding

class HealthFragment:Fragment() {

    private lateinit var binding: HealthFragmentBinding

    companion object{
        fun newInstance() = HealthFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HealthFragmentBinding.inflate(inflater,container,false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}