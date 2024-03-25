package com.development.myapps.presentation.fragment


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.development.myapps.R
import com.development.myapps.base.BaseFragment
import com.development.myapps.databinding.FragmentDashboardBinding
import com.development.myapps.model.AccountNumberModel
import com.development.myapps.model.MenuDashboard
import com.development.myapps.model.MenuDashboardModel
import com.development.myapps.model.PromoModel
import com.development.myapps.presentation.fragment.adapter.AccountNumberAdapter
import com.development.myapps.presentation.fragment.adapter.DashboardMenuAdapter
import com.development.myapps.presentation.fragment.adapter.PromoAdapter
import com.development.myapps.presentation.viewmodel.DashboardViewModel
import com.development.myapps.utiles.HorizontalItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val viewModel: DashboardViewModel by viewModels()

    private lateinit var menuAdapter: DashboardMenuAdapter
    private lateinit var accountAdapter: AccountNumberAdapter

    private  lateinit var promoAdapter: PromoAdapter

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
        setupViewPromo()

        viewModel.getHomeMenu()
        viewModel.getAccountNumber()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.homeMenu.observe(viewLifecycleOwner) {
            setupViewMenu(it.data)
        }
        viewModel.accountNumber.observe(viewLifecycleOwner) {
            setupViewAccountNumber(it)
        }
    }

    private fun setupViewMenu(data: List<MenuDashboard>?) {


        menuAdapter = DashboardMenuAdapter(
            menuData = data ?: listOf(),
            context = binding.root.context
        )

        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener = AdapterView.OnItemClickListener {
                _, _, position, _ ->

            Toast.makeText(
                binding.root.context,
                data?.get(position)?.nameMenu,
                Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun setupViewAccountNumber(data: List<AccountNumberModel>) {
        accountAdapter = AccountNumberAdapter(
            data = data,
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


    private fun setupViewPromo() {
        promoAdapter = PromoAdapter(
            data = populateDataPromo()
        )


        binding.componentPromo.rvPromo.adapter = promoAdapter
        binding.componentPromo.rvPromo.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL, false
        )

        binding.componentPromo.rvPromo.apply {
            if (itemDecorationCount <= 0) {
                addItemDecoration(horizontalItemDecoration)
            }
        }

    }
}

    private fun populateDataPromo(): List<PromoModel> {
        return listOf(
            PromoModel(
                image = R.drawable.promo1
            ),
            PromoModel(
                image = R.drawable.promo3
            ),
            PromoModel(
                image = R.drawable.promo3
            ),
        )
    }