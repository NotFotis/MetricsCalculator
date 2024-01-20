package com.example.metricscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SubstitutionActivityResults extends AppCompatActivity {

    private EditText correctEditText;
    private EditText responseTimeEditText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substitution_results);

        correctEditText = findViewById(R.id.correctEditText);
        responseTimeEditText = findViewById(R.id.responseTimeEditText);
        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResults();
            }
        });
    }

    private void calculateResults() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        int correct = Integer.parseInt(correctEditText.getText().toString());
        double responseTime = Double.parseDouble(responseTimeEditText.getText().toString());
        // Add your calculation logic here
        // You can get values from correctEditText and responseTimeEditText
        // Perform calculations and update UI or database as needed
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
        dbHelper.insertSubstitutionResult(userId, correct , responseTime );
        Intent intent = new Intent(SubstitutionActivityResults.this, SubstitutionActivity.class);
        startActivity(intent);
    }
}
