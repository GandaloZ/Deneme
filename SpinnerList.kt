package com.topcubasi.listespinner

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    lateinit var lvAd: ListView
    lateinit var tvAd: TextView
    lateinit var spnRenkler: Spinner
    lateinit var tvRenkler: TextView
    lateinit var ekran:ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adlar = resources.getStringArray(R.array.adlar)
        val renkler = resources.getStringArray(R.array.renkler)
        lvAd = findViewById(R.id.lvAd)
        tvAd = findViewById(R.id.tvIsim)
        tvRenkler = findViewById(R.id.tvRenk)
        spnRenkler = findViewById(R.id.spnRenkler)
        ekran=findViewById(R.id.ekran)
        val adAdapter=ArrayAdapter(this,R.layout.liste_goruntu,adlar)
        lvAd.adapter=adAdapter
        lvAd.setOnItemClickListener { adapterView, view, i, l ->
            tvAd.text = resources.getString(R.string.secilenIsim) + adlar[i]

        }//liste tıklama sonu
        spnRenkler.onItemSelectedListener=object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                tvRenkler.text = resources.getString(R.string.secilenRenk) + renkler[p2]
                when(p2) {
                    0->ekran.setBackgroundColor(Color.RED)
                    1->ekran.setBackgroundColor(Color.GREEN)
                    2->ekran.setBackgroundColor(Color.BLUE)
                    3->ekran.setBackgroundColor(Color.GRAY)
                    4->ekran.setBackgroundColor(Color.YELLOW)
                }
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spnRenkler.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                TODO("Not yet implemented")
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}