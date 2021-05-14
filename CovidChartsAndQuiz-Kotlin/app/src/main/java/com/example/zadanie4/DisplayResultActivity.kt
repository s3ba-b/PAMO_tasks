package com.example.zadanie4

import android.R.layout
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DisplayResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_result)

        val intent = intent

        val bmi = intent.getStringExtra(BmiActivity.EXTRA_BMI)
        val hb = intent.getStringExtra(BmiActivity.EXTRA_HB)

        val textView1 = findViewById<TextView>(R.id.textView6)
        textView1.text = bmi

        val textView2 = findViewById<TextView>(R.id.textView8)
        textView2.text = hb

        val textView3 = findViewById<TextView>(R.id.textView10)

        when {
            java.lang.Double.valueOf(bmi) <= 18.49 -> {
                textView3.text = "Egg-fried rice"
            }
            java.lang.Double.valueOf(bmi) <= 24.99 -> {
                textView3.text = "Pizza"
            }
            java.lang.Double.valueOf(bmi) <= 29.99 -> {
                textView3.text = "Summer Asian Slaw"
            }
            java.lang.Double.valueOf(bmi) >= 25.0 -> {
                textView3.text = "Best Broccoli Salad"
            }
        }
    }
}