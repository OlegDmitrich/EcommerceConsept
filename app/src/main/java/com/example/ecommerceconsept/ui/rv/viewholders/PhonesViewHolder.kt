package com.example.ecommerceconsept.ui.rv.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.ecommerceconsept.domain.phonesEntites.HomeStore
import com.example.ecommerceconsept.databinding.ItemRvPhoneFragmentBinding
import com.example.ecommerceconsept.ui.rv.clicklistner.RvClickListener

class PhonesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val binding = ItemRvPhoneFragmentBinding.bind(itemView)
    fun bind(s: HomeStore, position: Int, clickListener: RvClickListener) {
        with(binding) {
            price.text = s.subtitle
            modelPhone.text = s.title
            imagePhoneCard.load(s.picture)
            rvItemPhones.setOnClickListener{clickListener.rvItemClick(s)}


        }
    }
}