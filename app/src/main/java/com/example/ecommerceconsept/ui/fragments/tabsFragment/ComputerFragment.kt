package com.example.ecommerceconsept.ui.fragments.tabsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ecommerceconsept.databinding.ComputerFragmentBinding

class ComputerFragment:Fragment() {

    private lateinit var binding: ComputerFragmentBinding

    companion object{
        fun newInstance() = ComputerFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ComputerFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }
}