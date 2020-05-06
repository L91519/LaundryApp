package com.example.laundryapp.ui.laundry_list

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivityLaundryListBinding
import kotlinx.android.synthetic.main.activity_laundry_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaundryListActivity :
    BaseActivity<ActivityLaundryListBinding, LaundryListViewModel>(R.layout.activity_laundry_list){
    override val vm by viewModel<LaundryListViewModel>()

    private lateinit var adapter: LaundryListRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = LaundryListRecyclerViewAdapter()
        binding.rvLaundryList.adapter = adapter

        observableProperty()
    }

    private fun observableProperty(){
        vm.observableFinishedLaundryShow.observe(this@LaundryListActivity, Observer {

        })

        vm.observableShowDialog.observe(this@LaundryListActivity, Observer {

        })
    }
}