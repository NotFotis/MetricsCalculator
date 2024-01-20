package com.example.metricscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class DigitSpanActivityResults extends AppCompatActivity {

    private EditText presentedEditText;
    private EditText responseEditText;
    private EditText lengthEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digit_span_results);

        presentedEditText = findViewById(R.id.editTextPresented);
        responseEditText = findViewById(R.id.editTextResponse);
        lengthEditText = findViewById(R.id.editTextLength);

        Button calculateButton = findViewById(R.id.buttonCalculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        // Get values from EditText fields
        DatabaseHelper dbHelper = new DatabaseHelper(this);

        String presentedStr = presentedEditText.getText().toString();
        String responseStr = responseEditText.getText().toString();
        String lengthStr = lengthEditText.getText().toString();
        int results ;
        // Split the input strings based on spaces
        String[] presentedArray = presentedStr.split("\\s+");
        String[] responseArray = responseStr.split("\\s+");

        // Convert string arrays to integer arrays
        int[] presentedNumbers = Arrays.stream(presentedArray)
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] responseNumbers = Arrays.stream(responseArray)
                .mapToInt(Integer::parseInt)
                .toArray();

        // Check if the arrays are equal
        boolean areEqual = Arrays.equals(presentedNumbers, responseNumbers);
        results = areEqual ? 1 : 0;
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
        dbHelper.insertDigitSpanResult(userId,lengthStr,presentedStr,responseStr, results);
        Intent intent = new Intent(DigitSpanActivityResults.this, DigitSpanActivity.class);
        intent.putExtra("digitResult", results);
        startActivity(intent);
    }
}
