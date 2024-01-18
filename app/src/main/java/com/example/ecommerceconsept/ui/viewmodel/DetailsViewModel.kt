package com.example.ecommerceconsept.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerceconsept.data.retrofit.RetrofitImpl
import com.example.ecommerceconsept.domain.detailEntites.DataDetails
import com.example.ecommerceconsept.domain.detailEntites.Details
import com.example.ecommerceconsept.ui.state.AppState
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailsViewModel(
    private val liveDataToObserver: MutableLiveData<AppState> = MutableLiveData(),
    private val retrofitImpl: RetrofitImpl = RetrofitImpl(),

   // private val liveDataToObserverRx: MutableLiveData<DataDetails> = MutableLiveData(),
  //  private val rxDetails: Details,
   // private val compositeDisposable: CompositeDisposable = CompositeDisposable()
):ViewModel() {

    fun getDataDetails():MutableLiveData<AppState>{
        senRequest()
        return liveDataToObserver
    }

//    fun getDataDetailsRx():MutableLiveData<DataDetails>{
//        senRequestRx()
//        return liveDataToObserverRx
//    }
//
//    private fun senRequestRx() {
//        compositeDisposable.add(
//            rxDetails.getDetails().subscribeBy {
//                liveDataToObserverRx.postValue(it)
//            }
//        )
//
//    }

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