package com.example.laundryapp.ui.laundry_list

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivityLaundryListBinding
import com.example.laundryapp.extension.showToastShort
import com.example.laundryapp.ui.laundry_list.laundry_add_dialog.LaundryListAddDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaundryListActivity :
    BaseActivity<ActivityLaundryListBinding, LaundryListViewModel>(R.layout.activity_laundry_list){
    override val vm by viewModel<LaundryListViewModel>()

    private lateinit var adapter: LaundryListRecyclerViewAdapter
    private val laundryAddDialog =
        LaundryListAddDialog()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adapter = LaundryListRecyclerViewAdapter()
        binding.rvLaundryList.adapter = adapter
        vm.getLaundries()
//
        observableProperty()
    }

    override fun onStart() {
        super.onStart()
    }

    private fun observableProperty(){
        vm.observableFinishedLaundryShow.observe(this@LaundryListActivity, Observer {

        })

        vm.observableShowDialog.observe(this@LaundryListActivity, Observer {
            if (it) {
                showLaundryAddDialog()
                vm.hideLaundryAddDialog()
            }
        })

        vm.observableToast.observe(this@LaundryListActivity, Observer {
            showToastShort(it)
        })

        vm.observableRestartActivity.observe(this@LaundryListActivity, Observer {
            if (it) {
                onRestart()
                vm.changeRestartActivityStatus()
            }
        })
    }

    private fun showLaundryAddDialog() {
        laundryAddDialog.show(supportFragmentManager, "laundryAddDialog")
    }
}