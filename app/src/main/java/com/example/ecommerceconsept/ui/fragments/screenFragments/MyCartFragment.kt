package com.example.ecommerceconsept.ui.fragments.screenFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ecommerceconsept.databinding.MycartFragmentBinding
import com.example.ecommerceconsept.ui.rvadapters.RvMyCartAdapter
import com.example.ecommerceconsept.viewmodel.AppState
import com.example.ecommerceconsept.viewmodel.MyCartViewModel

class MyCartFragment:Fragment() {
    private lateinit var binding: MycartFragmentBinding
    private lateinit var myCartViewModel: MyCartViewModel
    private val myCartAdapter = RvMyCartAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MycartFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myCartViewModel = ViewModelProvider(this)[MyCartViewModel::class.java]
        myCartViewModel.getDataMyCart().observe(viewLifecycleOwner){state -> render(state)}
        initAdapter()
    }

    private fun render(state: AppState?) {
        when(state){
            is AppState.IsSuccessMyCart ->{
                val cartList = state.cart
                with(binding){
                    linearTextMoney.text = cartList.total.toString()
                    linearTextFree.text = cartList.delivery
                }
                myCartAdapter.setMyCart(cartList)
            } else ->{}
        }

    }

    private fun initAdapter() {
        with(binding){
            rvMyCart.layoutManager = LinearLayoutManager(requireContext())
            rvMyCart.adapter = myCartAdapter
        }
    }
}

