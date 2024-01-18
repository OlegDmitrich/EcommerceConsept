package com.example.ecommerceconsept.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceconsept.domain.mycartEntites.MyCart
import com.example.ecommerceconsept.data.retrofit.RetrofitImpl
import com.example.ecommerceconsept.ui.state.AppState
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyCartViewModel(
    private val liveDataToObserver: MutableLiveData<AppState> = MutableLiveData(),
    private val retrofitImpl: RetrofitImpl = RetrofitImpl(),


):ViewModel() {





    fun getDataMyCart(): MutableLiveData<AppState>{
        sendRequestMyCart()
        return liveDataToObserver
    }

    private fun sendRequestMyCart() {
        retrofitImpl.getRetrofitMyCart().getMyCart().enqueue(object : Callback<MyCart>{
            override fun onResponse(call: Call<MyCart>, response: Response<MyCart>) {
                if (response.isSuccessful && response.body() != null){
                    liveDataToObserver.value = AppState.IsSuccessMyCart(response.body()!!)
                }else{
                    val  message = response.message()
                    if (message.isNullOrEmpty()){
                        liveDataToObserver.value = AppState.Error(Throwable("undefield error"))
                    }else{
                        liveDataToObserver.value = AppState.Error(Throwable(message))
                    }
                }
            }

            override fun onFailure(call: Call<MyCart>, t: Throwable) {
                liveDataToObserver.value = AppState.Error(t)
            }
        })
    }
}