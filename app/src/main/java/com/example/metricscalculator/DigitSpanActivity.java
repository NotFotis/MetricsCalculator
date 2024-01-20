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

public class DigitSpanActivity extends AppCompatActivity {
    private FloatingActionButton addResultButton;
    private FloatingActionButton homeButton;
    private TableLayout resultTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digit_span);

        resultTable = findViewById(R.id.resultTableDigitSpan);
        addResultButton = findViewById(R.id.addResultButtonDigitSpan);
        homeButton = findViewById(R.id.homeButtonDigitSpan);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        UserDataManager userDataManager = UserDataManager.getInstance();
        // Assuming you have a method to get the logged-in user's ID
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());

        // Fetch and display all results for the logged-in user
        List<DigitSpanResultData> resultList = dbHelper.getDigitSpanResultsForUser(userId);

        // Check if there are results to display
        if (!resultList.isEmpty()) {
            // Display the results in the table
            for (DigitSpanResultData result : resultList) {
                addTableRow(resultTable, result);
            }
        } else {
            addEmptyTableRow(resultTable, "Πατήστε το κουμπί παρακάτω για να προσθέσετε αποτελέσματα");
        }

        addResultButton.setOnClickListener(v -> {
            // Start the activity to add a new result
            Intent intent = new Intent(DigitSpanActivity.this, DigitSpanActivityResults.class);
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            // Start the activity to go back to the profile
            Intent intent = new Intent(DigitSpanActivity.this, ProfileActivity.class);
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

    private void addTableRow(TableLayout tableLayout, DigitSpanResultData result) {
        TableRow row = new TableRow(this);

        // Length
        TextView lengthTextView = new TextView(this);
        lengthTextView.setText(String.valueOf(result.getLength()));
        setTableRowAttributes(lengthTextView);
        row.addView(lengthTextView);

        // Presented
        TextView presentedTextView = new TextView(this);
        presentedTextView.setText(result.getPresented());
        setTableRowAttributes(presentedTextView);
        row.addView(presentedTextView);

        // Response
        TextView responseTextView = new TextView(this);
        responseTextView.setText(result.getResponse());
        setTableRowAttributes(responseTextView);
        row.addView(responseTextView);

        // Result
        TextView resultTextView = new TextView(this);
        resultTextView.setText(String.valueOf(result.getResult()));
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
