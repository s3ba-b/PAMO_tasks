package com.example.zadanie4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculateBmi(view: View) {
        val intent = Intent(this, BmiActivity::class.java)
        startActivity(intent)
    }

    fun showCasesChart(view: View) {
        val intent = Intent(this, CovidCasesChartActivity::class.java)
        startActivity(intent)
    }

    fun showRecoveryChart(view: View) {
        val intent = Intent(this, CovidRevoveryChartActivity::class.java)
        startActivity(intent)
    }

    fun showDeathsChart(view: View) {
        val intent = Intent(this, CovidDeathsChartActivity::class.java)
        startActivity(intent)
    }

    fun showQuiz(view: View) {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }
}