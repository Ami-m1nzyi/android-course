package com.example.myapplication2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var inputA: EditText
    private lateinit var inputB: EditText
    private lateinit var inputX: EditText
    private lateinit var solveButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputA = findViewById(R.id.input_a)
        inputB = findViewById(R.id.input_b)
        inputX = findViewById(R.id.input_x)
        solveButton = findViewById(R.id.solve_button)
        resultText = findViewById(R.id.result_text)

        solveButton.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val a = inputA.text.toString()
                val b = inputB.text.toString()
                val x = inputX.text.toString()
                solveButton.isEnabled = a.isNotEmpty() && b.isNotEmpty() && x.isNotEmpty()
            }
            override fun afterTextChanged(s: Editable?) {}
        }

        inputA.addTextChangedListener(textWatcher)
        inputB.addTextChangedListener(textWatcher)
        inputX.addTextChangedListener(textWatcher)

        solveButton.setOnClickListener {
            calculate()
        }
        
        if (savedInstanceState != null) {
            resultText.text = savedInstanceState.getString("result", "Ответ")
        }
    }

    private fun calculate() {
        val a = inputA.text.toString().toDoubleOrNull() ?: 0.0
        val b = inputB.text.toString().toDoubleOrNull() ?: 0.0
        val x = inputX.text.toString().toDoubleOrNull() ?: 0.0

        val y = if (x <= 7) {
            val denominator = a.pow(2) + b.pow(2)
            if (denominator != 0.0) {
                (x + 4) / denominator
            } else {
                null
            }
        } else {
            x * (a + b).pow(2)
        }

        resultText.text = if (y != null) {
            String.format(Locale.US, "%.4f", y)
        } else {
            "Ошибка: деление на 0"
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("result", resultText.text.toString())
    }
}
