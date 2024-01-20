package com.example.metricscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class SSTResultsFull extends AppCompatActivity {
    private FloatingActionButton addResultButton;
    private FloatingActionButton homeButton;
    private TableLayout resultTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sstresults_full);

        resultTable = findViewById(R.id.resultTable);
        addResultButton = findViewById(R.id.addResultButton);
        homeButton = findViewById(R.id.homeButton);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
UserDataManager userDataManager = UserDataManager.getInstance();
        // Assuming you have a method to get the logged-in user's ID
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());

        // Fetch and display all results for the logged-in user
        List<ResultData> resultList = dbHelper.getResultsForUserSST(userId);

        // Check if there are results to display
        if (!resultList.isEmpty()) {
            // Display the results in the table
            for (ResultData result : resultList) {
                addTableRow(resultTable, result);
            }
        }  else {
            addEmptyTableRow(resultTable, "Πατήστε το εικονίδιο κάτω δεξιά για να ξεκινήσετε");
        }

        addResultButton.setOnClickListener(v -> {
            // Start the activity to add a new result
            Intent intent = new Intent(SSTResultsFull.this, SSTResultsActivity.class);
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            // Start the activity to go back to the profile
            Intent intent = new Intent(SSTResultsFull.this, ProfileActivity.class);
            intent.putExtra("username", UserDataManager.getUsername());
            intent.putExtra("firstName", UserDataManager.getFirstName());
            intent.putExtra("lastName", UserDataManager.getLastName());
            intent.putExtra("dateOfBirth", UserDataManager.getDateOfBirth());
            intent.putExtra("education", UserDataManager.getEducation());
            startActivity(intent);
        });
    }
    private void addEmptyTableRow(TableLayout tableLayout, String message) {
        TableRow row = new TableRow(this);
        TextView messageTextView = new TextView(this);
        messageTextView.setText(message);
        setTableRowAttributes(messageTextView);
        row.addView(messageTextView);
        tableLayout.addView(row);
    }
    private void addTableRow(TableLayout tableLayout, ResultData result) {
        TableRow row = new TableRow(this);

        // Age
        TextView ageTextView = new TextView(this);
        ageTextView.setText(String.valueOf(result.getAge()));
        setTableRowAttributes(ageTextView);
        row.addView(ageTextView);

        // Number
        TextView numberTextView = new TextView(this);
        numberTextView.setText(String.valueOf(result.getNumber()));
        setTableRowAttributes(numberTextView);
        row.addView(numberTextView);

        // Gender
        TextView genderTextView = new TextView(this);
        genderTextView.setText(result.getGender());
        setTableRowAttributes(genderTextView);
        row.addView(genderTextView);

        // Results
        TextView resultsTextView = new TextView(this);
        resultsTextView.setText(result.getResults());
        setTableRowAttributes(resultsTextView);
        row.addView(resultsTextView);

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
