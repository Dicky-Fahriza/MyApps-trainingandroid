package com.development.myapps.presentation.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.development.myapps.base.BaseFragment
import com.development.myapps.databinding.FragmentDashboardBinding
import com.development.myapps.databinding.FragmentHistoryBinding

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

    }





}