package com.example.tugas_tiket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatDelegate
import com.example.tugas_tiket.databinding.ActivityMainBinding
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var provinces: Array<String>
    private lateinit var spinner: Spinner
    private lateinit var textView: TextView
    private val jenisTiket = arrayOf(
        "Ekonomi",
        "Bisnis",
        "Eksekutif",
        "First-Class"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        // Menonaktifkan night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(binding.root)

        spinner = findViewById(R.id.spinnerJenisTiket)
        textView = findViewById(R.id.judul2)

        provinces = resources.getStringArray(R.array.provinces)
        with(binding) {
            // mengatur agar dropdown bisa di klik
            val adapterJenisTiket =
                ArrayAdapter(this@MainActivity, com.google.android.material.R.layout.support_simple_spinner_dropdown_item, jenisTiket)
            adapterJenisTiket.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerJenisTiket.adapter = adapterJenisTiket

            // ini biar toolbar nampilin juga yang dipilih di dropdown
            spinnerJenisTiket.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parentView: AdapterView<*>?,
                    selectedItemView: View?,
                    position: Int,
                    id: Long) {
                    // Ambil teks yang dipilih dari Spinner
                    val selectedItem = spinnerJenisTiket.selectedItem.toString()

                    // tampilkan teks yang dipilih ke TextView
                    textView.text = selectedItem
                 }

                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    // ini kosong cuma buat nglengkapin onItemSelected
                    }
                }

            btnPesan.setOnClickListener {
                // mengatur date picker tahun bulan hari
                val tahun: Int = datePicker.year
                val bulan: Int = datePicker.month
                val hari: Int = datePicker.dayOfMonth

                // mengatur time picker jam dan menit
                val jam: Int = timePicker.hour
                val menit: Int = timePicker.minute
                val amPm: String = if (jam < 12) {
                    "AM"
                } else {
                    "PM"
                }

                // mengatur calendar
                val calendar = Calendar.getInstance()
                calendar.set(tahun,bulan,hari,jam,menit)


                // mengatur toast
                val selectedItem = spinnerJenisTiket.selectedItem.toString()
                val message:String = "Jenis Tiket = " + selectedItem + ",\n" +
                    "Waktu= " + "$tahun/$bulan/$hari $jam:$menit WIB"

                Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
            }
        }
    }
}