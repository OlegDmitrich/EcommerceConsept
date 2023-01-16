package com.example.ecommerceconsept.ui.rv.rvadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerceconsept.R
import com.example.ecommerceconsept.domain.phonesEntites.HomeStore
import com.example.ecommerceconsept.ui.rv.clicklistner.RvClickListener
import com.example.ecommerceconsept.ui.rv.viewholders.PhonesViewHolder

class RvBestPhonesAdapter(private val clickListener: RvClickListener):RecyclerView.Adapter<PhonesViewHolder>() {

    private var dataPhone: List<HomeStore> = emptyList()
   // private var someData: HomeStor = HomeStor()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhonesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_phone_fragment,parent,false)
        return PhonesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhonesViewHolder, position: Int) {
        holder.bind(dataPhone[position],position,clickListener)
    }

    override fun getItemCount(): Int {
        return dataPhone.size
    }

    fun setDataHotPhone(listHomeStore: List<HomeStore>) {
        dataPhone = listHomeStore
        notifyDataSetChanged()
    }

//    fun setSomeData(list: HomeStor) {
//
//        notifyDataSetChanged()
//    }
}