package com.example.laundryapp.ui.laundry_list

import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivityLaundryListBinding

class LaundryListActivity :
    BaseActivity<ActivityLaundryListBinding, LaundryListViewModel>(R.layout.activity_laundry_list){
    override val vm: LaundryListViewModel =
        LaundryListViewModel()
}