package com.example.myapplication3

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FourthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        val choice = intent.getStringExtra("CHOICE")
        val reason = intent.getStringExtra("REASON")

        val tvChoice = findViewById<TextView>(R.id.tv_result_choice)
        val tvReason = findViewById<TextView>(R.id.tv_result_reason)
        val btnBack = findViewById<Button>(R.id.btn_back)
        val btnExit = findViewById<Button>(R.id.btn_exit)

        tvChoice.text = "Вы выбрали: $choice"
        tvReason.text = "Причина: $reason"

        btnBack.setOnClickListener {
            finish()
        }

        btnExit.setOnClickListener {
            finishAffinity()
        }
    }
}