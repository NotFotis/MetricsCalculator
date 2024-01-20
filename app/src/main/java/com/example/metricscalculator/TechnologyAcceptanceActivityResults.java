package com.example.metricscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TechnologyAcceptanceActivityResults extends AppCompatActivity {

    private EditText[] tamEditTexts;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology_acceptance_results);

        // Initialize EditText array for TAM items
        tamEditTexts = new EditText[12];
        tamEditTexts[0] = findViewById(R.id.editTextTAM01);
        tamEditTexts[1] = findViewById(R.id.editTextTAM02);
        tamEditTexts[2] = findViewById(R.id.editTextTAM03);
        tamEditTexts[3] = findViewById(R.id.editTextTAM04);
        tamEditTexts[4] = findViewById(R.id.editTextTAM05);
        tamEditTexts[5] = findViewById(R.id.editTextTAM06);
        tamEditTexts[6] = findViewById(R.id.editTextTAM07);
        tamEditTexts[7] = findViewById(R.id.editTextTAM08);
        tamEditTexts[8] = findViewById(R.id.editTextTAM09);
        tamEditTexts[9] = findViewById(R.id.editTextTAM10);
        tamEditTexts[10] = findViewById(R.id.editTextTAM11);
        tamEditTexts[11] = findViewById(R.id.editTextTAM12);

        calculateButton = findViewById(R.id.calculateButton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAndDisplayResults();
            }
        });
    }

    private void calculateAndDisplayResults() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        // Validate and get TAM item values
        double[] tamValues = new double[12];
        for (int i = 0; i < tamEditTexts.length; i++) {
            String input = tamEditTexts[i].getText().toString().trim();
            if (input.isEmpty()) {
                Toast.makeText(this, "Παρακαλώ εισάγετε τις τιμές για όλα τα αντικείμενα", Toast.LENGTH_SHORT).show();
                return;
            }
            tamValues[i] = Double.parseDouble(input);
            if (tamValues[i] < 0 || tamValues[i] > 7) {
                Toast.makeText(this, "Τα αντικείμενα πρέπει να έχουν τιμές από 0 έως 7", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        double tam1 = tamValues[0];
        double tam2 = tamValues[1];
        double tam3 = tamValues[2];
        double tam4 = tamValues[3];
        double tam5 = tamValues[4];
        double tam6 = tamValues[5];
        double tam7 = tamValues[6];
        double tam8 = tamValues[7];
        double tam9 = tamValues[8];
        double tam10 = tamValues[9];
        double tam11 = tamValues[10];
        double tam12 = tamValues[11];

        // Calculate PU and PEU
        double pu = (calculateAverage(tamValues, 0, 5) - 1) * (100.0 / 6);
        double peu = (calculateAverage(tamValues, 6, 11) - 1) * (100.0 / 6);
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
        dbHelper.insertTechnologyAcceptanceResult(userId, tam1 , tam2 , tam3 , tam4 ,tam5 ,tam6 ,tam7 ,tam8 ,tam9,tam10 , tam11 ,tam12 ,pu, peu);
        Intent intent = new Intent(TechnologyAcceptanceActivityResults.this, TechnologyAcceptanceActivity.class);
        startActivity(intent);
        // Display results or perform further actions
        Toast.makeText(this, "PU: " + pu + "\nPEU: " + peu, Toast.LENGTH_LONG).show();
    }

    private double calculateAverage(double[] values, int start, int end) {
        double sum = 0;
        for (int i = start; i <= end; i++) {
            sum += values[i];
        }
        return sum / (end - start + 1);
    }
}
