package com.example.metricscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TrialActivityResults extends AppCompatActivity {

    private EditText etPartATime;
    private EditText etPartBTime;
    private EditText etAge;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial_results);

        etPartATime = findViewById(R.id.etPartATime);
        etPartBTime = findViewById(R.id.etPartBTime);
        etAge = findViewById(R.id.etAge);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> calculateResults());
    }

    private void calculateResults() {
        try {
            String result;
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            int partATime = Integer.parseInt(etPartATime.getText().toString());
            int partBTime = Integer.parseInt(etPartBTime.getText().toString());
            int age = Integer.parseInt(etAge.getText().toString());

            boolean isPartAWithinLimits = checkPartATime(partATime, age);
            boolean isPartBWithinLimits = checkPartBTime(partBTime, age);

            if (isPartAWithinLimits && isPartBWithinLimits) {
                result = "Μέση Απόδοση";
            } else {
                result = "Ελλιπής απόδοση";
            }
            UserDataManager userDataManager = UserDataManager.getInstance();
            int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
            dbHelper.insertTrailResult(userId, partATime, partBTime,age,result);
            Intent intent = new Intent(TrialActivityResults.this, TrialActivity.class);
            intent.putExtra("trailResult", result);
            startActivity(intent);
        } catch (NumberFormatException e) {
            showToast("Εισαγάγετε έγκυρες αριθμητικές τιμές.");
        }
    }

    private boolean checkPartATime(int partATime, int age) {
        if (age >= 55 && age <= 75) {
            return partATime <= 42;
        } else if (age > 75 && age <= 98) {
            return partATime <= 51;
        } else {
            // For users smaller than 55
            return partATime <= 29;
        }
    }

    private boolean checkPartBTime(int partBTime, int age) {
        if (age >= 55 && age <= 75) {
            return partBTime <= 101;
        } else if (age > 75 && age <= 98) {
            return partBTime <= 128;
        } else {
            // For users smaller than 55
            return partBTime <= 75;
        }
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
