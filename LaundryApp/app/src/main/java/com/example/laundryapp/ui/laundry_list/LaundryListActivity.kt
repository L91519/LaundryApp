package com.example.laundryapp.ui.laundry_list

import android.content.DialogInterface
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.SearchView
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.example.laundryapp.R
import com.example.laundryapp.base.BaseActivity
import com.example.laundryapp.databinding.ActivityLaundryListBinding
import com.example.laundryapp.extension.showToastShort
import com.example.laundryapp.ui.laundry_list.laundry_add_dialog.LaundryListAddDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaundryListActivity :
    BaseActivity<ActivityLaundryListBinding, LaundryListViewModel>(R.layout.activity_laundry_list),
    DialogInterface.OnDismissListener,
    LaundryStatusDialog.NoticeDialogListener,
    SearchView.OnQueryTextListener {
    override val vm by viewModel<LaundryListViewModel>()

    private lateinit var adapter: LaundryListRecyclerViewAdapter
    private lateinit var spinner: Spinner
    private lateinit var searchView: SearchView
    private lateinit var checkBox: CheckBox

    private val laundryAddDialog = LaundryListAddDialog()
    private val laundryStatusDialog = LaundryStatusDialog()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        spinner = binding.spnrSearchFilter
        searchView = binding.svLaundrySearch
        checkBox = binding.cbFinishedLaundry

        adapter = LaundryListRecyclerViewAdapter()
        binding.rvLaundryList.adapter = adapter

        initSpinner()
        initSearchView()
        observableProperty()
    }

    override fun onStart() {
        super.onStart()
        vm.getLaundries()
    }

    private fun initSearchView() {
        searchView.setOnQueryTextListener(this)
    }

    private fun initSpinner() {
//        ArrayAdapter.createFromResource(
//            this,
//            R.array.laundry_filter,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            // Specify the layout to use when the list of choices appears
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            // Apply the adapter to the spinner
//            spinner.adapter = adapter
//        }
//        spinner.setSelection(0)

        val list = resources.getStringArray(R.array.laundry_filter)

        ArrayAdapter(this, R.layout.spinner_item_textview, list).also { adapter ->
            spinner.adapter = adapter
        }
    }

    private fun observableProperty() {
        vm.observableFinishedLaundryShow.observe(this@LaundryListActivity, Observer {
            adapter.isDoneFilter(!it)
        })

        vm.observableShowLaundryAddDialog.observe(this@LaundryListActivity, Observer {
            if (it) {
                showLaundryAddDialog()
                vm.hideLaundryAddDialog()
            }
        })

        vm.observableLaundryStatusDialog.observe(this, Observer {
            if (it) {
                showLaundryStatusDialog()
                vm.hideLaundryStatusDialog()
            }
        })

        vm.observableToast.observe(this@LaundryListActivity, Observer {
            showToastShort(it)
        })
    }

    private fun showLaundryAddDialog() {
        laundryAddDialog.show(supportFragmentManager, "laundryAddDialog")
    }

    private fun showLaundryStatusDialog() {
        laundryStatusDialog.show(supportFragmentManager, "laundryStatusDialog")
    }

    private fun dismissLaundryAddDialog() {
    }

    override fun onDismiss(dialog: DialogInterface?) {
        onStart()
    }

    override fun onDialogDoneClick(dialog: DialogFragment) {
        dialog.dismiss()
    }

    override fun onDialogUndoneClick(dialog: DialogFragment) {
        dialog.dismiss()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let {
            adapter.filter(spinner.selectedItemPosition, it)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if (query.isNullOrEmpty()) {
            adapter.filter(spinner.selectedItemPosition, "")
        }
        return true;
    }
}