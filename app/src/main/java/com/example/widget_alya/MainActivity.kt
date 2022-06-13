package com.example.widget_alya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.widget_alya.databinding.ActivityMainBinding

//membuat variable binding
private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi binding
        binding= ActivityMainBinding.inflate(layoutInflater)
        //Memanggil layout dengan menggunakkan binding.root
        setContentView(binding.root)

        //Explicit intent memanggil Activity di project yang sama
        binding.btnWidget.setOnClickListener {
            val intent = Intent( this,widget::class.java)
            startActivity(intent)
        }
        binding.btnIntentExplicit.setOnClickListener {
            val intent = Intent( this,Implicitintent::class.java)
            startActivity(intent)
    }



    }
}