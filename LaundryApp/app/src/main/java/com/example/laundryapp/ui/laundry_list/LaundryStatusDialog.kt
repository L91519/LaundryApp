package com.example.laundryapp.ui.laundry_list

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.laundryapp.R
import com.example.laundryapp.data.model.LaundryModel

class LaundryStatusDialog : DialogFragment() {

    private lateinit var listener: NoticeDialogListener
    private var id : String = ""

    interface NoticeDialogListener {
        fun onDialogDoneClick(dialog: DialogFragment, id: String)
        fun onDialogUndoneClick(dialog: DialogFragment, id: String)
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
                .setItems(R.array.laundry_status
                ) { dialog, position ->
                    when (position) {
                        0 -> listener.onDialogDoneClick(this, id)
                        1 -> listener.onDialogUndoneClick(this, id)
                        2 -> dialog.dismiss()
                    }
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

    fun setLaundry(id: String) {
        this.id = id
    }
}