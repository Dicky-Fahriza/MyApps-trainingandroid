package com.development.myapps.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.development.myapps.presentation.LoginActivity.Companion.KEY_ADDRESS
import com.development.myapps.databinding.ActivityProfileBinding


class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val getName = intent.getStringExtra(KEY_ADDRESS)
        binding.tvLabelEmail.text = getName

        binding.vComponentTopbar.tvTitle.text = "Profile Features"
        binding.vComponentTopbar.ivBack.setOnClickListener{
            onBackPressed()
        }
    }
}