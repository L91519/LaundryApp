package com.example.laundryapp.data.repository

import com.example.laundryapp.data.model.LaundryModel
import com.example.laundryapp.data.source.local.LaundryLocalDataSource
import com.example.laundryapp.data.source.remote.LaundryRemoteDataSource

class LaundryAppRepositoryImpl(
    private val laundryLocal: LaundryLocalDataSource,
    private val laundryRemote: LaundryRemoteDataSource
) : LaundryAppRepository {

    override fun getLaundries(
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ): MutableList<LaundryModel> {
        TODO("Not yet implemented")
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
    ): MutableList<LaundryModel> {
        TODO("Not yet implemented")
    }

    override fun getLaundriesByOwner(
        owner: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ): MutableList<LaundryModel> {
        TODO("Not yet implemented")
    }

    override fun getLaundriesByPH(
        ph: String,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ): MutableList<LaundryModel> {
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

    override fun getRecentLaundries(
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ): MutableList<LaundryModel> {
        TODO("Not yet implemented")
    }

    override fun saveRecentLaundries(
        laundries: MutableList<LaundryModel>,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        TODO("Not yet implemented")
    }

}
