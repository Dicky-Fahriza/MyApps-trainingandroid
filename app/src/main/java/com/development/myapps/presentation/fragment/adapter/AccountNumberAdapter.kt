package com.development.myapps.presentation.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.development.myapps.databinding.ItemAccountNumberBinding
import com.development.myapps.databinding.ItemPromoBinding
import com.development.myapps.model.AccountNumberModel
import com.development.myapps.model.MenuDashboardModel
import dagger.hilt.android.AndroidEntryPoint


class AccountNumberAdapter(
    private val data: List<AccountNumberModel>
) : RecyclerView.Adapter<AccountNumberAdapter.AccountNumberViewHolder>() {
    inner class AccountNumberViewHolder(
        val binding: ItemAccountNumberBinding

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: AccountNumberModel) {
            binding.tvSavingType.text = data.savingType.toString()
            binding.tvAccountNumber.text = data.numberRekening.toString()
            binding.tvShowBalance.text = data.balanceAmount
        }}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountNumberViewHolder {
        return  AccountNumberViewHolder(
            ItemAccountNumberBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: AccountNumberViewHolder, position: Int) {
        holder.bind(data[position])
    }
}

