package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        Intent intent = getIntent();

        String bmi = intent.getStringExtra(BmiActivity.EXTRA_BMI);
        String hb = intent.getStringExtra(BmiActivity.EXTRA_HB);

        TextView textView1 = findViewById(R.id.textView6);
        textView1.setText(bmi);

        TextView textView2 = findViewById(R.id.textView8);
        textView2.setText(hb);

        TextView textView3 = findViewById(R.id.textView10);

        if(Double.valueOf(bmi) <= 18.49) {
            textView3.setText("Egg-fried rice");
        } else if(Double.valueOf(bmi) <= 24.99) {
            textView3.setText("Pizza");
        } else if(Double.valueOf(bmi) <= 29.99) {
            textView3.setText("Summer Asian Slaw");
        } else if(Double.valueOf(bmi) >= 25.0) {
            textView3.setText("Best Broccoli Salad");
        }

    }
}