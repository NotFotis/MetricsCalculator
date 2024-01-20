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

public class PACESActivity extends AppCompatActivity {
    private FloatingActionButton addResultButton;
    private FloatingActionButton homeButton;
    private TableLayout resultTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacesactivity);

        resultTable = findViewById(R.id.resultTable); // Adjust the ID based on your XML layout
        addResultButton = findViewById(R.id.addResultButton); // Adjust the ID based on your XML layout
        homeButton = findViewById(R.id.homeButton); // Adjust the ID based on your XML layout

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());

        List<PACESMetricData> resultList = dbHelper.getPACESMetricsForUser(userId);

        if (!resultList.isEmpty()) {
            for (PACESMetricData result : resultList) {
                addTableRow(resultTable, result);
            }
        } else {
            addEmptyTableRow(resultTable, "Πατήστε το κουμπί παρακάτω για να προσθέσετε αποτελέσματα PACES");
        }

        addResultButton.setOnClickListener(v -> {
            Intent intent = new Intent(PACESActivity.this, PACESActivityResults.class); // Adjust the class based on your actual implementation
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(PACESActivity.this, ProfileActivity.class);
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

    private void addTableRow(TableLayout tableLayout, PACESMetricData result) {
        TableRow row = new TableRow(this);


            // Add TextViews for each PACES item
            TextView item1TextView = new TextView(this);
            item1TextView.setText(String.valueOf(result.getItem1()));
            setTableRowAttributes(item1TextView);
            row.addView(item1TextView);

            TextView item2TextView = new TextView(this);
            item2TextView.setText(String.valueOf(result.getItem2()));
            setTableRowAttributes(item2TextView);
            row.addView(item2TextView);

            TextView item3TextView = new TextView(this);
            item3TextView.setText(String.valueOf(result.getItem3()));
            setTableRowAttributes(item3TextView);
            row.addView(item3TextView);

            TextView item4TextView = new TextView(this);
            item4TextView.setText(String.valueOf(result.getItem4()));
            setTableRowAttributes(item4TextView);
            row.addView(item4TextView);

            TextView item5TextView = new TextView(this);
            item5TextView.setText(String.valueOf(result.getItem5()));
            setTableRowAttributes(item5TextView);
            row.addView(item5TextView);

            TextView item6TextView = new TextView(this);
            item6TextView.setText(String.valueOf(result.getItem6()));
            setTableRowAttributes(item6TextView);
            row.addView(item6TextView);

            TextView item7TextView = new TextView(this);
            item7TextView.setText(String.valueOf(result.getItem7()));
            setTableRowAttributes(item7TextView);
            row.addView(item7TextView);

            TextView item8TextView = new TextView(this);
            item8TextView.setText(String.valueOf(result.getItem8()));
            setTableRowAttributes(item8TextView);
            row.addView(item8TextView);

            TextView item9TextView = new TextView(this);
            item9TextView.setText(String.valueOf(result.getItem9()));
            setTableRowAttributes(item9TextView);
            row.addView(item9TextView);

            TextView item10TextView = new TextView(this);
            item10TextView.setText(String.valueOf(result.getItem10()));
            setTableRowAttributes(item10TextView);
            row.addView(item10TextView);

            TextView item11TextView = new TextView(this);
            item11TextView.setText(String.valueOf(result.getItem11()));
            setTableRowAttributes(item11TextView);
            row.addView(item11TextView);

            TextView item12TextView = new TextView(this);
            item12TextView.setText(String.valueOf(result.getItem12()));
            setTableRowAttributes(item12TextView);
            row.addView(item12TextView);

            TextView item13TextView = new TextView(this);
            item13TextView.setText(String.valueOf(result.getItem13()));
            setTableRowAttributes(item13TextView);
            row.addView(item13TextView);

            TextView item14TextView = new TextView(this);
            item14TextView.setText(String.valueOf(result.getItem14()));
            setTableRowAttributes(item14TextView);
            row.addView(item14TextView);

            TextView item15TextView = new TextView(this);
            item15TextView.setText(String.valueOf(result.getItem15()));
            setTableRowAttributes(item15TextView);
            row.addView(item15TextView);

            TextView item16TextView = new TextView(this);
            item16TextView.setText(String.valueOf(result.getItem16()));
            setTableRowAttributes(item16TextView);
            row.addView(item16TextView);

            TextView item17TextView = new TextView(this);
            item17TextView.setText(String.valueOf(result.getItem17()));
            setTableRowAttributes(item17TextView);
            row.addView(item17TextView);

            TextView item18TextView = new TextView(this);
            item18TextView.setText(String.valueOf(result.getItem18()));
            setTableRowAttributes(item18TextView);
            row.addView(item18TextView);

            // Add TextView for the sum
            TextView sumTextView = new TextView(this);
            sumTextView.setText(String.valueOf(result.getSum()));
            setTableRowAttributes(sumTextView);
            row.addView(sumTextView);

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
