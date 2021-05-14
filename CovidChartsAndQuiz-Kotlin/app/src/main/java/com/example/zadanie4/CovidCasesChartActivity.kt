package com.example.zadanie4

import android.R.layout

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class CovidCasesChartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_cases_chart)

        val pie: Pie = AnyChart.pie()

        val data: MutableList<DataEntry> = ArrayList()
        data.add(ValueDataEntry("Poland", 2.7))
        data.add(ValueDataEntry("USA", 31.8))
        data.add(ValueDataEntry("India", 15.6))
        data.add(ValueDataEntry("Brazil", 14))
        data.add(ValueDataEntry("France", 5.37))

        pie.data(data)

        val anyChartView: AnyChartView = findViewById<View>(R.id.any_chart_view) as AnyChartView
        anyChartView.setChart(pie)
    }
}