package com.example.laundryapp.data.source.local

import com.example.laundryapp.data.model.LaundryModel
import com.example.laundryapp.data.source.local.db.LaundryDao

class LaundryLocalDataSourceImpl constructor(private val laundryDao: LaundryDao) :
    LaundryLocalDataSource {
    override fun getRecentLaundries(
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        success(laundryDao.getLaundries())
    }

    override fun saveRecentLaundries(
        laundries: MutableList<LaundryModel>,
        success: (MutableList<LaundryModel>) -> Unit,
        fail: (Throwable) -> Unit
    ) {
        laundryDao.saveLaundry(laundries)
    }


}