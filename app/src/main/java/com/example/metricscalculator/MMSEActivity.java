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

public class MMSEActivity extends AppCompatActivity {
    private FloatingActionButton addResultButton;
    private FloatingActionButton homeButton;
    private TableLayout resultTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mmseactivity);

        resultTable = findViewById(R.id.resultTable);
        addResultButton = findViewById(R.id.addResultButton);
        homeButton = findViewById(R.id.homeButton);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());

        List<MMSEResultData> resultList = dbHelper.getMMSEResultsForUser(userId);

        if (!resultList.isEmpty()) {
            for (MMSEResultData result : resultList) {
                addTableRow(resultTable, result);
            }
        } else {
            addEmptyTableRow(resultTable, "Πατήστε το εικονίδιο κάτω δεξιά για να ξεκινήσετε");
        }

        addResultButton.setOnClickListener(v -> {
            Intent intent = new Intent(MMSEActivity.this, MMSEActivityResults.class);
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(MMSEActivity.this, ProfileActivity.class);
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

    private void addTableRow(TableLayout tableLayout, MMSEResultData result) {
        TableRow row = new TableRow(this);

        // Προσανατολισμός 0 to 10
        TextView orientationTextView = new TextView(this);
        orientationTextView.setText(String.valueOf(result.getOrientation()));
        setTableRowAttributes(orientationTextView);
        row.addView(orientationTextView);

        // Εγχάραξη 0 to 3
        TextView registrationTextView = new TextView(this);
        registrationTextView.setText(String.valueOf(result.getRegistration()));
        setTableRowAttributes(registrationTextView);
        row.addView(registrationTextView);

        // Προσοχή και ικανότητα υπολογισμών 0 to 5
        TextView attentionCalculationTextView = new TextView(this);
        attentionCalculationTextView.setText(String.valueOf(result.getAttentionAndCalculation()));
        setTableRowAttributes(attentionCalculationTextView);
        row.addView(attentionCalculationTextView);

        // Ανάκληση 0 to 3
        TextView recallTextView = new TextView(this);
        recallTextView.setText(String.valueOf(result.getRecall()));
        setTableRowAttributes(recallTextView);
        row.addView(recallTextView);

        // Γλώσσα 0 to 9
        TextView languageTextView = new TextView(this);
        languageTextView.setText(String.valueOf(result.getLanguage()));
        setTableRowAttributes(languageTextView);
        row.addView(languageTextView);

        // Σύνολο
        TextView totalTextView = new TextView(this);
        totalTextView.setText(String.valueOf(result.getResults()));
        setTableRowAttributes(totalTextView);
        row.addView(totalTextView);

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
