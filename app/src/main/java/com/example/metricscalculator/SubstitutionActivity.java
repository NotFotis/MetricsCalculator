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

public class SubstitutionActivity extends AppCompatActivity {
    private FloatingActionButton addResultButton;
    private FloatingActionButton homeButton;
    private TableLayout resultTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_substitution);

        resultTable = findViewById(R.id.resultTable); // Adjust the ID based on your XML layout
        addResultButton = findViewById(R.id.addResultButton); // Adjust the ID based on your XML layout
        homeButton = findViewById(R.id.homeButton); // Adjust the ID based on your XML layout

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());

        List<SubstitutionResultData> resultList = dbHelper.getSubstitutionResultsForUser(userId);

        if (!resultList.isEmpty()) {
            for (SubstitutionResultData result : resultList) {
                addTableRow(resultTable, result);
            }
        } else {
            addEmptyTableRow(resultTable, "Πατήστε το κουμπί παρακάτω για να προσθέσετε αποτελέσματα Αντικατάστασης");
        }

        addResultButton.setOnClickListener(v -> {
            Intent intent = new Intent(SubstitutionActivity.this, SubstitutionActivityResults.class); // Adjust the class based on your actual implementation
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(SubstitutionActivity.this, ProfileActivity.class);
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

    private void addTableRow(TableLayout tableLayout, SubstitutionResultData result) {
        TableRow row = new TableRow(this);

        // Add TextView for Correct
        TextView correctTextView = new TextView(this);
        correctTextView.setText(String.valueOf(result.getCorrect()));
        setTableRowAttributes(correctTextView);
        row.addView(correctTextView);

        // Add TextView for Response Time
        TextView responseTimeTextView = new TextView(this);
        responseTimeTextView.setText(String.valueOf(result.getResponseTime()));
        setTableRowAttributes(responseTimeTextView);
        row.addView(responseTimeTextView);

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
