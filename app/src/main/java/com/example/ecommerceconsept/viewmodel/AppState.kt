package com.example.ecommerceconsept.viewmodel

import com.example.ecommerceconsept.data.detailsdata.DataDetails
import com.example.ecommerceconsept.data.mycartdata.Basket
import com.example.ecommerceconsept.data.mycartdata.MyCart
import com.example.ecommerceconsept.data.servdataphones.HomeStoreTwo
import com.example.ecommerceconsept.data.servdataphones.HomeStores

sealed class AppState {
    data class IsSuccessTwo(val homeStoreTwo: HomeStoreTwo):AppState()
    data class IsSuccessDetails(val details: DataDetails):AppState()
    data class IsSuccessMyCart(val cart: MyCart):AppState()
    data class Error(val error: Throwable):AppState()
    data class Loading(val loading: Int):AppState()
}