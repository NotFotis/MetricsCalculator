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

public class IGEQActivity extends AppCompatActivity {
    private FloatingActionButton addResultButton;
    private FloatingActionButton homeButton;
    private TableLayout resultTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_igeqactivity);

        resultTable = findViewById(R.id.resultTableIGEQ); // Adjust the ID based on your XML layout
        addResultButton = findViewById(R.id.addResultButtonIGEQ); // Adjust the ID based on your XML layout
        homeButton = findViewById(R.id.homeButtonIGEQ); // Adjust the ID based on your XML layout

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());

        List<IGEQResultData> resultList = dbHelper.getIGEQResultsForUser(userId);

        if (!resultList.isEmpty()) {
            for (IGEQResultData result : resultList) {
                addTableRow(resultTable, result);
            }
        } else {
            addEmptyTableRow(resultTable, "Πατήστε το κουμπί παρακάτω για να προσθέσετε αποτελέσματα IGEQ");
        }

        addResultButton.setOnClickListener(v -> {
            Intent intent = new Intent(IGEQActivity.this, IGEQActivityResults.class); // Adjust the class based on your actual implementation
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(IGEQActivity.this, ProfileActivity.class);
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

    private void addTableRow(TableLayout tableLayout, IGEQResultData result) {
        TableRow row = new TableRow(this);

        TextView competenceTextView = new TextView(this);
        competenceTextView.setText(String.valueOf(result.getCompetence()));
        setTableRowAttributes(competenceTextView);
        row.addView(competenceTextView);

        TextView immersionTextView = new TextView(this);
        immersionTextView.setText(String.valueOf(result.getImmersion()));
        setTableRowAttributes(immersionTextView);
        row.addView(immersionTextView);

        TextView flowTextView = new TextView(this);
        flowTextView.setText(String.valueOf(result.getFlow()));
        setTableRowAttributes(flowTextView);
        row.addView(flowTextView);

        TextView tensionTextView = new TextView(this);
        tensionTextView.setText(String.valueOf(result.getTension()));
        setTableRowAttributes(tensionTextView);
        row.addView(tensionTextView);

        TextView challengeTextView = new TextView(this);
        challengeTextView.setText(String.valueOf(result.getChallenge()));
        setTableRowAttributes(challengeTextView);
        row.addView(challengeTextView);

        TextView negativeTextView = new TextView(this);
        negativeTextView.setText(String.valueOf(result.getNegative()));
        setTableRowAttributes(negativeTextView);
        row.addView(negativeTextView);

        TextView positiveTextView = new TextView(this);
        positiveTextView.setText(String.valueOf(result.getPositive()));
        setTableRowAttributes(positiveTextView);
        row.addView(positiveTextView);

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
