package com.development.myapps.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.development.myapps.R
import com.development.myapps.data.remote.MenuDashboardRemoteDataSource
import com.development.myapps.model.AccountNumberModel
import com.development.myapps.model.MenuDashboard
import com.development.myapps.model.MenuDashboardModel
import com.development.myapps.model.MenuDashboardResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val menuDashboardRemoteDataSource: MenuDashboardRemoteDataSource
) : ViewModel() {
    private val _homeMenu = MutableLiveData<MenuDashboardResponse>()
    val homeMenu: LiveData<MenuDashboardResponse>
        get() = _homeMenu

    private val _homeMenuError = MutableLiveData<String>()
    val homeMenuError: LiveData<String>
        get() = _homeMenuError


    fun getHomeMenu() = viewModelScope.launch(Dispatchers.IO) {
        menuDashboardRemoteDataSource.getMenuDashboard().let {
            if (it.isSuccessful) {
                _homeMenu.postValue(it.body())
            } else {
                _homeMenuError.postValue(it.message())
            }
        }
    }


    // Account Number
    private val _accountnumber = MutableLiveData<List<AccountNumberModel>>()
    val accountNumber: LiveData<List<AccountNumberModel>>
        get() = _accountnumber
    private fun populateDataAccountNumber(): List<AccountNumberModel> {
        return listOf(
            AccountNumberModel(
                savingType = "TAHAPAN WADIAH ONLINE",
                numberRekening = "012345678",
                balanceAmount = "Rp *****"
            ),
            AccountNumberModel(
                savingType = "TAHAPAN WADIAH ONLINE",
                numberRekening = "012345678",
                balanceAmount = "Rp *****"
            ),
            AccountNumberModel(
                savingType = "TAHAPAN WADIAH ONLINE",
                numberRekening = "012345678",
                balanceAmount = "Rp *****"
            )
        )
    }

    fun getAccountNumber() = viewModelScope.launch(Dispatchers.IO) {
        _accountnumber.postValue(populateDataAccountNumber())
    }
}