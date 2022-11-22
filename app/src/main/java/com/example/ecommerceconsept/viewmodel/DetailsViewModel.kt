package com.example.ecommerceconsept.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceconsept.data.detailsdata.DataDetails
import com.example.ecommerceconsept.data.retrofit.RetrofitImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsViewModel(
    private val liveDataToObserver: MutableLiveData<AppState> = MutableLiveData(),
    private val retrofitImpl: RetrofitImpl = RetrofitImpl()
):ViewModel() {

    fun getDataDetails():MutableLiveData<AppState>{
        senRequest()
        return liveDataToObserver
    }

    private fun senRequest() {
        retrofitImpl.getRetrofitDetailsImpl().getRetrofitDetails().enqueue(object : Callback<DataDetails>{
            override fun onResponse(call: Call<DataDetails>, response: Response<DataDetails>) {
                if (response.isSuccessful && response.body() != null){
                    liveDataToObserver.value = AppState.IsSuccessDetails(response.body()!!)
                }else{
                    val  message = response.message()
                    if (message.isNullOrEmpty()){
                        liveDataToObserver.value = AppState.Error(Throwable("undefield error"))
                    }else{
                        liveDataToObserver.value = AppState.Error(Throwable(message))
                    }
                }
            }

            override fun onFailure(call: Call<DataDetails>, t: Throwable) {
                liveDataToObserver.value = AppState.Error(t)
            }
        })
    }


}