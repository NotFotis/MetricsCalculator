package com.example.metricscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TUGActivityResults extends AppCompatActivity {

    private EditText timeEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tugresults);

        timeEditText = findViewById(R.id.timeEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResults();
            }
        });
    }

    private void calculateResults() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        String timeStr = timeEditText.getText().toString();

        if (timeStr.isEmpty()) {
            resultTextView.setText("Please enter a time in seconds.");
            return;
        }

        double timeInSeconds = Double.parseDouble(timeStr);

        // Perform the calculation based on the given criteria
        String result;
        if (timeInSeconds <= 13.5) {
            result = "Ενήλικες που κατοικούν στην κοινότητα";
        } else if (timeInSeconds <= 14) {
            result = "Ηλικιωμένοι ασθενείς με εγκεφαλικό";
        } else if (timeInSeconds <= 32.6) {
            result = "Ευπαθείς ηλικιωμένοι";
        } else if (timeInSeconds <= 19) {
            result = "LE ακρωτηριασμένοι";
        } else if (timeInSeconds <= 11.5) {
            result = "ΝΠ (Νόσος Πάρκινσον)";
        } else if (timeInSeconds <= 10) {
            result = "Οστεοαρθρίτιδα ισχίου";
        } else if (timeInSeconds <= 11.1) {
            result = "Αιθουσαία διαταραχές";
        } else {
            result = "Τα αποτελέσματα ειναι ";
        }
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
        dbHelper.insertTUGResult(userId, timeInSeconds, result);
        Intent intent = new Intent(TUGActivityResults.this, TUGActivity.class);
        intent.putExtra("tugResult", result);
        startActivity(intent);
        resultTextView.setText("Result: " + result);
    }
}
