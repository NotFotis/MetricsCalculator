package com.example.metricscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.List;

public class FRTActivityResults extends AppCompatActivity {

    private EditText distanceEditText;
    private Button calculateButton;
    private TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frtresults);

        distanceEditText = findViewById(R.id.distanceEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateRisk();
            }
        });
    }

    private void calculateRisk() {
        // Get the distance entered by the user
        String distanceStr = distanceEditText.getText().toString();
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        if (distanceStr.isEmpty()) {
            resultTextView.setText("Παρακαλώ εισάγετε μια απόσταση");
            return;
        }

        // Parse the distance as a double
        double distance = Double.parseDouble(distanceStr);

        // Perform the risk calculation based on the given criteria
        String result;
        if (distance >= 25) {
            result = "Χαμηλό ρίσκο πτώσεων";
        } else if (distance >= 15) {
            result = "Το ρίσκο πτώσεων είναι 2x μεγαλύτερο από το κανονικό";
        } else if (distance > 0) {
            result = "Το ρίσκο πτώσεων είναι 4x μεγαλύτερο από το κανονικό";
        } else {
            result = "Απρόθυμος να φτάσει: Το ρίσκο πτώσεων είναι 8x μεγαλύτερο από το κανονικό";
        }
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
        dbHelper.insertFRTResult(userId, distance, result);
        Intent intent = new Intent(FRTActivityResults.this, FRTActivity.class);
        intent.putExtra("frtResult", result);
        startActivity(intent);
        // Display the result
        resultTextView.setText(result);
    }


}
