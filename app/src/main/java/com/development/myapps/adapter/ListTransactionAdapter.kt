package com.development.myapps.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.development.myapps.databinding.ItemListTransactionBinding
import com.development.myapps.model.TransactionModel

class ListTransactionAdapter :
    RecyclerView.Adapter<ListTransactionAdapter.TransactionViewHolder>() {
    //        underscore pada variabel sebagai penanda bahwa variable tersebut merupakan mutable
//        kalo buat parameter gausah menggunakan underscore
    private var _data: MutableList<TransactionModel> = mutableListOf()

    private var _onClickTransaction: (TransactionModel) -> Unit = {}

    fun setData(newData: MutableList<TransactionModel>) {
        _data = newData
        notifyDataSetChanged()
    }

    fun setOnClickTransaction(listener: (TransactionModel) -> Unit) {
        _onClickTransaction = listener
    }

    inner class TransactionViewHolder(private val binding: ItemListTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TransactionModel, onClickTransaction: (TransactionModel) -> Unit) {
            binding.tvTransferType.text = item.transferType
            binding.tvStatusTransaction.text = item.transferStatus
            binding.tvAmount.text = item.amount.toString()
            binding.tvTransferDestination.text = item.transferDestination
            binding.tvDate.text = item.date

            binding.root.setOnClickListener{onClickTransaction.invoke(item)}
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(
            ItemListTransactionBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        )
    }

    //    Sama aja kayak return ini penyajian yang berbeda
    override fun getItemCount(): Int = _data.size

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(_data[position], _onClickTransaction)
    }
}







