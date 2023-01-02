package com.example.sonkiucdort

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SonucEkran : AppCompatActivity() {

    lateinit var tvGelenAd: TextView
    lateinit var tvGelenYas: TextView
    lateinit var tvGelenSonuc: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc_ekran)

        tvGelenAd = findViewById(R.id.tvGelenAd)
        tvGelenYas = findViewById(R.id.tvGelenYas)
        tvGelenSonuc = findViewById(R.id.tvGelenSonuc)

        val bundle: Bundle
        bundle = intent.extras!!

        val adi = bundle?.get("name")
        tvGelenAd.text = resources.getString(R.string.fName) + " " + adi.toString()

        val yas = bundle?.get("age")
        tvGelenYas.text = resources.getString(R.string.age) + " " + yas.toString()

        val sonuc = bundle?.get("result")
        tvGelenSonuc.text = resources.getString(R.string.result) + " " + sonuc.toString()


    }
}