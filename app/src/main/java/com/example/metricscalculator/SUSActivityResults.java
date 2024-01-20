package com.example.metricscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SUSActivityResults extends AppCompatActivity {
    DatabaseHelper dbHelper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_susresults);

        // Assuming you have an EditText in your layout with the id 'scoreEditText'
        EditText scoreEditText = findViewById(R.id.scoreEditText);

        // Assuming you have a Button in your layout with the id 'calculateButton'
        Button calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input from the EditText
                String scoreString = scoreEditText.getText().toString();

                if (!scoreString.isEmpty()) {
                    // Convert the input to a numeric value (assuming it's a valid number)
                    int score = Integer.parseInt(scoreString);

                    // Multiply the score by 2.5
                    double multipliedScore = score * 2.5;

                    // Determine whether the result is above or below average
                    String resultMessage;
                    if (multipliedScore > 68) {
                        resultMessage = "Ανω του μέσω όρου!";
                    } else {
                        resultMessage = "Κάτω του μέσω όρου!";
                    }
                    UserDataManager userDataManager = UserDataManager.getInstance();
                    int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
                    dbHelper.insertSUSResult(userId, score, multipliedScore,resultMessage);
                    Intent intent = new Intent(SUSActivityResults.this, SUSActivity.class);
                    intent.putExtra("susResult", resultMessage);
                    startActivity(intent);
                    // You can display the result message as needed, e.g., using a TextView
                    TextView resultTextView = findViewById(R.id.resultTextView);
                    resultTextView.setText("Your adjusted score: " + multipliedScore + "\nResult: " + resultMessage);
                } else {
                    // Handle the case where the input is empty
                    Toast.makeText(SUSActivityResults.this, "Παρακαλώ πληκτρολογήστε το σκορ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
