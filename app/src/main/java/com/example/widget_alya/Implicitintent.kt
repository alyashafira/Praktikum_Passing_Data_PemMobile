package com.example.widget_alya

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.example.widget_alya.databinding.ActivityImplicitintentBinding

//membuat variable binding
private lateinit var binding: ActivityImplicitintentBinding
class Implicitintent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inisialisasi binding
        binding = ActivityImplicitintentBinding.inflate(layoutInflater)
        //memanggil layout dengan binding.root
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= 23){
            if (checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions( this, arrayOf(android.Manifest.permission.CAMERA,
                android.Manifest.permission.READ_EXTERNAL_STORAGE),1)
            }
        }
        binding.btncamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
        binding.btnfile.setOnClickListener {
            val intent = Intent()
            intent.type="*/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent,"Pilih File"),0)
        }
        binding.btnbrowser.setOnClickListener {
            val url = "https://google.com"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse(url))
            startActivity(intent)
        }
    }

    private fun startActivities(intent: Intent) {

    }
}