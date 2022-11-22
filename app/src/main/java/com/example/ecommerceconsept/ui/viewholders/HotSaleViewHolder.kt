package com.example.ecommerceconsept.ui.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ecommerceconsept.data.servdataphones.HomeStore
import com.example.ecommerceconsept.databinding.ItemRvHotSalesBinding

class HotSaleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemRvHotSalesBinding.bind(itemView)
    fun bind(s: HomeStore, position: Int) {
            with(binding){
                someText.text = s.subtitle
                namePhone.text = s.title
                imagePhone.load(s.picture)
            }
    }
}