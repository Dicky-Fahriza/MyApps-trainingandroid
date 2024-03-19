package com.development.myapps.utiles

import android.content.Context
import android.content.SharedPreferences
import com.development.myapps.databinding.ActivityLoginBinding

class SharedPrefHelper(contxt: Context) {



    private val sharedPref: SharedPreferences =
        contxt.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        sharedPref.edit().putString(TOKEN_KEY, token).apply()
    }

    fun getToken(): String {
        return sharedPref.getString(TOKEN_KEY, null) ?: ""
    }

    fun clearDataPref() {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        const val PREF_NAME = "pref_name"
        const val TOKEN_KEY = "token_key"
    }
}

