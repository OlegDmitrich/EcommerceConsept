package com.example.ecommerceconsept.domain.mycartEntites

data class MyCart(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)