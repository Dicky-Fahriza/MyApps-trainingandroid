package com.development.myapps.data.remote

import com.development.myapps.model.MenuDashboardResponse
import retrofit2.Response

interface  MenuDashboardRemoteDataSource  {

    suspend fun getMenuDashboard() : Response<MenuDashboardResponse>


}