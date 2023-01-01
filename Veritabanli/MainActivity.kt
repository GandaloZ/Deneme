package com.example.menuluveritabanlibasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var etAd: EditText
    lateinit var etVize: EditText
    lateinit var etFinal: EditText
    lateinit var lvVeriler: ListView
    lateinit var textView: TextView
    var kisiId = 0
    val vt = veritabani(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("NOTLARIN MUQ")

        etAd = findViewById(R.id.etAd)
        etVize = findViewById(R.id.etVize)
        etFinal = findViewById(R.id.etFinal)
        lvVeriler = findViewById(R.id.lvVeriler)
        textView = findViewById(R.id.textView)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }
    //https://www.javatpoint.com/kotlin-android-context-menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.ekleme -> {
                var ad = etAd.text.toString()
                var vize = etVize.text.toString().toInt()
                var final = etFinal.text.toString().toInt()
                var basari = (vize*0.4) + (final*0.6)

                vt.ekle(ad, vize, final, basari.roundToInt())
                Toast.makeText(this, "Veri Eklendi", Toast.LENGTH_SHORT).show()
                temizle()
                listele()
                true
            }
            R.id.silme -> {
                vt.sil(kisiId)
                Toast.makeText(this, "Veri Silindi", Toast.LENGTH_SHORT).show()
                temizle()
                listele()
                return true
            }
            R.id.guncelle -> {
                var ad = etAd.text.toString()
                var vize = etVize.text.toString().toInt()
                var final = etFinal.text.toString().toInt()
                var basari = (vize*0.4) + (final*0.6)

                vt.guncelle(kisiId, ad, vize, final, basari.roundToInt())
                Toast.makeText(this, "Veri Guncellendi", Toast.LENGTH_SHORT).show()
                temizle()
                listele()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun temizle(){
        etAd.text.clear()
        etVize.text.clear()
        etFinal.text.clear()
    }

    fun listele(){
        var liste = vt.listele()

        lvVeriler.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, liste)

        lvVeriler.setOnItemClickListener { adapterView, view, i, l ->
            var secilen = lvVeriler.getItemAtPosition(i).toString()
            var bolunen = secilen.split(" - ")

            kisiId = bolunen[0].toInt()
            etAd.setText(bolunen[1])
            etVize.setText(bolunen[2])
            etFinal.setText(bolunen[3])
            textView.setText("BASARI NOTU: " + bolunen[4])
        }
    }

}