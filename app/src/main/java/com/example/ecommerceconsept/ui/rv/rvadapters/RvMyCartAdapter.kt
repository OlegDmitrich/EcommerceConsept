package com.example.ecommerceconsept.ui.rv.rvadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconsept.R
import com.example.ecommerceconsept.domain.mycartEntites.Basket
import com.example.ecommerceconsept.domain.mycartEntites.MyCart
import com.example.ecommerceconsept.ui.rv.viewholders.MyCartViewHolder

class RvMyCartAdapter: RecyclerView.Adapter<MyCartViewHolder>() {

    private var listHotSale: List<Basket> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCartViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_my_cart,parent,false)
        return MyCartViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyCartViewHolder, position: Int) {
        holder.bind(listHotSale[position],position)
    }

    override fun getItemCount(): Int {
        return listHotSale.size
    }

    fun setMyCart(cartList: MyCart) {
        listHotSale = cartList.basket
        notifyDataSetChanged()
    }
}