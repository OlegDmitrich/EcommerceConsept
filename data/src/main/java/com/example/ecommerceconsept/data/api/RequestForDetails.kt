package com.example.ecommerceconsept.data.api

import com.example.ecommerceconsept.domain.detailEntites.DataDetails
import retrofit2.Call
import retrofit2.http.GET

interface RequestForDetails {
    @GET("https://run.mocky.io/v3/6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    fun getRetrofitDetails(): Call<DataDetails>
}