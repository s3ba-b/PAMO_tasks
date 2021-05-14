package com.example.zadanie4

import android.R.layout
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry


class CovidDeathsChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_deaths_chart)

        val pie = AnyChart.pie()

        val data: MutableList<DataEntry> = ArrayList()
        data.add(ValueDataEntry("Poland", 62734))
        data.add(ValueDataEntry("USA", 568000))
        data.add(ValueDataEntry("India", 183000))
        data.add(ValueDataEntry("Brazil", 378000))
        data.add(ValueDataEntry("France", 102000))

        pie.data(data)

        val anyChartView = findViewById<View>(R.id.any_chart_view) as AnyChartView
        anyChartView.setChart(pie)
    }
}