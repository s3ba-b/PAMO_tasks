// Autor: Sebastian Bobrowski, s17603@pjwstk.edu.pl

package com.example.bmi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText weight;
    EditText height;
    TextView bmi;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = findViewById(R.id.weight_field);
        height = findViewById(R.id.height_field);
        bmi = findViewById(R.id.bmi_field);
        button = findViewById(R.id.calculate_button);

        weight.setText("0");
        height.setText("0");
        bmi.setText("0");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText _weight = findViewById(R.id.weight_field);
                EditText _height = findViewById(R.id.height_field);
                TextView _bmi = findViewById(R.id.bmi_field);

                double weight = Double.parseDouble(String.valueOf(_weight.getText()));
                double height = Double.parseDouble(String.valueOf(_height.getText()));

                if(weight != 0 && height != 0) {
                    _bmi.setText(String.valueOf(Math.round(weight / Math.sqrt(height))));
                }
            }
        });
    }
}