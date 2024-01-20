package com.example.metricscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CSRTActivityResults extends AppCompatActivity {

    private Button calculateButton;
    private EditText ageEditText;
    private EditText reactionTimeEditText;
    private Spinner genderSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csrtresults);

        // Initialize UI elements
        calculateButton = findViewById(R.id.calculateButton);
        ageEditText = findViewById(R.id.ageEditText);
        reactionTimeEditText = findViewById(R.id.reactionTimeEditText);
        genderSpinner = findViewById(R.id.genderSpinner);

        // Set click listener for the Calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCSRTResults();
            }
        });

        // Additional code for other UI elements and functionalities
    }

    // Add the method to handle the Calculate button click event
    private void calculateCSRTResults() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        // Retrieve user inputs
        String gender = genderSpinner.getSelectedItem().toString();
        int age = Integer.parseInt(ageEditText.getText().toString());
        double reactionTime = Double.parseDouble(reactionTimeEditText.getText().toString());
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
        dbHelper.insertCSRTResult(userId, gender , age , reactionTime);
        Intent intent = new Intent(CSRTActivityResults.this, CSRTActivity.class);
        startActivity(intent);
        // Perform calculations or any other necessary logic
        // Update the UI or database with the results as needed
    }
}
