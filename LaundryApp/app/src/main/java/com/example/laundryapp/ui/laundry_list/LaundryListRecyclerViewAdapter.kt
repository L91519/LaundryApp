package com.example.laundryapp.ui.laundry_list

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.laundryapp.data.model.LaundryModel
import com.example.laundryapp.databinding.ActivityLaundryListBinding
import com.example.laundryapp.databinding.ItemLaundryBinding

class LaundryListRecyclerViewAdapter
    : RecyclerView.Adapter<LaundryListRecyclerViewAdapter.LaundryListViewHolder>() {

    inner class LaundryListViewHolder(private val binding: ItemLaundryBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(laundryItem: LaundryModel){
            binding.item = laundryItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaundryListViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: LaundryListViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    fun setItems(){

    }

}