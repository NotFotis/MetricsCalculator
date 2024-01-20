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

public class TechnologyAcceptanceActivity extends AppCompatActivity {
    private FloatingActionButton addResultButton;
    private FloatingActionButton homeButton;
    private TableLayout resultTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology_acceptance);

        resultTable = findViewById(R.id.resultTable); // Adjust the ID based on your XML layout
        addResultButton = findViewById(R.id.addResultButton); // Adjust the ID based on your XML layout
        homeButton = findViewById(R.id.homeButton); // Adjust the ID based on your XML layout

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());

        List<TechnologyAcceptanceResultData> resultList = dbHelper.getTechnologyAcceptanceResultsForUser(userId);

        if (!resultList.isEmpty()) {
            for (TechnologyAcceptanceResultData result : resultList) {
                addTableRow(resultTable, result);
            }
        } else {
            addEmptyTableRow(resultTable, "Πατήστε το κουμπί παρακάτω για να προσθέσετε αποτελέσματα αποδοχής τεχνολογίας");
        }

        addResultButton.setOnClickListener(v -> {
            Intent intent = new Intent(TechnologyAcceptanceActivity.this, TechnologyAcceptanceActivityResults.class); // Adjust the class based on your actual implementation
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(TechnologyAcceptanceActivity.this, ProfileActivity.class);
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

    private void addTableRow(TableLayout tableLayout, TechnologyAcceptanceResultData result) {
        TableRow row = new TableRow(this);

        // Add TextViews for each TAM item
        TextView tam1TextView = new TextView(this);
        tam1TextView.setText(String.valueOf(result.getTam1()));
        setTableRowAttributes(tam1TextView);
        row.addView(tam1TextView);

        TextView tam2TextView = new TextView(this);
        tam2TextView.setText(String.valueOf(result.getTam2()));
        setTableRowAttributes(tam2TextView);
        row.addView(tam2TextView);

        TextView tam3TextView = new TextView(this);
        tam3TextView.setText(String.valueOf(result.getTam3()));
        setTableRowAttributes(tam3TextView);
        row.addView(tam3TextView);

        TextView tam4TextView = new TextView(this);
        tam4TextView.setText(String.valueOf(result.getTam4()));
        setTableRowAttributes(tam4TextView);
        row.addView(tam4TextView);

        TextView tam5TextView = new TextView(this);
        tam5TextView.setText(String.valueOf(result.getTam5()));
        setTableRowAttributes(tam5TextView);
        row.addView(tam5TextView);

        TextView tam6TextView = new TextView(this);
        tam6TextView.setText(String.valueOf(result.getTam6()));
        setTableRowAttributes(tam6TextView);
        row.addView(tam6TextView);

        TextView tam7TextView = new TextView(this);
        tam7TextView.setText(String.valueOf(result.getTam7()));
        setTableRowAttributes(tam7TextView);
        row.addView(tam7TextView);

        TextView tam8TextView = new TextView(this);
        tam8TextView.setText(String.valueOf(result.getTam8()));
        setTableRowAttributes(tam8TextView);
        row.addView(tam8TextView);

        TextView tam9TextView = new TextView(this);
        tam9TextView.setText(String.valueOf(result.getTam9()));
        setTableRowAttributes(tam9TextView);
        row.addView(tam9TextView);

        TextView tam10TextView = new TextView(this);
        tam10TextView.setText(String.valueOf(result.getTam10()));
        setTableRowAttributes(tam10TextView);
        row.addView(tam10TextView);

        TextView tam11TextView = new TextView(this);
        tam11TextView.setText(String.valueOf(result.getTam11()));
        setTableRowAttributes(tam11TextView);
        row.addView(tam11TextView);

        TextView tam12TextView = new TextView(this);
        tam12TextView.setText(String.valueOf(result.getTam12()));
        setTableRowAttributes(tam12TextView);
        row.addView(tam12TextView);

        // Add TextViews for PU and PEU
        TextView puTextView = new TextView(this);
        puTextView.setText(String.valueOf(result.getPu()));
        setTableRowAttributes(puTextView);
        row.addView(puTextView);

        TextView peuTextView = new TextView(this);
        peuTextView.setText(String.valueOf(result.getPeu()));
        setTableRowAttributes(peuTextView);
        row.addView(peuTextView);

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
