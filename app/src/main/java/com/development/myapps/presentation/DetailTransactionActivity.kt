package com.development.myapps.presentation

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.development.myapps.R
import com.development.myapps.databinding.ActivityDetailTransactionBinding
import com.development.myapps.model.TransactionModel
import com.development.myapps.presentation.ListTransactionActivity.Companion.TRANSACTION_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = intent.getParcelableExtra<TransactionModel>(TRANSACTION_KEY)
        binding.tvDate.text = transaction?.date
        binding.tvTransferType.text = transaction?.transferType
        binding.tvStatusTransaction.text = transaction?.transferStatus
        binding.tvAmount.text = transaction?.amount.toString()
        binding.tvTransferDestination.text = transaction?.transferDestination
    }
}