package com.example.laundryapp.ui.laundry_list

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laundryapp.base.BaseViewModel
import com.example.laundryapp.data.firebase.repository.FirebaseRepository
import com.example.laundryapp.data.model.LaundryModel
import com.example.laundryapp.data.model.OrderModel

class LaundryListViewModel constructor(private val repository: FirebaseRepository) :
    BaseViewModel() {

    private val _observableLaundryList = MutableLiveData<MutableList<LaundryModel>>()
    val observableLaundryList: LiveData<MutableList<LaundryModel>>
        get() = _observableLaundryList

    private val _observableShowLaundryAddDialog = MutableLiveData(false)
    val observableShowLaundryAddDialog: LiveData<Boolean>
        get() = _observableShowLaundryAddDialog

    private val _observableDismissLaundryAddDialog = MutableLiveData(false)
    val observableDismissLaundryAddDialog: LiveData<Boolean>
        get() = _observableDismissLaundryAddDialog

    private val _observableLaundryStatusDialog = MutableLiveData(false)
    val observableLaundryStatusDialog : LiveData<Boolean>
        get() = _observableLaundryStatusDialog

    private val _observableDismissLaundryStatusDialog = MutableLiveData(false)
    val observableDismissLaundryStatusDialog : LiveData<Boolean>
        get() = _observableDismissLaundryStatusDialog

    private val _observableFinishedLaundryShow = MutableLiveData(false)
    val observableFinishedLaundryShow: LiveData<Boolean>
        get() = _observableFinishedLaundryShow

    private val _observableOrderList = MutableLiveData<MutableList<OrderModel>>()
    val observableOrderList: LiveData<MutableList<OrderModel>>
        get() = _observableOrderList

    private val _observableToast = MutableLiveData<String>()
    val observableToast: LiveData<String>
        get() = _observableToast

    private val _observableRestartActivity = MutableLiveData(false)
    val observableRestartActivity : LiveData<Boolean>
        get() = _observableRestartActivity

    private val observableOrderBrand = MutableLiveData<String>()
    private val observableOrderKind = MutableLiveData<String>()
    private val observableOrderPrice = MutableLiveData<String>()
    private val observableName = MutableLiveData<String>()
    private val observableAddress = MutableLiveData<String>()
    private val observablePhoneNum = MutableLiveData<String>()

    private val tmpItems = mutableListOf<OrderModel>()

    fun showLaundryAddDialog() {
        _observableShowLaundryAddDialog.value = true
    }

    fun hideLaundryAddDialog() {
        _observableShowLaundryAddDialog.value = false
    }

    fun showLaundryStatusDialog(view: View){
        _observableLaundryStatusDialog.value = true
    }

    fun hideLaundryStatusDialog() {
        _observableLaundryStatusDialog.value = false
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

    fun getLaundriesByBrand(brand: String) {
    }

    fun getLaundriesByKind(kind: String) {
    }

    fun getLaundriesByOwner(owner: String) {
    }

    fun getLaundriesByPH(ph: String) {
    }

    fun delLaundries(laundry: LaundryModel) {
    }

    fun saveLaundries(laundry: LaundryModel) {
    }

    fun dismissLaundryAddDialogStatus() {
        _observableDismissLaundryAddDialog.value = false
    }

    fun addLaundries() {
        _observableOrderList.value?.let { orderModels ->
            for (order in orderModels) {
                LaundryModel(
                    observablePhoneNum.value,
                    observableAddress.value,
                    observableName.value,
                    order.brand,
                    order.kind,
                    order.price,
                    "",
                    false,
                    ""
                ).let { laundryModel ->
                    repository.addItem(laundryModel,
                        success = {
//                            _observableToast.value = "Success Adding Data"
                        },
                        fail = {
                            _observableToast.value = "Save Laundries Failed"
                        })
                }
            }
        }
    }

    fun addOrder() {
        if (observableOrderBrand.value.isNullOrEmpty() ||
            observableOrderKind.value.isNullOrEmpty() ||
            observableOrderPrice.value.isNullOrEmpty()
        ) {
            _observableToast.value = "Fill in the blank"
            return
        } else {
            tmpItems.add(
                OrderModel(
                    observableOrderBrand.value,
                    observableOrderKind.value,
                    observableOrderPrice.value
                )
            )
            _observableOrderList.value = tmpItems
            observableOrderBrand.value = ""
            observableOrderKind.value = ""
            observableOrderPrice.value = ""
        }
    }

}