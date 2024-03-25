package com.development.myapps.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.development.myapps.R
import com.development.myapps.databinding.ActivityHomeBinding
import com.development.myapps.databinding.ActivityLoginBinding
import com.development.myapps.presentation.fragment.AdminFragment
import com.development.myapps.presentation.fragment.DashboardFragment
import com.development.myapps.presentation.fragment.InboxFragment
import com.development.myapps.presentation.fragment.MessageFragment
import com.development.myapps.utiles.ConfirmationDialogUtil
import com.development.myapps.utiles.SharedPrefHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var confirmationDialogUtil: ConfirmationDialogUtil

    private lateinit var sharePref: SharedPrefHelper

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    replaceFragment(DashboardFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationInbox -> {
                    replaceFragment(InboxFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationAdmin -> {
                    replaceFragment(AdminFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationMessage -> {
                    replaceFragment(MessageFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationLogout -> {
                    showConfirmation()
                    return@OnNavigationItemSelectedListener false
                }
            }
                false
            }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharePref = SharedPrefHelper(this)

        confirmationDialogUtil = ConfirmationDialogUtil(this)
        binding.bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigationHome
        }
    }

    private fun showConfirmation() {
        val title = "Apakah anda ingin keluar?"
        val icon = R.drawable.baseline_admin_panel_settings_24

        confirmationDialogUtil.showConfirmationDialog(
            title = title,
            icon = icon,
            onConfirm = {
                sharePref.clearDataPref()
                handleLogout()
            },
            onCancel = {

            }

        )
    }

    private fun  replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

    private fun handleLogout(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)


    }

}