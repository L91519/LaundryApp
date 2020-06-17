package com.example.laundryapp.ui.laundry_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.laundryapp.R
import com.example.laundryapp.data.model.LaundryModel
import com.example.laundryapp.databinding.ItemLaundryBinding
import kotlinx.android.synthetic.main.item_laundry.view.*

class LaundryListRecyclerViewAdapter(vm: LaundryListViewModel)
    : RecyclerView.Adapter<LaundryListRecyclerViewAdapter.LaundryListViewHolder>() {

    private var items = mutableListOf<LaundryModel>()
    private var unfilteredItems = mutableListOf<LaundryModel>()
    private val vm = vm
    private lateinit var binding: ItemLaundryBinding

    inner class LaundryListViewHolder(private val binding: ItemLaundryBinding)
        : RecyclerView.ViewHolder(binding.root){

        fun bind(laundryItem: LaundryModel){
            binding.item = laundryItem
            binding.vm = vm
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

        return items.size
    }

    override fun onBindViewHolder(holder: LaundryListViewHolder, position: Int) {
        if (holder.itemViewType == OWNER_VISIBLE)
            holder.itemView.rl_customer_info.visibility = View.VISIBLE
        else if (holder.itemViewType == OWNER_GONE)
            holder.itemView.rl_customer_info.visibility = View.GONE

        holder.bind(items[position])
    }

    fun isDoneFilter(isDone: Boolean) {
        items.clear()
        if (!isDone) {
            for (item in unfilteredItems) {
                if (item.done == false)
                    items.add(item)
            }
        } else {
            items.addAll(unfilteredItems)
        }
        notifyDataSetChanged()
    }

    fun filter(filter: Int, query: String) {
        items.clear()
        if (!query.isNullOrEmpty()) {
            when (filter) {
                ALL ->
                    for (item in unfilteredItems) {
                        if (item.brand!!.contains(query) || item.kind!!.contains(query) ||
                            item.owner!!.contains(query) || item.phoneNum!!.contains(query)
                        ) {
                            items.add(item)
                        }
                    }
                BRAND ->
                    for (item in unfilteredItems) {
                        if (item.brand!!.contains(query))
                            items.add(item)
                    }
                KIND ->
                    for (item in unfilteredItems) {
                        if (item.kind!!.contains(query))
                            items.add(item)
                    }
                OWNER ->
                    for (item in unfilteredItems) {
                        if (item.owner!!.contains(query))
                            items.add(item)
                    }
                PHONE_NUM ->
                    for (item in unfilteredItems) {
                        if (item.phoneNum!!.contains(query))
                            items.add(item)
                    }
            }

        } else {
            items.addAll(unfilteredItems)
        }
        notifyDataSetChanged()
    }

    fun setItems(newItems: MutableList<LaundryModel>) {
        items.clear()
        unfilteredItems.clear()
        items.addAll(newItems)
        unfilteredItems.addAll(newItems)
        notifyDataSetChanged()
    }

    companion object {
        const val OWNER_VISIBLE: Int = 0
        const val OWNER_GONE: Int = 1

        const val ALL: Int = 0
        const val BRAND: Int = 1
        const val KIND: Int = 2
        const val OWNER: Int = 3
        const val PHONE_NUM: Int = 4
        const val DONE_STATUS: Int = 5
    }
}