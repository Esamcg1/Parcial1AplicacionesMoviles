package com.example.primerparcialdesarrollomovil

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.primerparcialdesarrollomovil.UserInfo.User
import com.example.primerparcialdesarrollomovil.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.loginButton.setOnClickListener {
            if (viewModel.login()) {
                val userInfo = User("rgonzaleza", "rgonzaleza@gmail.com", "rgonzalesa", "123456789", 30)
                val intent = Intent(this, User::class.java)
                intent.putExtra("user", User)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Fallo se sesion :(", Toast.LENGTH_SHORT).show()
            }
        }
    }
}