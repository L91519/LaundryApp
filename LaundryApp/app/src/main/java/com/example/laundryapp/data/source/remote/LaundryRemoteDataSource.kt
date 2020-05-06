package com.example.laundryapp.data.source.remote

import com.example.laundryapp.data.model.LaundryModel

interface LaundryRemoteDataSource {

    fun getLaundries(
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun getLaundriesByBrand(
        brand: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun getLaundriesByKind(
        kind: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun getLaundriesByOwner(
        owner: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun getLaundriesByPH(
        ph: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun delLaundry(
        laundryModel: LaundryModel,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun saveLaundry(
        laundryModel: LaundryModel,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    )

}