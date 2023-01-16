package com.example.ecommerceconsept.di


import com.example.ecommerceconsept.ui.viewmodel.DetailsViewModel
import com.example.ecommerceconsept.ui.viewmodel.MyCartViewModel
import com.example.ecommerceconsept.ui.viewmodel.PhonesViewModel
import com.example.ecommerceconsept.ui.viewmodel.SelectCategoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val myAppModules = module {

    viewModel<DetailsViewModel>{
        DetailsViewModel()
    }
    viewModel<MyCartViewModel> {
        MyCartViewModel()
    }
    viewModel<PhonesViewModel> {
        PhonesViewModel()
    }
//    viewModel<SelectCategoryViewModel>{
//        SelectCategoryViewModel()
//    }




}