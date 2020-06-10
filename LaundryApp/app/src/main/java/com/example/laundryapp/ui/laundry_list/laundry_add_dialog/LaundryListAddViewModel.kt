package com.example.laundryapp.ui.laundry_list.laundry_add_dialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laundryapp.base.BaseViewModel
import com.example.laundryapp.data.firebase.repository.FirebaseRepository
import com.example.laundryapp.data.model.LaundryModel
import com.example.laundryapp.data.model.OrderModel

class LaundryListAddViewModel constructor(private val repository: FirebaseRepository) :
    BaseViewModel() {

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
        dismissDialog()
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