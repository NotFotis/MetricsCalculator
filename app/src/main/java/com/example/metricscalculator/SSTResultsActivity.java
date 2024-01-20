package com.example.metricscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SSTResultsActivity extends AppCompatActivity {
    private EditText numberEditText;
    private EditText ageEditText;
    private RadioGroup genderRadioGroup;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sstresults);

        numberEditText = findViewById(R.id.numberEditText);
        ageEditText = findViewById(R.id.ageEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        resultTextView = findViewById(R.id.resultTextView);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        String numberStr = numberEditText.getText().toString();
        String ageStr = ageEditText.getText().toString();

        if (numberStr.isEmpty() || ageStr.isEmpty()) {
            resultTextView.setText("Please enter both number and age.");
            return;
        }

        int number = Integer.parseInt(numberStr);
        int age = Integer.parseInt(ageStr);
        int genderId = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton genderRadioButton = findViewById(genderId);
        String gender = genderRadioButton.getText().toString();
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
        int result = calculateSSTResult(age, gender, number);

        dbHelper.insertResultSST(userId, age, number, gender, String.valueOf(result));
        Intent intent = new Intent(SSTResultsActivity.this, SSTResultsFull.class);
        intent.putExtra("sstResult", result);
        startActivity(intent);
    }

    private int calculateSSTResult(int age, String gender, int number) {
        int result;
        if (gender.equals("Woman")) {
            result = calculateWomenSSTResult(age, number);
        } else {
            result = calculateMenSSTResult(age, number);
        }
        return result;
    }

    private int calculateWomenSSTResult(int age, int number) {
        if (age >= 60 && age <= 64) {
            if (number < 12) return -1;
            if (number <= 17) return 0;
            return 1;
        } else if (age >= 65 && age <= 69) {
            if (number < 11) return -1;
            if (number <= 16) return 0;
            return 1;
        } else if (age >= 70 && age <= 74) {
            if (number < 10) return -1;
            if (number <= 15) return 0;
            return 1;
        } else if (age >= 75 && age <= 79) {
            if (number < 10) return -1;
            if (number <= 15) return 0;
            return 1;
        } else if (age >= 80 && age <= 84) {
            if (number < 9) return -1;
            if (number <= 14) return 0;
            return 1;
        } else if (age >= 85 && age <= 89) {
            if (number < 8) return -1;
            if (number <= 13) return 0;
            return 1;
        } else if (age >= 90 && age <= 94) {
            if (number < 4) return -1;
            if (number <= 11) return 0;
            return 1;
        } else {
            return -1;
        }
    }

    private int calculateMenSSTResult(int age, int number) {
        if (age >= 60 && age <= 64) {
            if (number < 14) return -1;
            if (number <= 19) return 0;
            return 1;
        } else if (age >= 65 && age <= 69) {
            if (number < 12) return -1;
            if (number <= 18) return 0;
            return 1;
        } else if (age >= 70 && age <= 74) {
            if (number < 12) return -1;
            if (number <= 17) return 0;
            return 1;
        } else if (age >= 75 && age <= 79) {
            if (number < 11) return -1;
            if (number <= 17) return 0;
            return 1;
        } else if (age >= 80 && age <= 84) {
            if (number < 10) return -1;
            if (number <= 15) return 0;
            return 1;
        } else if (age >= 85 && age <= 89) {
            if (number < 8) return -1;
            if (number <= 14) return 0;
            return 1;
        } else if (age >= 90 && age <= 94) {
            if (number < 7) return -1;
            if (number <= 12) return 0;
            return 1;
        } else {
            return 1;
        }
    }
}
