package com.example.calculatortime

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText
    private lateinit var buttonSummBTN: Button
    private lateinit var buttonDiffBTN: Button
    private lateinit var resultTV: TextView
    private lateinit var buttonResetBTN: Button
    private lateinit var buttonExitBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)
        buttonSummBTN = findViewById(R.id.buttonSummBTN)
        buttonDiffBTN = findViewById(R.id.buttonDiffBTN)
        resultTV = findViewById(R.id.resultTV)
        buttonResetBTN = findViewById(R.id.buttonResetBTN)
        buttonExitBTN = findViewById(R.id.buttonExitBTN)

        buttonSummBTN.setOnClickListener(this)
        buttonDiffBTN.setOnClickListener(this)
        buttonResetBTN.setOnClickListener(this)
        buttonExitBTN.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        var check = true
        if (p0.id == R.id.buttonExitBTN) finish()
        if (firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) {
            return
        }
        val first = firstOperandET.text.toString()
        val second = secondOperandET.text.toString()

        val result = when(p0.id) {
            R.id.buttonSummBTN -> Operation(first, second).sumFirstSecond()
            R.id.buttonDiffBTN -> Operation(first, second).diffFirstSecond()
            R.id.buttonResetBTN -> {
                firstOperandET.text.clear()
                secondOperandET.text.clear()
                check = false
            }
            else -> 0.0
        }
        if (!check) resultTV.text = "Результат" else resultTV.text = result.toString()
    }
}