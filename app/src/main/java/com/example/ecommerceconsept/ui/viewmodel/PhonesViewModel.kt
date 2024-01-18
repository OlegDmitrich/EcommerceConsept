package com.example.ecommerceconsept.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceconsept.domain.phonesEntites.HomeStoreTwo
import com.example.ecommerceconsept.data.retrofit.RetrofitImpl
import com.example.ecommerceconsept.ui.state.AppState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PhonesViewModel(
    private val liveDataToObserver: MutableLiveData<AppState> = MutableLiveData(),
    private val retrofitImpl: RetrofitImpl = RetrofitImpl()
):ViewModel() {

    fun getDataHomeStore():MutableLiveData<AppState>{
        sendRequest()
        return liveDataToObserver
    }

    private fun sendRequest() {
        retrofitImpl.getRetrofitImpl().getHomeStore().enqueue(object : Callback<HomeStoreTwo>{
            override fun onResponse(call: Call<HomeStoreTwo>, response: Response<HomeStoreTwo>) {
                if (response.isSuccessful && response.body() != null){
                    liveDataToObserver.value = AppState.IsSuccessTwo(response.body()!!)
                }else{
                    val  message = response.message()
                    if (message.isNullOrEmpty()){
                        liveDataToObserver.value = AppState.Error(Throwable("undefield error"))
                    }else{
                        liveDataToObserver.value = AppState.Error(Throwable(message))
                    }
                }
            }

            override fun onFailure(call: Call<HomeStoreTwo>, t: Throwable) {
                liveDataToObserver.value = AppState.Error(t)
            }
        })
    }
}