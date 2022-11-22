package com.example.ecommerceconsept.data.retrofit

import com.example.ecommerceconsept.data.mycartdata.MyCart
import retrofit2.Call
import retrofit2.http.GET

interface RequestForMyCart {
    @GET("https://run.mocky.io/v3/53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    fun getMyCart():Call<MyCart>
}