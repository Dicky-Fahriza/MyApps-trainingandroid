package com.development.myapps.utiles

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.development.myapps.R
import com.development.myapps.databinding.DialogLayoutBinding

class ConfirmationDialogUtil(private val context: Context) {

    fun showConfirmationDialog(
        title: String,
        icon: Int? = null,
        onConfirm: () -> Unit,
        onCancel: () -> Unit,
    ) {
        val dialogBuilder = AlertDialog.Builder(context)
        val alertDialog = dialogBuilder.create()

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_layout,null)
        val binding = DialogLayoutBinding.bind(dialogView)

        binding.tvTitle.text = title

        if (icon != null) {
            binding.icIconDialog.visibility = View.VISIBLE
            binding.icIconDialog.setImageResource(icon)
        } else {
            binding.icIconDialog.visibility = View.GONE
        }

        alertDialog.setView(dialogView)

        binding.btnYes.setOnClickListener {
            onConfirm.invoke()
            alertDialog.dismiss()
        }
        binding.btnNo.setOnClickListener {
            onCancel.invoke()
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}