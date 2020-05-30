package com.example.laundryapp.ui.laundry_add_dialog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.laundryapp.base.BaseViewModel
import com.example.laundryapp.data.firebase.repository.FirebaseRepository
import com.example.laundryapp.data.model.OrderModel

class LaundryAddDialogViewModel constructor(private val repository: FirebaseRepository) :
    BaseViewModel() {

    private val _observableOrderList = MutableLiveData<MutableList<OrderModel>>()
    val observableOrderList: LiveData<MutableList<OrderModel>>
        get() = _observableOrderList

    private val _observableToast = MutableLiveData<String>()
    val observableToast: LiveData<String>
        get() = _observableToast

    val observableOrderBrand = MutableLiveData<String>()
    val observableOrderKind = MutableLiveData<String>()
    val observableOrderPrice = MutableLiveData<String>()

    private val tmpItems = mutableListOf<OrderModel>()

    fun dismissDialog() {

    }

    fun addLaundries() {

    }

    fun addOrder() {
//        _observableOrderList.value?.add(OrderModel("","",""))
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
        }
    }

}