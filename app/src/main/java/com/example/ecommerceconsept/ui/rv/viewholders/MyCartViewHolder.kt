package com.example.ecommerceconsept.ui.rv.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ecommerceconsept.domain.mycartEntites.Basket
import com.example.ecommerceconsept.databinding.ItemRvMyCartBinding

class MyCartViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val binding = ItemRvMyCartBinding.bind(itemView)

    fun bind(listHotSale:Basket, position: Int) {
            with(binding){
                imagePhone.load(listHotSale.images)
                textModel.text = listHotSale.title
                textPrice.text = listHotSale.price.toString()
            }
    }


}