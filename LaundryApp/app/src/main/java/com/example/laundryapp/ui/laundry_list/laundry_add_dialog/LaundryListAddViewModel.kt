package com.example.laundryapp.ui.laundry_list.laundry_add_dialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laundryapp.base.BaseViewModel
import com.example.laundryapp.data.firebase.repository.FirebaseRepository
import com.example.laundryapp.data.model.LaundryModel
import com.example.laundryapp.data.model.OrderModel
import java.text.SimpleDateFormat
import java.util.*

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

    val observableOrderBrand = MutableLiveData<String>()
    val observableOrderKind = MutableLiveData<String>()
    val observableOrderPrice = MutableLiveData<String>()
    val observableName = MutableLiveData<String>()
    val observableAddress = MutableLiveData<String>()
    val observablePhoneNum = MutableLiveData<String>()

    private val cal = Calendar.getInstance()
    private val date : Date = cal.time
    private val dateFormat = SimpleDateFormat("yyyyMMdd")
    private var id : Long = DEFAULT_ID

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
                    order.date,
                    id * cal.timeInMillis
                ).let { laundryModel ->
                    repository.addItem(laundryModel,
                        success = {
//                            _observableToast.value = "Success Adding Data"
                        },
                        fail = {
                            _observableToast.value = "Save Laundries Failed"
                        })
                }
                id++
            }
            id = DEFAULT_ID
        }
        initOrderList()
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
                    observableOrderPrice.value,
                    dateFormat.format(date).toInt()
                )
            )
            _observableOrderList.value = tmpItems
            initOrder()
        }
    }

    private fun initOrder() {
        observableOrderBrand.value = ""
        observableOrderKind.value = ""
        observableOrderPrice.value = ""
    }

    private fun initOrderList() {
        _observableOrderList.value?.clear()
        observableName.value = ""
        observableAddress.value = ""
        observablePhoneNum.value = ""
    }

    companion object {
        const val DEFAULT_ID: Long = 2
    }

}