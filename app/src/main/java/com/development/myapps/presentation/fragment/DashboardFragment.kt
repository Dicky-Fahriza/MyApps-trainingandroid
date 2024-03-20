package com.development.myapps.presentation.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.development.myapps.R
import com.development.myapps.base.BaseFragment
import com.development.myapps.databinding.FragmentDashboardBinding
import com.development.myapps.databinding.FragmentHistoryBinding
import com.development.myapps.model.AccountNumberModel
import com.development.myapps.model.MenuDashboardModel
import com.development.myapps.presentation.fragment.adapter.AccountNumberAdapter
import com.development.myapps.presentation.fragment.adapter.DashboardMenuAdapter
import com.development.myapps.utiles.HorizontalItemDecoration

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var menuAdapter: DashboardMenuAdapter
    private lateinit var accountAdapter: AccountNumberAdapter

    private val horizontalItemDecoration by lazy {
        HorizontalItemDecoration(
            resources.getDimensionPixelSize(R.dimen.spacing16),
            true
        )
    }
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
      setupViewMenu()
        setupViewAccountNumber()
    }

    private fun setupViewMenu() {
        menuAdapter = DashboardMenuAdapter(
            menuData = populateDataMenu(),
            context = binding.root.context
        )

        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener = AdapterView.OnItemClickListener {
                _, _, position, _ ->

            Toast.makeText(
                binding.root.context,
                populateDataMenu()[position].menuName,
                Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupViewAccountNumber() {
        accountAdapter = AccountNumberAdapter(
            data = populateDataAccountNumber()
        )

        binding.componentAccountNumber.rvAccountNumber.adapter = accountAdapter
        binding.componentAccountNumber.rvAccountNumber.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL, false
        )

        binding.componentAccountNumber.rvAccountNumber.apply {
            if (itemDecorationCount <= 0) {
                addItemDecoration(horizontalItemDecoration)
            }
        }

        }
    }

    private fun populateDataMenu() : List<MenuDashboardModel> {
        return listOf(
            MenuDashboardModel(
                image = R.drawable.baseline_inbox_24,
                menuName = "Transfer"
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_inbox_24,
                menuName = "Pembelian"
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_inbox_24,
                menuName = "Pembayaran"
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_inbox_24,
                menuName = "Cardless"
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_inbox_24,
                menuName = "Histori Transaksi"
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_inbox_24,
                menuName = "Mutasi Rekening"
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_inbox_24,
                menuName = "Jadwal Sh0lat"
            )
        )
    }

    private fun populateDataAccountNumber(): List<AccountNumberModel> {
        return listOf(
            AccountNumberModel(
                savingType = 1,
                numberRekening = "uyvugjg",
                balanceAmount = "m;lm;l"
            ),
            AccountNumberModel(
                savingType = 2,
                numberRekening = "Dicky Fahriza",
                balanceAmount = "xxxxxxxxxx"
            ),
            AccountNumberModel(
                savingType = 3,
                numberRekening = "xxxxxxxxxxxx",
                balanceAmount = "xxxxxxxxxxxxx"
            )
        )
    }