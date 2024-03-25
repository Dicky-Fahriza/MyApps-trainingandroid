package com.development.myapps.di

import com.development.myapps.data.Service
import com.development.myapps.data.remote.MenuDashboardRemoteDataSource
import com.development.myapps.data.remote.MenuDashboardRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MenuModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDataSource(service: Service) :
            MenuDashboardRemoteDataSource {
        return MenuDashboardRemoteDataSourceImpl(service)
    }
}

