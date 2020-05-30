package com.example.laundryapp.ui.laundry_add_dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.laundryapp.R
import com.example.laundryapp.data.model.OrderModel
import com.example.laundryapp.databinding.ItemOrderBinding

class LaundryAddRecyclerViewAdapter
    : RecyclerView.Adapter<LaundryAddRecyclerViewAdapter.LaundryAddViewHolder>() {

    private var items = mutableListOf<OrderModel>()
    private lateinit var binding: ItemOrderBinding

    class LaundryAddViewHolder constructor(private val binding: ItemOrderBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(orderItem: OrderModel) {
            binding.item = orderItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaundryAddViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_order,
            parent,
            false
        )
        return LaundryAddViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: LaundryAddViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(newItems: MutableList<OrderModel>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}