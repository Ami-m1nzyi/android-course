package com.example.myapplication3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val choice = intent.getStringExtra("CHOICE")
        val etReason = findViewById<EditText>(R.id.et_reason)
        val btnBack = findViewById<Button>(R.id.btn_back)
        val btnNext = findViewById<Button>(R.id.btn_next)

        btnBack.setOnClickListener {
            finish()
        }

        btnNext.setOnClickListener {
            val reason = etReason.text.toString()
            if (reason.isNotBlank()) {
                val intent = Intent(this, FourthActivity::class.java)
                intent.putExtra("CHOICE", choice)
                intent.putExtra("REASON", reason)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Пожалуйста, введите причину", Toast.LENGTH_SHORT).show()
            }
        }
    }
}