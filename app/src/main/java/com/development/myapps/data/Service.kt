package com.development.myapps.data

import com.development.myapps.model.MenuDashboardResponse
import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("menu-dashboard")
    suspend fun getHomeMenu() : Response<MenuDashboardResponse>
}