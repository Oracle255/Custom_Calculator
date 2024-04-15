package com.example.custom_calculator.FrontEnd.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.custom_calculator.R
import com.example.custom_calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        binding.btnPageDownloadCalculator.setOnClickListener {
            val intent = Intent(this, DownloadCalculatorActivity::class.java)
            startActivity(intent)
        }
    }
}