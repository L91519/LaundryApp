package com.example.laundryapp.ui.laundry_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.laundryapp.R
import com.example.laundryapp.data.model.LaundryModel
import com.example.laundryapp.databinding.ItemLaundryBinding
import kotlinx.android.synthetic.main.item_order.view.*

class LaundryListRecyclerViewAdapter
    : RecyclerView.Adapter<LaundryListRecyclerViewAdapter.LaundryListViewHolder>() {
    private var items = mutableListOf<LaundryModel>()
    private lateinit var binding: ItemLaundryBinding
    private var showAllLaundry = false

    inner class LaundryListViewHolder(private val binding: ItemLaundryBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(laundryItem: LaundryModel){
            binding.item = laundryItem
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position != OWNER_VISIBLE) {
            if (items[position - 1].owner != items[position].owner) {
                OWNER_VISIBLE
            } else
                OWNER_GONE
        } else
            OWNER_VISIBLE
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

    override fun getItemCount(): Int {

        return if(showAllLaundry) items.size
        else items.size
    }

    override fun onBindViewHolder(holder: LaundryListViewHolder, position: Int) {
        if (holder.itemViewType == OWNER_VISIBLE)
            holder.itemView.rl_customer_info.visibility = View.VISIBLE
        else if (holder.itemViewType == OWNER_GONE)
            holder.itemView.rl_customer_info.visibility = View.GONE

        holder.bind(items[position])
    }

    fun setItems(newItems: MutableList<LaundryModel>, showAll: Boolean){
        items.clear()
        if (showAll)
            items.addAll(newItems)
        else
            items.addAll(newItems.filter { !it.isDone })
        notifyDataSetChanged()
    }

    companion object {
        const val OWNER_VISIBLE: Int = 0
        const val OWNER_GONE: Int = 1
    }

}