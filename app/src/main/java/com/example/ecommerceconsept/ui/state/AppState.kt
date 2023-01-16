package com.example.ecommerceconsept.ui.state

import com.example.ecommerceconsept.domain.detailEntites.DataDetails
import com.example.ecommerceconsept.domain.mycartEntites.MyCart
import com.example.ecommerceconsept.domain.phonesEntites.HomeStoreTwo

sealed class AppState {
    data class IsSuccessTwo(val homeStoreTwo: HomeStoreTwo): AppState()
    data class IsSuccessDetails(val details: DataDetails): AppState()
    data class IsSuccessMyCart(val cart: MyCart): AppState()
    data class Error(val error: Throwable): AppState()
    data class Loading(val loading: Int): AppState()
}