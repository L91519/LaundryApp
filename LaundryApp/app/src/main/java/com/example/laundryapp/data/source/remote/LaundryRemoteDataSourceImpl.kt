package com.example.laundryapp.data.source.remote

import com.example.laundryapp.data.model.LaundryModel

//class LaundryRemoteDataSourceImpl constructor(private val laundryApi: LaundryApi) :
class LaundryRemoteDataSourceImpl :
    LaundryRemoteDataSource {
    override fun getLaundries(
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
    }

    override fun getLaundriesByBrand(
        brand: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getLaundriesByKind(
        kind: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getLaundriesByOwner(
        owner: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun getLaundriesByPH(
        ph: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun delLaundry(
        laundryModel: LaundryModel,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        TODO("Not yet implemented")
    }

    override fun saveLaundry(
        laundryModel: LaundryModel,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        TODO("Not yet implemented")
    }

}