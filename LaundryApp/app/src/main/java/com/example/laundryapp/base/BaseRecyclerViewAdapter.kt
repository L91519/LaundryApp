package com.example.laundryapp.base

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class BaseRecyclerViewAdapter<ITEM, B : ViewDataBinding>(
    @LayoutRes val layoutResId: Int,
    val bindingVariableId: Int? = null
) : RecyclerView.Adapter<BaseViewHolder<B>>() {

    protected val items = mutableListOf<ITEM>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<B> =
        object : BaseViewHolder<B>(
            layoutResId,
            parent,
            bindingVariableId
        ){}

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BaseViewHolder<B>, position: Int) =
        holder.onBindViewHolder(items[position])

    protected fun getItems(position: Int): ITEM =
        items.getOrNull(position) ?: throw ArrayIndexOutOfBoundsException()

    fun updateItems(item: MutableList<ITEM>) {
        this.items.run {
            clear()
            items?.let {
                addAll(it)
            }
        }

        notifyDataSetChanged()
    }

    fun cleatItems() {
        val size = items.size
        items.clear()
        notifyItemRangeRemoved(0, size)
    }

}