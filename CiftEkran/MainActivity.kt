package com.example.sonkiucdort

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import org.w3c.dom.Text
import java.util.Calendar

class MainActivity : AppCompatActivity() {

    lateinit var tvAdi: TextView
    lateinit var etAdi: EditText
    lateinit var tvSay1: TextView
    lateinit var etSay1: EditText
    lateinit var tvSay2: TextView
    lateinit var etSay2: EditText
    lateinit var rgIslem: RadioGroup
    lateinit var tvSonuc: TextView
    lateinit var dpYas: DatePicker
    lateinit var tvYas: TextView
    lateinit var btnGonder: Button

    fun init(){
        tvAdi = findViewById(R.id.tvAdi)
        etAdi = findViewById(R.id.etAdi)
        tvSay1 = findViewById(R.id.tvSay1)
        etSay1 = findViewById(R.id.etSay1)
        tvSay2 = findViewById(R.id.tvSay2)
        etSay2 = findViewById(R.id.etSay2)
        rgIslem = findViewById(R.id.rgIslem)
        tvSonuc = findViewById(R.id.tvSonuc)
        dpYas = findViewById(R.id.dpYas)
        tvYas = findViewById(R.id.tvYas)
        btnGonder = findViewById(R.id.btnGonder)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        var adi = ""
        var s1 = 0
        var s2 = 0
        var yas = 0
        var sonuc = 0
        val textSonuc = resources.getString(R.string.result)
        val textYas = resources.getString(R.string.age)
        val date = Calendar.getInstance()

        btnGonder.setOnClickListener {
            intent = Intent(this, SonucEkran::class.java)
            adi = etAdi.text.toString()
            intent.putExtra("name", adi)
            intent.putExtra("result", sonuc)
            intent.putExtra("age", yas)
            startActivity(intent)
        }

        rgIslem.setOnCheckedChangeListener { radioGroup, i ->
            if (i == R.id.rbTopla){
                s1 = etSay1.text.toString().toInt()
                s2 = etSay2.text.toString().toInt()
                sonuc = s1 + s2
                tvSonuc.text = textSonuc + " " + sonuc.toString()
            }
            else if (i == R.id.rbCikart){
                s1 = etSay1.text.toString().toInt()
                s2 = etSay2.text.toString().toInt()
                sonuc = s1 - s2
                tvSonuc.text = textSonuc + " " + sonuc.toString()
            }
            else if (i == R.id.rbCarp){
                s1 = etSay1.text.toString().toInt()
                s2 = etSay2.text.toString().toInt()
                sonuc = s1 * s2
                tvSonuc.text = textSonuc + " " + sonuc.toString()
            }
            else if (i == R.id.rbBol){
                s1 = etSay1.text.toString().toInt()
                s2 = etSay2.text.toString().toInt()
                sonuc = s1 / s2
                tvSonuc.text = textSonuc + " " + sonuc.toString()
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            dpYas.setOnDateChangedListener { datePicker, i, i2, i3 ->
                yas = date.get(Calendar.YEAR) - i
                tvYas.text = textYas + " " + yas
            }
        }

    }
}