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

public class MOCAActivity extends AppCompatActivity {
    private FloatingActionButton addResultButton;
    private FloatingActionButton homeButton;
    private TableLayout resultTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mocaactivity);

        resultTable = findViewById(R.id.resultTable);
        addResultButton = findViewById(R.id.addResultButton);
        homeButton = findViewById(R.id.homeButton);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        UserDataManager userDataManager = UserDataManager.getInstance();
        // Assuming you have a method to get the logged-in user's ID
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());

        // Fetch and display all results for the logged-in user
        List<MOCAResultData> resultList = dbHelper.getMOCAResultsForUser(userId);

        // Check if there are results to display
        if (!resultList.isEmpty()) {
            // Display the results in the table
            for (MOCAResultData result : resultList) {
                addTableRow(resultTable, result);
            }
        } else {
            addEmptyTableRow(resultTable, "Πατήστε το εικονίδιο κάτω δεξιά για να ξεκινήσετε");
        }

        addResultButton.setOnClickListener(v -> {
            // Start the activity to add a new result
            Intent intent = new Intent(MOCAActivity.this, MOCAActivityResults.class);
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            // Start the activity to go back to the profile
            Intent intent = new Intent(MOCAActivity.this, ProfileActivity.class);
            intent.putExtra("username", UserDataManager.getUsername());
            intent.putExtra("firstName", UserDataManager.getFirstName());
            intent.putExtra("lastName", UserDataManager.getLastName());
            intent.putExtra("dateOfBirth", UserDataManager.getDateOfBirth());
            intent.putExtra("education", UserDataManager.getEducation());
            startActivity(intent);
        });
    }
        private void addEmptyTableRow (TableLayout tableLayout, String message){
            TableRow row = new TableRow(this);
            TextView messageTextView = new TextView(this);
            messageTextView.setText(message);
            setTableRowAttributes(messageTextView);
            row.addView(messageTextView);
            tableLayout.addView(row);
        }
        private void addTableRow(TableLayout tableLayout, MOCAResultData result) {
            TableRow row = new TableRow(this);

            // Οπτικοχωρικές / Εκτελεστικές
            TextView opticochorikesTextView = new TextView(this);
            opticochorikesTextView.setText(String.valueOf(result.getOpticochorikes()));
            setTableRowAttributes(opticochorikesTextView);
            row.addView(opticochorikesTextView);

            // Κατονομασία
            TextView katonomasiaTextView = new TextView(this);
            katonomasiaTextView.setText(String.valueOf(result.getKatonomasia()));
            setTableRowAttributes(katonomasiaTextView);
            row.addView(katonomasiaTextView);

            // Προσοχή 1
            TextView prosoxi1TextView = new TextView(this);
            prosoxi1TextView.setText(String.valueOf(result.getProsoxi1()));
            setTableRowAttributes(prosoxi1TextView);
            row.addView(prosoxi1TextView);

            // Προσοχή 2
            TextView prosoxi2TextView = new TextView(this);
            prosoxi2TextView.setText(String.valueOf(result.getProsoxi2()));
            setTableRowAttributes(prosoxi2TextView);
            row.addView(prosoxi2TextView);

            // Προσοχή 3
            TextView prosoxi3TextView = new TextView(this);
            prosoxi3TextView.setText(String.valueOf(result.getProsoxi3()));
            setTableRowAttributes(prosoxi3TextView);
            row.addView(prosoxi3TextView);

            // Γλώσσα
            TextView glossaTextView = new TextView(this);
            glossaTextView.setText(String.valueOf(result.getGlossa()));
            setTableRowAttributes(glossaTextView);
            row.addView(glossaTextView);

            // Ροή
            TextView roiTextView = new TextView(this);
            roiTextView.setText(String.valueOf(result.getRoi()));
            setTableRowAttributes(roiTextView);
            row.addView(roiTextView);

            // Αφαίρετη Σκέψη
            TextView afairotikiSkepsiTextView = new TextView(this);
            afairotikiSkepsiTextView.setText(String.valueOf(result.getAfairotikiSkepsi()));
            setTableRowAttributes(afairotikiSkepsiTextView);
            row.addView(afairotikiSkepsiTextView);

            // Καθιστημένη Ανάκληση
            TextView katistimeniAnaklisiTextView = new TextView(this);
            katistimeniAnaklisiTextView.setText(String.valueOf(result.getKatistimeniAnaklisi()));
            setTableRowAttributes(katistimeniAnaklisiTextView);
            row.addView(katistimeniAnaklisiTextView);

            // Προσαναφορισμός
            TextView prosanaforlismoTextView = new TextView(this);
            prosanaforlismoTextView.setText(String.valueOf(result.getProsanaforlismo()));
            setTableRowAttributes(prosanaforlismoTextView);
            row.addView(prosanaforlismoTextView);

            TextView resultTextView = new TextView(this);
            resultTextView.setText(String.valueOf(result.getResults()));
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



        private void setTableRowAttributes (TextView textView){
            textView.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT
            ));
            textView.setPadding(16, 16, 16, 16);
            textView.setGravity(Gravity.CENTER);
        }
    }

