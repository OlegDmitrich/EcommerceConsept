package com.example.ecommerceconsept.data.mycartdata

data class MyCart(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)