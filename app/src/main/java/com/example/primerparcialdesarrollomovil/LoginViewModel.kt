package com.example.primerparcialdesarrollomovil

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var username: String = ""
    var password: String = ""

    fun login(): Boolean{
        return username == "rgonzaleza" && password == "rgonzaleza"
    }
}