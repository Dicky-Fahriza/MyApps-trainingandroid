package com.development.myapps.presentation.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.development.myapps.databinding.ItemAccountNumberBinding
import com.development.myapps.databinding.ItemPromoBinding
import com.development.myapps.model.AccountNumberModel
import com.development.myapps.model.MenuDashboardModel
import com.development.myapps.model.PromoModel
import dagger.hilt.android.AndroidEntryPoint


class PromoAdapter(
    private val data: List<PromoModel>
) : RecyclerView.Adapter<PromoAdapter.PromoViewHolder>() {
    inner class PromoViewHolder(
        val binding: ItemPromoBinding

    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PromoModel) {
            binding.ivGambar.setImageResource(data.image)
        }}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        return  PromoViewHolder(
            ItemPromoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        holder.bind(data[position])
    }
}

