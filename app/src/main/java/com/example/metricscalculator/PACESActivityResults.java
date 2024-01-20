package com.example.metricscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PACESActivityResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacesresults);

        // Retrieve EditText views
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);
        EditText editText3 = findViewById(R.id.editText3);
        EditText editText4 = findViewById(R.id.editText4);
        EditText editText5 = findViewById(R.id.editText5);
        EditText editText6 = findViewById(R.id.editText6);
        EditText editText7 = findViewById(R.id.editText7);
        EditText editText8 = findViewById(R.id.editText8);
        EditText editText9 = findViewById(R.id.editText9);
        EditText editText10 = findViewById(R.id.editText10);
        EditText editText11 = findViewById(R.id.editText11);
        EditText editText12 = findViewById(R.id.editText12);
        EditText editText13 = findViewById(R.id.editText13);
        EditText editText14 = findViewById(R.id.editText14);
        EditText editText15 = findViewById(R.id.editText15);
        EditText editText16 = findViewById(R.id.editText16);
        EditText editText17 = findViewById(R.id.editText17);
        EditText editText18 = findViewById(R.id.editText18);

        // Example button to trigger the calculation
        findViewById(R.id.calculateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Calculate the sum of user's answers
                int sum = 0;

                try {
                    int item1 = Integer.parseInt(editText1.getText().toString());
                    int item2 = Integer.parseInt(editText2.getText().toString());
                    int item3= Integer.parseInt(editText3.getText().toString());
                    int item4 = Integer.parseInt(editText4.getText().toString());
                    int item5 = Integer.parseInt(editText5.getText().toString());
                    int item6 = Integer.parseInt(editText6.getText().toString());
                    int item7 = Integer.parseInt(editText7.getText().toString());
                    int item8 = Integer.parseInt(editText8.getText().toString());
                    int item9 = Integer.parseInt(editText9.getText().toString());
                    int item10= Integer.parseInt(editText10.getText().toString());
                    int item11 = Integer.parseInt(editText11.getText().toString());
                    int item12 = Integer.parseInt(editText12.getText().toString());
                    int item13 = Integer.parseInt(editText13.getText().toString());
                    int item14 = Integer.parseInt(editText14.getText().toString());
                    int item15 = Integer.parseInt(editText15.getText().toString());
                    int item16 = Integer.parseInt(editText16.getText().toString());
                    int item17 = Integer.parseInt(editText17.getText().toString());
                    int item18 = Integer.parseInt(editText18.getText().toString());
                    sum = item1 + item2 + item3 + item4 +item5 +item6 +item7 +item8 +item9+item10 + item11 +item12 +item13 +item14 +item15 +item16 +item17 +item18;
                    UserDataManager userDataManager = UserDataManager.getInstance();
                    int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
                    dbHelper.insertPACESResult(userId, item1 , item2 , item3 , item4 ,item5 ,item6 ,item7 ,item8 ,item9,item10 , item11 ,item12 ,item13 ,item14 ,item15 ,item16 ,item17 ,item18, sum);
                    Intent intent = new Intent(PACESActivityResults.this, PACESActivity.class);
                    intent.putExtra("pacesResult", sum);
                    startActivity(intent);
                    // Show the sum in a Toast message
                    Toast.makeText(getApplicationContext(), "Sum: " + sum, Toast.LENGTH_SHORT).show();
                } catch (NumberFormatException e) {
                    // Handle the case where the user enters a non-integer value
                    Toast.makeText(getApplicationContext(), "Please enter valid numbers for all items", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
