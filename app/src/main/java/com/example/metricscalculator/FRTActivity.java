package com.example.metricscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class FRTActivity extends AppCompatActivity {
    private FloatingActionButton addResultButton;
    private FloatingActionButton homeButton;
    private TableLayout resultTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frtactivity);
        resultTable = findViewById(R.id.resultTable);
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        UserDataManager userDataManager = UserDataManager.getInstance();
        // Assuming you have a method to get the logged-in user's ID
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());

        // Fetch and display all results for the logged-in user
        List<FRTResultData> resultList = dbHelper.getFRTResultsForUser(userId);

        // Check if there are results to display
        if (!resultList.isEmpty()) {
            // Display the results in the table
            for (FRTResultData result : resultList) {
                addTableRow(resultTable, result);
            }
        }  else {
            addEmptyTableRow(resultTable, "Πατήστε το εικονίδιο κάτω δεξιά για να ξεκινήσετε");
        }
        addResultButton = findViewById(R.id.addResultButton);
        addResultButton.setOnClickListener(v -> {
            // Start the activity to add a new result
            Intent intent = new Intent(FRTActivity.this, FRTActivityResults.class);
            startActivity(intent);
        });
        homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(FRTActivity.this, ProfileActivity.class);
            intent.putExtra("username", UserDataManager.getUsername());
            intent.putExtra("firstName", UserDataManager.getFirstName());
            intent.putExtra("lastName", UserDataManager.getLastName());
            intent.putExtra("dateOfBirth", UserDataManager.getDateOfBirth());
            intent.putExtra("education", UserDataManager.getEducation());
            startActivity(intent);
        });
        // Retrieve the result from the Intent
        int sstResult = getIntent().getIntExtra("sstResult", 2);

    }
    private void addEmptyTableRow(TableLayout tableLayout, String message) {
        TableRow row = new TableRow(this);
        TextView messageTextView = new TextView(this);
        messageTextView.setText(message);
        setTableRowAttributes(messageTextView);
        row.addView(messageTextView);
        tableLayout.addView(row);
    }

    private void addTableRow(TableLayout tableLayout, FRTResultData result) {
        TableRow row = new TableRow(this);

        // Distance
        TextView distanceTextView = new TextView(this);
        distanceTextView.setText(String.valueOf(result.getDistance()));
        setTableRowAttributes(distanceTextView);
        row.addView(distanceTextView);

        // Result
        TextView resultTextView = new TextView(this);
        resultTextView.setText(result.getResult());
        setTableRowAttributes(resultTextView);
        row.addView(resultTextView);

        // Add layout parameters for the TableRow
        TableLayout.LayoutParams params = new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
        );
        row.setLayoutParams(params);

        tableLayout.addView(row);
    }

    private void setTableRowAttributes(TextView textView) {
        textView.setLayoutParams(new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT
        ));
        textView.setPadding(16, 16, 16, 16);
        textView.setGravity(Gravity.CENTER);
    }

}
