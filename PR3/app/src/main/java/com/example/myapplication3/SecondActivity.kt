package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btnBack = findViewById<Button>(R.id.btn_back)
        val btnNext = findViewById<Button>(R.id.btn_next)

        btnBack.setOnClickListener {
            finish()
        }

        btnNext.setOnClickListener {
            val selectedId = radioGroup.checkedRadioButtonId
            if (selectedId != -1) {
                val radioButton = findViewById<RadioButton>(selectedId)
                val choice = if (radioButton.id == R.id.radio_pen) "Ручка" else "Карандаш"
                
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("CHOICE", choice)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Пожалуйста, выберите вариант", Toast.LENGTH_SHORT).show()
            }
        }
    }
}