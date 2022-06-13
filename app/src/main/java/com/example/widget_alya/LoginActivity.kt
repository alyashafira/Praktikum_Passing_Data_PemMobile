package com.example.widget_alya

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.widget_alya.databinding.ActivityLoginBinding


private lateinit var binding : ActivityLoginBinding
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi Binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        //Memanggil Layout dengan binding.root
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {

            val dataLogin = ModelLogin(binding.txtUser.text.toString(),binding.txtPass.toString())
            val Intent = Intent(this,MainActivity ::class.java)
            Intent.putExtra("data",dataLogin)
            startActivity(Intent)
            finish()
        }


    }
}