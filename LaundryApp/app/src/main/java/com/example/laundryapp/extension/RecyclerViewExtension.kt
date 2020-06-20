package com.example.laundryapp.extension

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.laundryapp.data.model.LaundryModel
import com.example.laundryapp.data.model.OrderModel
import com.example.laundryapp.ui.laundry_list.laundry_add_dialog.LaundryListAddRecyclerViewAdapter
import com.example.laundryapp.ui.laundry_list.LaundryListRecyclerViewAdapter

@BindingAdapter("bindLaundryItems", "bindLaundryShowAll")
fun RecyclerView.bindLaundryItems(items: MutableList<LaundryModel>?, showAll: Boolean){
    if(adapter is LaundryListRecyclerViewAdapter) {
        items?.let {
            (adapter as LaundryListRecyclerViewAdapter).setItems(items, showAll)
        }
    }
}

//@BindingAdapter("bindLaundryItems")
//fun RecyclerView.bindLaundryItems(items: MutableList<LaundryModel>?){
//    if(adapter is LaundryListRecyclerViewAdapter) {
//        items?.let {
//            (adapter as LaundryListRecyclerViewAdapter).setItems(items)
//        }
//    }
//}

@BindingAdapter("bindOrderItems")
fun RecyclerView.bindOrderItems(items: MutableList<OrderModel>?) {
    if (adapter is LaundryListAddRecyclerViewAdapter) {
        items?.let {
            (adapter as LaundryListAddRecyclerViewAdapter).setItems(items)
        }
    }
}
