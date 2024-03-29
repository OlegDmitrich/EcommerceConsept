package com.example.ecommerceconsept.data.api

import com.example.ecommerceconsept.domain.phonesEntites.HomeStoreTwo
import retrofit2.Call
import retrofit2.http.GET

interface RequestForPhoneData {
    @GET("https://run.mocky.io/v3/654bd15e-b121-49ba-a588-960956b15175")
    fun getHomeStore(): Call<HomeStoreTwo>
}