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

public class TrialActivity extends AppCompatActivity {
    private FloatingActionButton addResultButton;
    private FloatingActionButton homeButton;
    private TableLayout resultTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trial);

        resultTable = findViewById(R.id.resultTable);
        addResultButton = findViewById(R.id.addResultButton);
        homeButton = findViewById(R.id.homeButton);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());

        List<TrailResultData> resultList = dbHelper.getTrailResultsForUser(userId);

        if (!resultList.isEmpty()) {
            for (TrailResultData result : resultList) {
                addTableRow(resultTable, result);
            }
        } else {
            addEmptyTableRow(resultTable, "Πατήστε το εικονίδιο κάτω δεξιά για να ξεκινήσετε");
        }

        addResultButton.setOnClickListener(v -> {
            Intent intent = new Intent(TrialActivity.this, TrialActivityResults.class);
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(TrialActivity.this, ProfileActivity.class);
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

    private void addTableRow(TableLayout tableLayout, TrailResultData result) {
        TableRow row = new TableRow(this);

        TextView partATextView = new TextView(this);
        partATextView.setText(String.valueOf(result.getPartA()));
        setTableRowAttributes(partATextView);
        row.addView(partATextView);

        TextView partBTextView = new TextView(this);
        partBTextView.setText(String.valueOf(result.getPartB()));
        setTableRowAttributes(partBTextView);
        row.addView(partBTextView);

        TextView ageTextView = new TextView(this);
        ageTextView.setText(String.valueOf(result.getAge()));
        setTableRowAttributes(ageTextView);
        row.addView(ageTextView);

        TextView resultTextView = new TextView(this);
        resultTextView.setText(result.getResult());
        setTableRowAttributes(resultTextView);
        row.addView(resultTextView);

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
