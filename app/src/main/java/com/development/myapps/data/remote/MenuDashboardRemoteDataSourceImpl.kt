package com.development.myapps.data.remote

import com.development.myapps.data.Service
import com.development.myapps.model.MenuDashboardResponse
import retrofit2.Response
import javax.inject.Inject

class MenuDashboardRemoteDataSourceImpl @Inject constructor(
    private val service: Service
) : MenuDashboardRemoteDataSource {
    override suspend fun getMenuDashboard(): Response<MenuDashboardResponse> {
        return service.getHomeMenu()
    }
}