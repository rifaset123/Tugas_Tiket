package com.example.tugas_tiket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.example.tugas_tiket.databinding.ActivityToolbarTiketBinding

class toolbar_tiket : AppCompatActivity() {
    private lateinit var binding: ActivityToolbarTiketBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)  // untuk memaksa light mode
        binding = ActivityToolbarTiketBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val selectedItem = intent.getStringExtra("selectedItem")

        with(binding){
            judul2.text = selectedItem
        }
    }
}