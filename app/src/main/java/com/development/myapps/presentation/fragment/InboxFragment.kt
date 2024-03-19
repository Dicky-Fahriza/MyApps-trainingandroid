package com.development.myapps.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.development.myapps.adapter.ListTransactionAdapter
import com.development.myapps.databinding.FragmentDashboardBinding
import com.development.myapps.databinding.FragmentInboxBinding
import com.development.myapps.model.TransactionModel


class InboxFragment : Fragment() {
    private var _binding : FragmentInboxBinding? = null
    private val binding get() = _binding!!

    private var listTransactionAdapter = ListTransactionAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInboxBinding.inflate(inflater, container, false)
        binding.rvListTransaction.adapter = listTransactionAdapter
        listTransactionAdapter.setData(createDummyListTransaction())
        return binding.root
    }

    private  fun createDummyListTransaction() : MutableList<TransactionModel> {
        return mutableListOf(
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/1999",
                transferStatus = "Failed",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "BCA",
                date = "23/04/1999",
                transferStatus = "Succes",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/1999",
                transferStatus = "Failed",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "BCA",
                date = "23/04/1999",
                transferStatus = "Succes",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/1999",
                transferStatus = "Failed",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "BCA",
                date = "23/04/1999",
                transferStatus = "Succes",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/1999",
                transferStatus = "Failed",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "BCA",
                date = "23/04/1999",
                transferStatus = "Succes",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/1999",
                transferStatus = "Failed",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "BCA",
                date = "23/04/1999",
                transferStatus = "Succes",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/1999",
                transferStatus = "Failed",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "BCA",
                date = "23/04/1999",
                transferStatus = "Succes",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/1999",
                transferStatus = "Failed",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "BCA",
                date = "23/04/1999",
                transferStatus = "Succes",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                date = "23/04/1999",
                transferStatus = "Failed",
                amount = 1000000.0
            ),
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "BCA",
                date = "23/04/1999",
                transferStatus = "Succes",
                amount = 1000000.0
            ),
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}