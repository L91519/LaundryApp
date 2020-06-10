package com.example.laundryapp.ui.laundry_list

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.laundryapp.R

class LaundryStatusDialog : DialogFragment() {

    internal lateinit var listener: NoticeDialogListener

    interface NoticeDialogListener {
        fun onDialogDoneClick(dialog: DialogFragment)
        fun onDialogUndoneClick(dialog: DialogFragment)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as NoticeDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                (context.toString() +
                        " must implement NoticeDialogListener")
            )
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.laundry_status_change)
                .setItems(R.array.laundry_status,
                    DialogInterface.OnClickListener { dialog, position ->
                        when (position) {
                            0->listener.onDialogDoneClick(this)
                            1->listener.onDialogUndoneClick(this)
                            2 -> dialog.dismiss()
                        }
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }
}