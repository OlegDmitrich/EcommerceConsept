package com.example.ecommerceconsept.ui.fragments.screenFragments

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconsept.R
import com.example.ecommerceconsept.data.servdataphones.HomeStoreTwo
import com.example.ecommerceconsept.databinding.SelectCategoryFragmentBinding
import com.example.ecommerceconsept.ui.fragments.filterFragment.FilterFragment
import com.example.ecommerceconsept.ui.fragments.tabsFragment.*
import com.example.ecommerceconsept.ui.rvadapters.RvHotSaleAdapter
import com.example.ecommerceconsept.ui.vpadapters.VPAdapter
import com.example.ecommerceconsept.viewmodel.AppState
import com.example.ecommerceconsept.viewmodel.PhonesViewModel
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.math.roundToInt

class SelectCategoryFragment: Fragment() {

    private val fraglist = listOf(
        PhonesFragment.newInstance(),
        ComputerFragment.newInstance(),
        HealthFragment.newInstance(),
        BooksFragment.newInstance(),
        SomeFragment.newInstance()
    )
   // private lateinit var bottomSheetBehavior: BottomSheetBehavior<CardView>
    private lateinit var hotViewModel: PhonesViewModel
    private val rvAdapter = RvHotSaleAdapter()
    private lateinit var binding: SelectCategoryFragmentBinding

    private val texttitle = mutableMapOf(
        "telfone" to R.drawable.ic_baseline_phone_android_24,
        " comp " to R.drawable.ic_baseline_devices_24,
        " healf  " to R.drawable.ic_baseline_monitor_heart_24,
        "books " to R.drawable.ic_baseline_menu_book_24,
        " some " to R.drawable.ic_baseline_catching_pokemon_24
    )

    val testlistHot = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SelectCategoryFragmentBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hotViewModel = ViewModelProvider(this)[PhonesViewModel::class.java]
        hotViewModel.getDataHomeStore().observe(viewLifecycleOwner){state ->reneder(state)}

        initTabLayout()
        initRvAdapter()
       // testRv()
     //   addAdapter(testlistHot)


        binding.filterImageview.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.filter_container,FilterFragment())
                .addToBackStack(null)
                .commit()
        }
    }

    private fun reneder(state: AppState?) {
        when(state){
              is  AppState.IsSuccessTwo -> {
                    val listHotSAle: HomeStoreTwo = state.homeStoreTwo
                  rvAdapter.setDataHotPhone(listHotSAle)
                }
            else -> {}
        }
    }




    private fun initRvAdapter() {
        with(binding){
            rvHotSalesContainer.layoutManager = LinearLayoutManager(requireContext(),
                RecyclerView.HORIZONTAL,false)
            rvHotSalesContainer.adapter = rvAdapter

        }
    }

    private fun initTabLayout() {
        val arrtitle = ArrayList(texttitle.keys)
        val adapterVP = VPAdapter(this, fraglist)
        binding.phoneContainer.adapter = adapterVP
        TabLayoutMediator(binding.tab, binding.phoneContainer) { tab, pos ->
            tab.text = arrtitle[pos]
        }.attach()

        texttitle.values.forEachIndexed { index, imageResId ->
            val textview = LayoutInflater.from(requireContext()).inflate(R.layout.tab_title, null)
                    as TextView
            textview.setCompoundDrawablesWithIntrinsicBounds(0, imageResId, 0, 0)
            textview.compoundDrawablePadding = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 0.1F, resources.displayMetrics
            ).roundToInt()
            binding.tab.getTabAt(index)?.customView = textview
        }
    }
}


