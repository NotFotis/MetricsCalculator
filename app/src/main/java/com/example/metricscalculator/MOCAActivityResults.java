package com.example.metricscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MOCAActivityResults extends AppCompatActivity {

    // Declare EditTexts
    private EditText editTextOpticochorikes;
    private EditText editTextKatonomasia;
    private EditText editTextProsoxi1;
    private EditText editTextProsoxi2;
    private EditText editTextProsoxi3;
    private EditText editTextGlossa;
    private EditText editTextRoi;
    private EditText editTextAfairotikiSkepsi;
    private EditText editTextKatistimeniAnaklisi;
    private EditText editTextProsanaforlismo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mocaresults);

        // Initialize EditTexts
        editTextOpticochorikes = findViewById(R.id.editTextOpticochorikes);
        editTextKatonomasia = findViewById(R.id.editTextKatonomasia);
        editTextProsoxi1 = findViewById(R.id.editTextProsoxi1);
        editTextProsoxi2 = findViewById(R.id.editTextProsoxi2);
        editTextProsoxi3 = findViewById(R.id.editTextProsoxi3);
        editTextGlossa = findViewById(R.id.editTextGlossa);
        editTextRoi = findViewById(R.id.editTextRoi);
        editTextAfairotikiSkepsi = findViewById(R.id.editTextAfairotikiSkepsi);
        editTextKatistimeniAnaklisi = findViewById(R.id.editTextKatistimeniAnaklisi);
        editTextProsanaforlismo = findViewById(R.id.editTextProsanatolismos);

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
        int opticochorikesScore = Integer.parseInt(editTextOpticochorikes.getText().toString());
        int katonomasiaScore = Integer.parseInt(editTextKatonomasia.getText().toString());
        int prosoxi1Score = Integer.parseInt(editTextProsoxi1.getText().toString());
        int prosoxi2Score = Integer.parseInt(editTextProsoxi2.getText().toString());
        int prosoxi3Score = Integer.parseInt(editTextProsoxi3.getText().toString());
        int glossaScore = Integer.parseInt(editTextGlossa.getText().toString());
        int roiScore = Integer.parseInt(editTextRoi.getText().toString());
        int afairotikiSkepsiScore = Integer.parseInt(editTextAfairotikiSkepsi.getText().toString());
        int katistimeniAnaklisiScore = Integer.parseInt(editTextKatistimeniAnaklisi.getText().toString());
        int prosanaforlismoScore = Integer.parseInt(editTextProsanaforlismo.getText().toString());

        // Calculate total score (you can define your calculation logic)
        int totalScore = opticochorikesScore + katonomasiaScore + prosoxi1Score +
                prosoxi2Score + prosoxi3Score + glossaScore + roiScore +
                afairotikiSkepsiScore + katistimeniAnaklisiScore + prosanaforlismoScore;
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
        dbHelper.insertMOCAResult(userId, opticochorikesScore, katonomasiaScore, prosoxi1Score, prosoxi2Score, prosoxi3Score, glossaScore, roiScore, afairotikiSkepsiScore, katistimeniAnaklisiScore, prosanaforlismoScore, totalScore);
        Intent intent = new Intent(MOCAActivityResults.this, MOCAActivity.class);
        intent.putExtra("mocaResult", totalScore);
        startActivity(intent);

        // Display or use the totalScore as needed
        Toast.makeText(this, "Total Score: " + totalScore, Toast.LENGTH_SHORT).show();
    }
}
