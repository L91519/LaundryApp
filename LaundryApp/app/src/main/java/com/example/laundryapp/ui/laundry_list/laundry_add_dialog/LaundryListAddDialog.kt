package com.example.laundryapp.ui.laundry_list.laundry_add_dialog

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.example.laundryapp.BR
import com.example.laundryapp.R
import com.example.laundryapp.databinding.DialogAddLaundryBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class LaundryListAddDialog : DialogFragment() {
    private val vm by viewModel<LaundryListAddViewModel>()

    private lateinit var binding: DialogAddLaundryBinding
    private lateinit var _context: Context

    private lateinit var adapter: LaundryListAddRecyclerViewAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        _context = context
    }

    override fun onResume() {
        super.onResume()
        val dialogWidth = _context.resources.getDimensionPixelSize(R.dimen.laundry_add_dialog_width)
        val dialogHeight = _context.resources.getDimensionPixelSize(R.dimen.laundry_add_dialog_height)
        dialog?.window?.setLayout(dialogWidth, dialogHeight)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: DialogAddLaundryBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.dialog_add_laundry,
            null,
            false
        )
        binding.setVariable(BR.vm, vm)
        binding.lifecycleOwner = this

        adapter =
            LaundryListAddRecyclerViewAdapter()
        binding.rvLaundryAddList.adapter = adapter

        observableProperty()

        return binding.root
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        val activity = activity
        if (activity is DialogInterface.OnDismissListener) {
            (activity as DialogInterface.OnDismissListener).onDismiss(dialog)
        }
    }

    private fun observableProperty() {
        vm.observableDismissDialog.observe(this, Observer {
            if (it) {
                dismiss()
                vm.changeDismissDialogStatus()
            }
        })
    }
}