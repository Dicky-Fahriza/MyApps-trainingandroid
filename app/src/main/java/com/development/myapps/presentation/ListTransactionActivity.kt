package com.development.myapps.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.development.myapps.adapter.ListTransactionAdapter
import com.development.myapps.databinding.ActivityListTransactionBinding
import com.development.myapps.databinding.ActivityLoginBinding
import com.development.myapps.model.TransactionModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListTransactionBinding

    private var listTransactionAdapter = ListTransactionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListTransaction.adapter = listTransactionAdapter
        listTransactionAdapter.setData(createDummyListTransaction())
        listTransactionAdapter.setOnClickTransaction { transaction ->
            navigateToDetailTransaction(transaction)
        }
    }

    private fun navigateToDetailTransaction(data: TransactionModel) {
        val intent = Intent(this, DetailTransactionActivity::class.java)
        intent.putExtra(TRANSACTION_KEY, data)
        startActivity(intent)
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

        companion object {
            const val TRANSACTION_KEY = "transaction_key"
        }
}
