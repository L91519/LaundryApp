package com.example.laundryapp.data.repository

import com.example.laundryapp.data.model.LaundryModel

interface LaundryAppRepository {

    fun getLaundries(
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ): MutableList<LaundryModel>

    fun getLaundriesByBrand(
        brand: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun getLaundriesByKind(
        kind: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ): MutableList<LaundryModel>

    fun getLaundriesByOwner(
        owner: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ): MutableList<LaundryModel>

    fun getLaundriesByPH(
        ph: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ): MutableList<LaundryModel>

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

    fun getRecentLaundries(
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ): MutableList<LaundryModel>

    fun saveRecentLaundries(
        laundries: MutableList<LaundryModel>,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    )

}