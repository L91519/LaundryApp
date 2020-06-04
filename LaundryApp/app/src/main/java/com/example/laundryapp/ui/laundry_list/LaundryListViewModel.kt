package com.example.laundryapp.ui.laundry_list

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

    private val _observableShowDialog = MutableLiveData(false)
    val observableShowDialog: LiveData<Boolean>
        get() = _observableShowDialog

    private val _observableFinishedLaundryShow = MutableLiveData(false)
    val observableFinishedLaundryShow: LiveData<Boolean>
        get() = _observableFinishedLaundryShow

    private val _observableOrderList = MutableLiveData<MutableList<OrderModel>>()
    val observableOrderList: LiveData<MutableList<OrderModel>>
        get() = _observableOrderList

    private val _observableToast = MutableLiveData<String>()
    val observableToast: LiveData<String>
        get() = _observableToast

    private val _observableDismissDialog = MutableLiveData(false)
    val observableDismissDialog: LiveData<Boolean>
        get() = _observableDismissDialog

    private val _observableRestartActivity = MutableLiveData(false)
    val observableRestartActivity : LiveData<Boolean>
        get() = _observableRestartActivity

    val observableOrderBrand = MutableLiveData<String>()
    val observableOrderKind = MutableLiveData<String>()
    val observableOrderPrice = MutableLiveData<String>()
    val observableName = MutableLiveData<String>()
    val observableAddress = MutableLiveData<String>()
    val observablePhoneNum = MutableLiveData<String>()

    private val tmpItems = mutableListOf<OrderModel>()

    fun showLaundryAddDialog() {
        _observableShowDialog.value = true
    }

    fun hideLaundryAddDialog() {
        _observableShowDialog.value = false
    }

    fun finishedLaundryFilter() {
        _observableFinishedLaundryShow.value = true
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

    fun dismissDialog() {
        _observableDismissDialog.value = true
    }

    fun changeDismissDialogStatus() {
        _observableDismissDialog.value = false
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

        restartActivity()
        dismissDialog()
    }

    private fun restartActivity(){
        _observableRestartActivity.value = true
    }

    fun changeRestartActivityStatus() {
        _observableRestartActivity.value = false
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