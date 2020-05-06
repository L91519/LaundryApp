package com.example.laundryapp.ui.laundry_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laundryapp.base.BaseViewModel
import com.example.laundryapp.data.model.LaundryModel
import com.example.laundryapp.data.repository.LaundryAppRepository

class LaundryListViewModel constructor(private val repository: LaundryAppRepository) :
    BaseViewModel() {

    private val _observableLaundryList = MutableLiveData<MutableList<LaundryModel>>()
    val observableLaundryList : LiveData<MutableList<LaundryModel>>
        get() = _observableLaundryList

    private val _observableShowDialog = MutableLiveData(false)
    val observableShowDialog : LiveData<Boolean>
        get() = _observableShowDialog

    private val _observableFinishedLaundryShow = MutableLiveData(false)
    val observableFinishedLaundryShow : LiveData<Boolean>
        get() = _observableFinishedLaundryShow

    fun showLaundryAddDialog() {
        _observableShowDialog.value = true
    }

    fun finishedLaundryFilter() {
        _observableFinishedLaundryShow.value = true
    }

    fun getRecentLaundries() {
        repository.getRecentLaundries(
            success = {},
            fail = {}
        )
    }

    fun saveRecentLaundries() {
        //TODO : Using Rx might help
    }

    fun getLaundries() {
        repository.getLaundries(
            success = {},
            fail = {}
        )
    }

    fun getLaundriesByBrand(brand: String) {
        repository.getLaundriesByBrand(
            brand,
            success = {},
            fail = {}
        )
    }

    fun getLaundriesByKind(kind: String) {
        repository.getLaundriesByKind(
            kind,
            success = {},
            fail = {}
        )
    }

    fun getLaundriesByOwner(owner: String) {
        repository.getLaundriesByOwner(
            owner,
            success = {},
            fail = {}
        )
    }

    fun getLaundriesByPH(ph: String) {
        repository.getLaundriesByPH(
            ph,
            success = {},
            fail = {}
        )
    }

    fun delLaundries(laundry: LaundryModel) {
        repository.delLaundry(
            laundry,
            success = {},
            fail = {})
    }

    fun saveLaundries(laundry: LaundryModel) {
        repository.saveLaundry(
            laundry,
            success = {},
            fail = {}
        )
    }

}