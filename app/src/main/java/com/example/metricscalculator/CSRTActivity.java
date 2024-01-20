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

public class CSRTActivity extends AppCompatActivity {
    private FloatingActionButton addResultButton;
    private FloatingActionButton homeButton;
    private TableLayout resultTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csrtactivity2);

        resultTable = findViewById(R.id.resultTable); // Adjust the ID based on your XML layout
        addResultButton = findViewById(R.id.addResultButton); // Adjust the ID based on your XML layout
        homeButton = findViewById(R.id.homeButton); // Adjust the ID based on your XML layout

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());

        List<CSRTResultData> resultList = dbHelper.getCSRTResultsForUser(userId);

        if (!resultList.isEmpty()) {
            for (CSRTResultData result : resultList) {
                addTableRow(resultTable, result);
            }
        } else {
            addEmptyTableRow(resultTable, "Πατήστε το κουμπί παρακάτω για να προσθέσετε αποτελέσματα CSRT");
        }

        addResultButton.setOnClickListener(v -> {
            Intent intent = new Intent(CSRTActivity.this, CSRTActivityResults.class); // Adjust the class based on your actual implementation
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(CSRTActivity.this, ProfileActivity.class);
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

    private void addTableRow(TableLayout tableLayout, CSRTResultData result) {
        TableRow row = new TableRow(this);

        // Add TextView for Gender
        TextView genderTextView = new TextView(this);
        genderTextView.setText(result.getGender());
        setTableRowAttributes(genderTextView);
        row.addView(genderTextView);

        // Add TextView for Age
        TextView ageTextView = new TextView(this);
        ageTextView.setText(String.valueOf(result.getAge()));
        setTableRowAttributes(ageTextView);
        row.addView(ageTextView);

        // Add TextView for Reaction Time
        TextView reactionTimeTextView = new TextView(this);
        reactionTimeTextView.setText(String.valueOf(result.getReactionTime()));
        setTableRowAttributes(reactionTimeTextView);
        row.addView(reactionTimeTextView);

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
