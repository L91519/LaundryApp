package com.example.laundryapp.data.source.local

import com.example.laundryapp.data.model.LaundryModel

interface LaundryLocalDataSource {

    fun getRecentLaundries(
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun saveRecentLaundries(
        laundries: MutableList<LaundryModel>,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit)
}