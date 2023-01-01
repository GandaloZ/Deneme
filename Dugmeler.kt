package com.example.widgetlar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var imageButton : ImageButton
    lateinit var rgCinsiyet : RadioGroup
    lateinit var toggleButton : ToggleButton
    lateinit var switchInternet : Switch
    lateinit var floatingActionButton : FloatingActionButton
    lateinit var checkBoxC : CheckBox
    lateinit var checkBoxJava : CheckBox
    lateinit var checkBoxKotlin : CheckBox
    lateinit var chipOnay : Chip
    lateinit var chipEvet : Chip
    lateinit var chipHayir : Chip

    fun init(){
        imageButton = findViewById(R.id.imageButton)
        rgCinsiyet = findViewById(R.id.rgCinsiyet)
        toggleButton = findViewById(R.id.toggleButton)
        switchInternet = findViewById(R.id.switchInternet)
        floatingActionButton = findViewById(R.id.floatingActionButton)
        checkBoxC = findViewById(R.id.checkBoxC)
        checkBoxJava = findViewById(R.id.checkBoxJava)
        checkBoxKotlin = findViewById(R.id.checkBoxKotlin)
        chipOnay = findViewById(R.id.chipOnay)
        chipEvet = findViewById(R.id.chipEvet)
        chipHayir = findViewById(R.id.chipHayir)
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "On Start Calisti", Toast.LENGTH_LONG).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "On Create Calisti", Toast.LENGTH_LONG).show()
        init()

        imageButton.setOnClickListener(){
            Toast.makeText(this, "ImageButton'a basildi", Toast.LENGTH_LONG).show()
        }

        rgCinsiyet.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioButtonErkek)
                Toast.makeText(this, "Erkeksin", Toast.LENGTH_LONG).show()
            else
                Toast.makeText(this, "Kadinsin", Toast.LENGTH_LONG).show()
        }

        toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Secildi", Toast.LENGTH_LONG).show()
                buttonView.setBackgroundColor(Color.BLUE)
            } else {
                Toast.makeText(this, "Secilmedi", Toast.LENGTH_LONG).show()
                buttonView.setBackgroundColor(Color.RED)
            }
        }

        switchInternet.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, buttonView.text.toString() + " Secildi", Toast.LENGTH_LONG).show()
                buttonView.setBackgroundColor(Color.BLUE)
            } else {
                Toast.makeText(this, buttonView.text.toString() + " Secilmedi", Toast.LENGTH_LONG).show()
                buttonView.setBackgroundColor(Color.RED)
            }
        }

        floatingActionButton.setOnClickListener {
            finish()
            //System.exit(0)
        }

        checkBoxC.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, buttonView.text.toString() + " Secildi", Toast.LENGTH_LONG).show()
                buttonView.setBackgroundColor(Color.BLUE)
            } else {
                Toast.makeText(this, buttonView.text.toString() + " Secilmedi", Toast.LENGTH_LONG).show()
                buttonView.setBackgroundColor(Color.RED)
            }
        }

        checkBoxKotlin.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, buttonView.text.toString() + " Secildi", Toast.LENGTH_LONG).show()
                buttonView.setBackgroundColor(Color.BLUE)
            } else {
                Toast.makeText(this, buttonView.text.toString() + " Secilmedi", Toast.LENGTH_LONG).show()
                buttonView.setBackgroundColor(Color.RED)
            }
        }

        checkBoxJava.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                Toast.makeText(this, buttonView.text.toString() + " Secildi", Toast.LENGTH_LONG).show()
                buttonView.setBackgroundColor(Color.BLUE)
            } else {
                Toast.makeText(this, buttonView.text.toString() + " Secilmedi", Toast.LENGTH_LONG).show()
                buttonView.setBackgroundColor(Color.RED)
            }
        }

        chipOnay.setOnClickListener(){
            Toast.makeText(this, "Onaylandi", Toast.LENGTH_LONG).show()
        }

        chipEvet.setOnClickListener(){
            Toast.makeText(this, "Katiliyorum", Toast.LENGTH_LONG).show()
        }

        chipHayir.setOnClickListener(){
            Toast.makeText(this, "Katilmiyorum", Toast.LENGTH_LONG).show()
        }

    }
    //onCreate sonu.

    override fun onStop() {
        Toast.makeText(this, "On Stop Calisti", Toast.LENGTH_LONG).show()
        super.onStop()
    }

    override fun onDestroy() {
        Toast.makeText(this, "On Destroy Calisti", Toast.LENGTH_LONG).show()
        super.onDestroy()
    }

    override fun onBackPressed() {
        Toast.makeText(this, "On Backpressed Calisti", Toast.LENGTH_LONG).show()
        super.onBackPressed()
    }

}