package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class BmiActivity extends AppCompatActivity {

    public static final String EXTRA_BMI = "com.example.myapplication.EXTRA_BMI";
    public static final String EXTRA_HB = "com.example.myapplication.EXTRA_HB";
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi2);
    }

    public void calculate(View view) {

        Intent intent = new Intent(this, DisplayResultActivity.class);

        EditText weightEditText = (EditText) findViewById(R.id.editTextNumberDecimal4);
        Double weight = Double.valueOf(weightEditText.getText().toString());

        EditText heightEditText = (EditText) findViewById(R.id.editTextNumberDecimal5);
        Double height = Double.valueOf(heightEditText.getText().toString());

        EditText ageEditText = (EditText) findViewById(R.id.editTextNumberDecimal6);
        Double age = Double.valueOf(ageEditText.getText().toString());

        Double bmi = weight/(height*height);

        Double hb;

        if(this.gender == "male")
            hb = 66.47 + (13.7 * weight) + (5.0 * (height * 100)) - (6.76 * age);
        else
            hb = 655.1 + (9.567 * weight) + (1.85 * (height * 100)) - (4.68 * age);

        intent.putExtra(EXTRA_BMI, String.valueOf(bmi));
        intent.putExtra(EXTRA_HB, String.valueOf(hb));

        startActivity(intent);

    }

    public void onCheckboxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkBoxFemale:
                if (checked)
                    this.gender = "female";
                break;
            case R.id.checkBoxMale:
                if (checked)
                    this.gender = "male";
                break;
        }

    }
}