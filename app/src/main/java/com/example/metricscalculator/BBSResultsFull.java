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

public class BBSResultsFull extends AppCompatActivity {
    private FloatingActionButton addResultButton;
    private FloatingActionButton homeButton;
    private TableLayout resultTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbsresults_full);

        resultTable = findViewById(R.id.resultTable);
        addResultButton = findViewById(R.id.addResultButton);
        homeButton = findViewById(R.id.homeButton);

        DatabaseHelper dbHelper = new DatabaseHelper(this);
        UserDataManager userDataManager = UserDataManager.getInstance();
        // Assuming you have a method to get the logged-in user's ID
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());

        // Fetch and display all results for the logged-in user
        List<BBSMetricData> resultList = dbHelper.getBBSMetricsForUser(userId);

        // Check if there are results to display
        if (!resultList.isEmpty()) {
            // Display the results in the table
            for (BBSMetricData result : resultList) {
                addTableRow(resultTable, result);
            }
        }  else {
            addEmptyTableRow(resultTable, "Πατήστε το εικονίδιο κάτω δεξιά για να ξεκινήσετε");
        }

        addResultButton.setOnClickListener(v -> {
            // Start the activity to add a new result
            Intent intent = new Intent(BBSResultsFull.this, BBSResultsActivity.class);
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            // Start the activity to go back to the profile
            Intent intent = new Intent(BBSResultsFull.this, ProfileActivity.class);
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
    private void addTableRow(TableLayout tableLayout, BBSMetricData result) {
        TableRow row = new TableRow(this);

        // Sitting to Standing
        TextView sittingToStandingTextView = new TextView(this);
        sittingToStandingTextView.setText(String.valueOf(result.getSittingToStanding()));
        setTableRowAttributes(sittingToStandingTextView);
        row.addView(sittingToStandingTextView);

        // Standing Unsupported
        TextView standingUnsupportedTextView = new TextView(this);
        standingUnsupportedTextView.setText(String.valueOf(result.getStandingUnsupported()));
        setTableRowAttributes(standingUnsupportedTextView);
        row.addView(standingUnsupportedTextView);

        // Sitting Unsupported
        TextView sittingUnsupportedTextView = new TextView(this);
        sittingUnsupportedTextView.setText(String.valueOf(result.getSittingUnsupported()));
        setTableRowAttributes(sittingUnsupportedTextView);
        row.addView(sittingUnsupportedTextView);

        // Standing to Sitting
        TextView standingToSittingTextView = new TextView(this);
        standingToSittingTextView.setText(String.valueOf(result.getStandingToSitting()));
        setTableRowAttributes(standingToSittingTextView);
        row.addView(standingToSittingTextView);

        // Transfers
        TextView transfersTextView = new TextView(this);
        transfersTextView.setText(String.valueOf(result.getTransfers()));
        setTableRowAttributes(transfersTextView);
        row.addView(transfersTextView);

        // Standing with Eyes Closed
        TextView standingWithEyesClosedTextView = new TextView(this);
        standingWithEyesClosedTextView.setText(String.valueOf(result.getStandingWithEyesClosed()));
        setTableRowAttributes(standingWithEyesClosedTextView);
        row.addView(standingWithEyesClosedTextView);

        // Standing with Feet Together
        TextView standingWithFeetTogetherTextView = new TextView(this);
        standingWithFeetTogetherTextView.setText(String.valueOf(result.getStandingWithFeetTogether()));
        setTableRowAttributes(standingWithFeetTogetherTextView);
        row.addView(standingWithFeetTogetherTextView);

        // Reaching Forward with Outstretched Arm
        TextView reachingForwardTextView = new TextView(this);
        reachingForwardTextView.setText(String.valueOf(result.getReachingForwardWithOutstretchedArm()));
        setTableRowAttributes(reachingForwardTextView);
        row.addView(reachingForwardTextView);

        // Retrieving Object from Floor
        TextView retrievingObjectTextView = new TextView(this);
        retrievingObjectTextView.setText(String.valueOf(result.getRetrievingObjectFromFloor()));
        setTableRowAttributes(retrievingObjectTextView);
        row.addView(retrievingObjectTextView);

        // Turning to Look Behind
        TextView turningToLookBehindTextView = new TextView(this);
        turningToLookBehindTextView.setText(String.valueOf(result.getTurningToLookBehind()));
        setTableRowAttributes(turningToLookBehindTextView);
        row.addView(turningToLookBehindTextView);

        // Turning 360 Degrees
        TextView turning360DegreesTextView = new TextView(this);
        turning360DegreesTextView.setText(String.valueOf(result.getTurning360Degrees()));
        setTableRowAttributes(turning360DegreesTextView);
        row.addView(turning360DegreesTextView);

        // Placing Alternate Foot on Stool
        TextView placingAlternateFootOnStoolTextView = new TextView(this);
        placingAlternateFootOnStoolTextView.setText(String.valueOf(result.getPlacingAlternateFootOnStool()));
        setTableRowAttributes(placingAlternateFootOnStoolTextView);
        row.addView(placingAlternateFootOnStoolTextView);

        // Standing with One Foot in Front
        TextView standingWithOneFootInFrontTextView = new TextView(this);
        standingWithOneFootInFrontTextView.setText(String.valueOf(result.getStandingWithOneFootInFront()));
        setTableRowAttributes(standingWithOneFootInFrontTextView);
        row.addView(standingWithOneFootInFrontTextView);

        // Standing on One Foot
        TextView standingOnOneFootTextView = new TextView(this);
        standingOnOneFootTextView.setText(String.valueOf(result.getStandingOnOneFoot()));
        setTableRowAttributes(standingOnOneFootTextView);
        row.addView(standingOnOneFootTextView);

        // Standing on One Foot
        TextView totalTextView = new TextView(this);
        totalTextView.setText(String.valueOf(result.getTotal()));
        setTableRowAttributes(totalTextView);
        row.addView(totalTextView);

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
