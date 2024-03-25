package com.development.myapps.presentation
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.development.myapps.adapter.ListTransactionAdapter
import com.development.myapps.databinding.ActivityLoginBinding
import com.development.myapps.utiles.SharedPrefHelper
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityLoginBinding

    private lateinit var binding: ActivityLoginBinding

    private lateinit var sharePref: SharedPrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharePref = SharedPrefHelper(this)
        checkToken()

        val tvRegister = binding.tvRegister
        tvRegister.setOnClickListener {
            handleRegister()
        }

        val btnLogin = binding.btnLogin
        btnLogin.setOnClickListener {
            handleLogin()
        }

        binding.cbShowPassword.setOnClickListener {
            val cbShowPassword = binding.cbShowPassword
            if (cbShowPassword.isChecked) {
                binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT
            } else {
                binding.etPassword.inputType = InputType.TYPE_CLASS_TEXT or  InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
        }

        binding.btnLogin.setOnClickListener {
            if (binding.etNama.text.isEmpty().not() && binding.etPassword.text.isEmpty().not()) {
                val token: String = UUID.randomUUID().toString()
                sharePref.saveToken(token)
                handleLogin()
            } else {
                Toast.makeText(this, "Lengkapi username dan password", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun checkToken() {
        val  getToken = sharePref.getToken()
        if (getToken.isNotEmpty()) {
            handleLogin()
        }
    }

    private fun handleRegister(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun handleLogin(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }


    private fun showToast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

//    private fun handleLogin(){
//        val etNama = binding.etNama
//        val namaValue =  etNama.text
//
//        val etPassword = binding.etPassword
//        val passwordValue =  etPassword.text
//
//
//        if(passwordValue.isEmpty()||namaValue.isEmpty()){
//            showToast("harap lengkapi data")
//        } else {
//            val intent = Intent(this, HomeActivity::class.java)
//            intent.putExtra(KEY_ADDRESS,namaValue.toString())
//            startActivity(intent)
//            Toast.makeText(this,"Halo $namaValue selamat datang di aplikasi saya",Toast.LENGTH_SHORT).show()
//
//        }
//    }

    companion object {
        const val  KEY_NAME = "key_name"
        const val KEY_ADDRESS = "key_address"

    }

}