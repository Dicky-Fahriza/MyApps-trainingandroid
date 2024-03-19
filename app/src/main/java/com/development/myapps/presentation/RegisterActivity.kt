package com.development.myapps.presentation

import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.development.myapps.R
import com.development.myapps.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private var defaultPassswordVisibility = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleRegister()



// SetOnClickListener
        binding.ivRegister.setOnClickListener {
            // Toggle visibilitas password
            defaultPassswordVisibility = !defaultPassswordVisibility

            if (defaultPassswordVisibility){
                binding.ivRegister.setImageResource(R.drawable.baseline_blur_off_24)
                binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                binding.ivRegister.setImageResource(R.drawable.baseline_blur_on_24)
                binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }

    }

    private fun handleRegister() {
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        val etName = findViewById<EditText>(R.id.etName)
        val nameValue = etName.text

        val etPassword = findViewById<EditText>(R.id.etPassword)
        val passwordValue = etPassword.text

        btnRegister.setOnClickListener {
            if (nameValue.isEmpty() && passwordValue.isEmpty()) {
                showToast("Harap Lengkapi Data")
            } else {
                showToast("Halo $nameValue, $passwordValue")
            }
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}