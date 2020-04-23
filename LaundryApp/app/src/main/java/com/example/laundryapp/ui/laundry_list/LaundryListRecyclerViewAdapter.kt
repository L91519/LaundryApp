package com.example.laundryapp.ui.laundry_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.laundryapp.R
import com.example.laundryapp.data.model.LaundryModel
import com.example.laundryapp.databinding.ItemLaundryBinding

class LaundryListRecyclerViewAdapter
    : RecyclerView.Adapter<LaundryListRecyclerViewAdapter.LaundryListViewHolder>() {
    private val items = mutableListOf<LaundryModel>()
    private lateinit var binding: ItemLaundryBinding

    inner class LaundryListViewHolder(private val binding: ItemLaundryBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(laundryItem: LaundryModel){
            binding.item = laundryItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaundryListViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_laundry,
            parent,
            false
        )
        return LaundryListViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: LaundryListViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(newItems: MutableList<LaundryModel>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

}