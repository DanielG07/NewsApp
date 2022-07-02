package com.danielg07.newsapp

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.danielg07.newsapp.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            verificarPermisos()
        }
    }

    private fun verificarPermisos() {
        val location = ContextCompat.checkSelfPermission(this,
            android.Manifest.permission.ACCESS_COARSE_LOCATION);

        if (location == PackageManager.PERMISSION_GRANTED) {
            val intent = Intent(this, NewsActivity::class.java)
            startActivity(intent)
        }
        else {
            requestPermissionLauncher.launch(android.Manifest.permission.ACCESS_COARSE_LOCATION)
        }
    }

    val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Snackbar.make(findViewById(R.id.error),
                    "Granted",
                    Snackbar.LENGTH_LONG).show()
            } else {
                binding.error.visibility = View.VISIBLE
                binding.button.visibility = View.GONE
            }
        }
}