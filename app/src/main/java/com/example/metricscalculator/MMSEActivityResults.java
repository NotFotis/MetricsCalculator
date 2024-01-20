package com.example.metricscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MMSEActivityResults extends AppCompatActivity {

    private EditText editTextProsanaforlismo;
    private EditText editTextEncharaxi;
    private EditText editTextProsokhIkanotita;
    private EditText editTextAnaklisi;
    private EditText editTextGlossa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmseresults);

        // Initialize EditTexts
        editTextProsanaforlismo = findViewById(R.id.editTextProsanaforlismo);
        editTextEncharaxi = findViewById(R.id.editTextEncharaxi);
        editTextProsokhIkanotita = findViewById(R.id.editTextProsokhIkanotita);
        editTextAnaklisi = findViewById(R.id.editTextAnaklisi);
        editTextGlossa = findViewById(R.id.editTextGlossa);

        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateResults();
            }
        });
    }

    private void calculateResults() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        // Retrieve user input from EditTexts
        int Prosanaforlismo = Integer.parseInt(editTextProsanaforlismo.getText().toString());
        int Encharaxi = Integer.parseInt(editTextEncharaxi.getText().toString());
        int ProsokhIkanotita = Integer.parseInt(editTextProsokhIkanotita.getText().toString());
        int Anaklisi = Integer.parseInt(editTextAnaklisi.getText().toString());
        int Glossa = Integer.parseInt(editTextGlossa.getText().toString());

        // Calculate total score (you can define your calculation logic)
        int totalScore = Prosanaforlismo + Encharaxi + ProsokhIkanotita +
                Anaklisi + Glossa ;
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
        dbHelper.insertMMSEResult(userId, Prosanaforlismo, Encharaxi, ProsokhIkanotita, Anaklisi, Glossa, totalScore);
        Intent intent = new Intent(MMSEActivityResults.this, MMSEActivity.class);
        intent.putExtra("mmseResult", totalScore);
        startActivity(intent);
        // Display or use the totalScore as needed
        Toast.makeText(this, "Total Score: " + totalScore, Toast.LENGTH_SHORT).show();
    }
}
