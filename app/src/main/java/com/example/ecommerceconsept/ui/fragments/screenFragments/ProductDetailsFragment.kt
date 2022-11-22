package com.example.ecommerceconsept.ui.fragments.screenFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.example.ecommerceconsept.R
import com.example.ecommerceconsept.databinding.ProductDetailsFragmentBinding
import com.example.ecommerceconsept.ui.fragments.tabsFragment.*
import com.example.ecommerceconsept.ui.vpadapters.VPAdapter
import com.example.ecommerceconsept.ui.vpadapters.VPAdapterDetails
import com.example.ecommerceconsept.viewmodel.AppState
import com.example.ecommerceconsept.viewmodel.DetailsViewModel
import com.google.android.material.tabs.TabLayoutMediator
import java.io.DataInput

class ProductDetailsFragment:Fragment(){
    private lateinit var binding: ProductDetailsFragmentBinding
    private lateinit var viewModelDetails: DetailsViewModel

    private val fraglist = listOf(

        HealthFragment.newInstance(),
        BooksFragment.newInstance(),
        SomeFragment.newInstance()
    )

    private val listTabDetails = listOf(
        "Shop",
        "Details",
        "Features"
    )

    companion object{
        fun newInstance() = ProductDetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProductDetailsFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelDetails = ViewModelProvider(this)[DetailsViewModel::class.java]
        viewModelDetails.getDataDetails().observe(viewLifecycleOwner){state -> renderDetails(state)}
        tabs()

        binding.buttonBuy.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.main_container,MyCartFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun renderDetails(state: AppState?) {

        when(state){
            is AppState.IsSuccessDetails ->{

                with(binding){
                    imageViewPhone.load(state.details.images[1])
                    textTitle.text = state.details.title
                }
            }else ->{}
        }
    }

    private fun tabs() {
        val adapterVP = VPAdapterDetails(this, fraglist)
        binding.detailsPhoneContainer.adapter = adapterVP
        TabLayoutMediator(binding.tabDetails, binding.detailsPhoneContainer) { tab, pos ->
            tab.text = listTabDetails[pos]

        }.attach()
    }

}