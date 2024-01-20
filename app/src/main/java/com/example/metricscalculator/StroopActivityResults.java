package com.example.metricscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class StroopActivityResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroop_results);

        EditText editTextCongruent = findViewById(R.id.editTextCongruent);
        EditText editTextIncongruent = findViewById(R.id.editTextIncongruent);
        Button buttonCalculateStroop = findViewById(R.id.buttonCalculateStroop);
        TextView textViewStroopResult = findViewById(R.id.textViewStroopResult);

        buttonCalculateStroop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateStroopEffect(editTextCongruent, editTextIncongruent, textViewStroopResult);
            }
        });
    }

    private void calculateStroopEffect(EditText editTextCongruent, EditText editTextIncongruent, TextView textViewStroopResult) {
        try {
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            double congruentTime = Double.parseDouble(editTextCongruent.getText().toString());
            double incongruentTime = Double.parseDouble(editTextIncongruent.getText().toString());

            // Calculate Stroop effect: Congruent Time - Incongruent Time
            double stroopEffect = congruentTime - incongruentTime;
            UserDataManager userDataManager = UserDataManager.getInstance();
            int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
            dbHelper.insertStroopResult(userId, congruentTime, incongruentTime, stroopEffect);
            Intent intent = new Intent(StroopActivityResults.this, StroopActivity.class);
            intent.putExtra("στροοπResult", stroopEffect);
            startActivity(intent);
            // Display the result
            textViewStroopResult.setText("Stroop Effect: " + stroopEffect + " ms");

        } catch (NumberFormatException e) {
            // Handle the case where the user enters invalid input
            textViewStroopResult.setText("Μη έγκυρη εισαγωγή. Εισαγάγετε έγκυρες ώρες.");
        }
    }
}
