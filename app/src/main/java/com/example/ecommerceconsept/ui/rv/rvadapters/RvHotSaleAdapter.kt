package com.example.ecommerceconsept.ui.rv.rvadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconsept.R
import com.example.ecommerceconsept.domain.phonesEntites.HomeStore
import com.example.ecommerceconsept.domain.phonesEntites.HomeStoreTwo
import com.example.ecommerceconsept.ui.rv.viewholders.HotSaleViewHolder

class RvHotSaleAdapter(): RecyclerView.Adapter<HotSaleViewHolder>() {

    private var listHotSale: List<HomeStore> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSaleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_hot_sales,parent,false)
        return HotSaleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HotSaleViewHolder, position: Int) {
        holder.bind(listHotSale[position],position)
    }

    override fun getItemCount(): Int {
        return listHotSale.size
    }

    fun setDataHotPhone(testlistHotes: HomeStoreTwo) {
        listHotSale =  testlistHotes.home_store
        notifyDataSetChanged()
    }
}