package com.example.zadanie4

import android.R.layout
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class BmiActivity : AppCompatActivity() {

    private var gender: String = ""

    companion object {
        const val EXTRA_BMI = "com.example.myapplication.EXTRA_BMI"
        const val EXTRA_HB = "com.example.myapplication.EXTRA_HB"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
    }

    fun calculate(view: View) {
        val intent = Intent(this, DisplayResultActivity::class.java)

        val weightEditText = findViewById<View>(R.id.editTextNumberDecimal4) as EditText
        val weight = java.lang.Double.valueOf(weightEditText.text.toString())

        val heightEditText = findViewById<View>(R.id.editTextNumberDecimal5) as EditText
        val height = java.lang.Double.valueOf(heightEditText.text.toString())

        val ageEditText = findViewById<View>(R.id.editTextNumberDecimal6) as EditText
        val age = java.lang.Double.valueOf(ageEditText.text.toString())

        val bmi = weight / (height * height)

        val hb: Double = if (this.gender === "male") 66.47 + 13.7 * weight + 5.0 * (height * 100) - 6.76 * age else 655.1 + 9.567 * weight + 1.85 * (height * 100) - 4.68 * age

        intent.putExtra(EXTRA_BMI, bmi.toString())
        intent.putExtra(EXTRA_HB, hb.toString())

        startActivity(intent)
    }

    fun onCheckboxClicked(view: View) {
        val checked = (view as CheckBox).isChecked

        when (view.getId()) {
            R.id.checkBoxFemale -> if (checked) gender = "female"
            R.id.checkBoxMale -> if (checked) gender = "male"
        }
    }
}