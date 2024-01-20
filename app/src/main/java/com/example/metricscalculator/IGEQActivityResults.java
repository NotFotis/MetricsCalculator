package com.example.metricscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IGEQActivityResults extends AppCompatActivity {

    private EditText[] itemEditTexts;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igeqresults);

        // Initialize EditText fields for each item
        itemEditTexts = new EditText[14];
        for (int i = 0; i < 14; i++) {
            int editTextId = getResources().getIdentifier("editTextItem" + (i + 1), "id", getPackageName());
            itemEditTexts[i] = findViewById(editTextId);
        }

        // Initialize the Calculate button
        calculateButton = findViewById(R.id.buttonCalculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAverages();
            }
        });
    }

    private void calculateAverages() {

        try {
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            // Get input values from EditText fields for each item
            int[] competenceItems = {1, 8}; // Items 2 and 9
            int[] sensoryItems = {0, 3}; // Items 1 and 4
            int[] flowItems = {4, 9}; // Items 5 and 10
            int[] tensionItems = {5, 7}; // Items 6 and 8
            int[] challengeItems = {11, 12}; // Items 12 and 13
            int[] negativeAffectItems = {2, 6}; // Items 3 and 7
            int[] positiveAffectItems = {10, 13}; // Items 11 and 14

            // Calculate averages for each category
            double competenceAverage = calculateAverage(competenceItems);
            double sensoryAverage = calculateAverage(sensoryItems);
            double flowAverage = calculateAverage(flowItems);
            double tensionAverage = calculateAverage(tensionItems);
            double challengeAverage = calculateAverage(challengeItems);
            double negativeAffectAverage = calculateAverage(negativeAffectItems);
            double positiveAffectAverage = calculateAverage(positiveAffectItems);

            UserDataManager userDataManager = UserDataManager.getInstance();
            int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
            dbHelper.insertIGEQResult(userId, competenceAverage, sensoryAverage,flowAverage,tensionAverage,challengeAverage, negativeAffectAverage, positiveAffectAverage);
            Intent intent = new Intent(IGEQActivityResults.this, IGEQActivity.class);
            startActivity(intent);
            // Display averages (you can modify this part based on your needs)
            String resultMessage = "Competence Average: " + competenceAverage +
                    "\nSensory Average: " + sensoryAverage +
                    "\nFlow Average: " + flowAverage +
                    "\nTension Average: " + tensionAverage +
                    "\nChallenge Average: " + challengeAverage +
                    "\nNegative Affect Average: " + negativeAffectAverage +
                    "\nPositive Affect Average: " + positiveAffectAverage;

            Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numeric values", Toast.LENGTH_SHORT).show();
        }
    }

    private double calculateAverage(int[] items) {
        // Calculate average for a set of items
        double sum = 0;

        for (int item : items) {
            sum += Double.parseDouble(itemEditTexts[item].getText().toString());
        }

        return sum / items.length;
    }
}
