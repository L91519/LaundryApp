package com.example.laundryapp.extension

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.laundryapp.data.model.LaundryModel
import com.example.laundryapp.data.model.OrderModel
import com.example.laundryapp.ui.laundry_add_dialog.LaundryAddRecyclerViewAdapter
import com.example.laundryapp.ui.laundry_list.LaundryListRecyclerViewAdapter

@BindingAdapter("bindLaundryItems", "bindLaundryShowAll")
fun RecyclerView.bindLaundryItems(items: MutableList<LaundryModel>?, showAll: Boolean){
    if(adapter is LaundryListRecyclerViewAdapter) {
        items?.let {
            (adapter as LaundryListRecyclerViewAdapter).setItems(items, showAll)
        }
    }
}

@BindingAdapter("bindOrderItems")
fun RecyclerView.bindOrderItems(items: MutableList<OrderModel>?) {
    if (adapter is LaundryAddRecyclerViewAdapter) {
        items?.let {
            (adapter as LaundryAddRecyclerViewAdapter).setItems(items)
        }
    }
}