package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateBmi(View view) {
        Intent intent = new Intent(this, BmiActivity.class);
        startActivity(intent);
    }

    public void showCasesChart(View view) {
        Intent intent = new Intent(this, CovidCasesChartActivity.class);
        startActivity(intent);
    }

    public void showRecoveryChart(View view) {
        Intent intent = new Intent(this, CovidRevoveryChartActivity.class);
        startActivity(intent);
    }

    public void showDeathsChart(View view) {
        Intent intent = new Intent(this, CovidDeathsChartActivity.class);
        startActivity(intent);
    }

    public void showQuiz(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}