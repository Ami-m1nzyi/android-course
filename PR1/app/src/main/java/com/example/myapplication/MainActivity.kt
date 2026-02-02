package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editX = findViewById<EditText>(R.id.editX)
        val editA = findViewById<EditText>(R.id.editA)
        val editB = findViewById<EditText>(R.id.editB)
        val btnSolve = findViewById<Button>(R.id.btnSolve)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnSolve.setOnClickListener {
            val xStr = editX.text.toString()
            val aStr = editA.text.toString()
            val bStr = editB.text.toString()

            if (xStr.isEmpty() || aStr.isEmpty() || bStr.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val x = xStr.toDouble()
            val a = aStr.toDouble()
            val b = bStr.toDouble()
            val y: Double

            if (x <= 7) {
                val denominator = a.pow(2) + b.pow(2)
                if (denominator == 0.0) {
                    txtResult.text = "Ошибка: деление на ноль (a^2 + b^2 = 0)"
                    return@setOnClickListener
                }
                y = (x + 4) / denominator
            } else {
                y = x * (a + b).pow(2)
            }

            txtResult.text = "Ответ: $y"
        }
    }
}