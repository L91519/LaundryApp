package com.example.laundryapp.ui.laundry_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laundryapp.base.BaseViewModel
import com.example.laundryapp.data.model.LaundryModel

class LaundryListViewModel : BaseViewModel() {

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

}