package com.example.ecommerceconsept.ui.fragments.tabsFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.ecommerceconsept.R
import com.example.ecommerceconsept.domain.phonesEntites.HomeStore
import com.example.ecommerceconsept.domain.phonesEntites.HomeStoreTwo
import com.example.ecommerceconsept.databinding.PhoneTabFragmentBinding
import com.example.ecommerceconsept.ui.fragments.screenFragments.ProductDetailsFragment
import com.example.ecommerceconsept.ui.rv.rvadapters.RvBestPhonesAdapter
import com.example.ecommerceconsept.ui.rv.clicklistner.RvClickListener
import com.example.ecommerceconsept.ui.state.AppState
import com.example.ecommerceconsept.ui.viewmodel.PhonesViewModel

class PhonesFragment:Fragment(), RvClickListener {

    private lateinit var binding: PhoneTabFragmentBinding
    private lateinit var phonesViewModel: PhonesViewModel
    private val beastPhonesAdapter = RvBestPhonesAdapter(this)

    val testlistPhones = mutableListOf<String>()
    companion object{
        fun newInstance() = PhonesFragment()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PhoneTabFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        viewModel = ViewModelProvider(this)[FoodViewModel::class.java]
//        viewModel.captureBurger().observe(viewLifecycleOwner){state -> render(state)}

        phonesViewModel = ViewModelProvider(this)[PhonesViewModel::class.java]
        phonesViewModel.getDataHomeStore().observe(viewLifecycleOwner){state -> render(state)}
        initRvAdapter()
       // testRv()
       // addAdapter(testlistPhones)
    }

    private fun render(state: AppState?) {
        when(state){
            is AppState.IsSuccessTwo ->{
//                val list: HomeStor = state.homeStoreTwo
//                beastPhonesAdapter.setSomeData(list)

                val listHomeStore: HomeStoreTwo = state.homeStoreTwo
                val hmstr : List<HomeStore> = state.homeStoreTwo.home_store
                beastPhonesAdapter.setDataHotPhone(hmstr)
            }else -> {}
        }
    }

//    private fun addAdapter(testlistPhone: List<String>) {
//     beastPhonesAdapter.setDataHotPhone(testlistPhone)
//    }

//    private fun testRv() {
//
//        for (i in 1..50){
//            testlistPhones.add("cake$i")
//        }
//    }

    private fun initRvAdapter() {
        with(binding){
           // rvPhoneSalesContainer.layoutManager = LinearLayoutManager(activity)
           rvPhoneSalesContainer.layoutManager = GridLayoutManager(activity,2)
            rvPhoneSalesContainer.adapter = beastPhonesAdapter

        }
    }

    override fun rvItemClick(position: HomeStore) {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.main_container,ProductDetailsFragment())
            .addToBackStack(null)
            .commit()
    }
}