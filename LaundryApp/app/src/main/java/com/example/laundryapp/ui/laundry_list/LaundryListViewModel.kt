package com.example.laundryapp.ui.laundry_list

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laundryapp.base.BaseViewModel
import com.example.laundryapp.data.firebase.repository.FirebaseRepository
import com.example.laundryapp.data.model.LaundryModel

class LaundryListViewModel constructor(private val repository: FirebaseRepository) :
    BaseViewModel() {

    private val _observableLaundryList = MutableLiveData<MutableList<LaundryModel>>()
    val observableLaundryList: LiveData<MutableList<LaundryModel>>
        get() = _observableLaundryList

    private val _observableShowLaundryAddDialog = MutableLiveData(false)
    val observableShowLaundryAddDialog: LiveData<Boolean>
        get() = _observableShowLaundryAddDialog

    private val _observableShowLaundryStatusDialog = MutableLiveData<Long>()
    val observableShowLaundryStatusDialog : LiveData<Long>
        get() = _observableShowLaundryStatusDialog

    private val _observableFinishedLaundryShow = MutableLiveData(false)
    val observableFinishedLaundryShow: LiveData<Boolean>
        get() = _observableFinishedLaundryShow

    private val _observableToast = MutableLiveData<String>()
    val observableToast: LiveData<String>
        get() = _observableToast

    fun showLaundryAddDialog() {
        _observableShowLaundryAddDialog.value = true
    }

    fun hideLaundryAddDialog() {
        _observableShowLaundryAddDialog.value = false
    }

    fun showLaundryStatusDialog(id: Long){
        _observableShowLaundryStatusDialog.value = id
    }

    fun hideLaundryStatusDialog() {
        _observableShowLaundryStatusDialog.value = 0
    }

    fun finishedLaundryFilter() {
        _observableFinishedLaundryShow.value =  !(_observableFinishedLaundryShow.value as Boolean)
    }

    fun getRecentLaundries() {
    }

    fun saveRecentLaundries() {
        //TODO : Using Rx might help
    }

    fun getLaundries() {
        repository.getLaundries(
            success = { laundryModels ->
                _observableLaundryList.value = laundryModels
            },
            fail = { e ->
                _observableToast.value = e.toString()
            }
        )
    }

    fun updateIsDoneStatus(isDone: Boolean, laundryId: String) {
        repository.updateIsDoneStatus(
            isDone,
            laundryId,
            success = {
                _observableToast.value = ""
            },
            fail = { e ->
                _observableToast.value = e.toString()
            })
    }

}