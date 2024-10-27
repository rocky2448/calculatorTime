package com.example.calculatortime

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var toolbarMain: Toolbar
    private lateinit var firstOperandET: EditText
    private lateinit var secondOperandET: EditText
    private lateinit var buttonSummBTN: Button
    private lateinit var buttonDiffBTN: Button
    private lateinit var resultTV: TextView


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Калькулятор времени"
        toolbarMain.subtitle = "версия 1"
        toolbarMain.setLogo(R.drawable.ic_calculate)

        firstOperandET = findViewById(R.id.firstOperandET)
        secondOperandET = findViewById(R.id.secondOperandET)
        buttonSummBTN = findViewById(R.id.buttonSummBTN)
        buttonDiffBTN = findViewById(R.id.buttonDiffBTN)
        resultTV = findViewById(R.id.resultTV)


        buttonSummBTN.setOnClickListener(this)
        buttonDiffBTN.setOnClickListener(this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.resetMenuMain -> {
                firstOperandET.text.clear()
                secondOperandET.text.clear()
                resultTV.setTextColor(getResources().getColor(R.color.black))
                resultTV.text = "Результат"
                Toast.makeText(
                    applicationContext,
                    "Данные очищены",
                    Toast.LENGTH_LONG
                ).show()
            }

            R.id.exitMenuMain -> {
                finish()
                Toast.makeText(
                    applicationContext,
                    "Программа завершена",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(p0: View) {

        if (firstOperandET.text.isEmpty() || secondOperandET.text.isEmpty()) {
            return
        }
        val first = firstOperandET.text.toString()
        val second = secondOperandET.text.toString()
        val sum = Operation(first, second).sumFirstSecond()
        val diff = Operation(first, second).diffFirstSecond()
        val result = when (p0.id) {
            R.id.buttonSummBTN -> sum
            R.id.buttonDiffBTN -> diff
            else -> {
                0.0
            }
        }
        when (p0.id) {
            R.id.buttonSummBTN -> {
                Toast.makeText(
                    applicationContext,
                    "Результат: $sum",
                    Toast.LENGTH_LONG
                ).show()
                resultTV.setTextColor(getResources().getColor(R.color.textOutput))
            }

            R.id.buttonDiffBTN -> {
                Toast.makeText(
                    applicationContext,
                    "Результат: $diff",
                    Toast.LENGTH_LONG
                ).show()
                resultTV.setTextColor(getResources().getColor(R.color.textOutput))
            }
        }
        resultTV.text = result.toString()
    }
}