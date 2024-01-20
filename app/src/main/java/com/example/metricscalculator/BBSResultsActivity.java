package com.example.metricscalculator;

// AddMetricsActivity.java
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BBSResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbsresults);

        // Example metric, you can initialize others similarly
        Spinner spinnerSittingToStanding = findViewById(R.id.spinnerSittingToStanding);
        Spinner spinnerStandingUnsupported = findViewById(R.id.spinnerStandingUnsupported);
        Spinner spinnerSittingUnsupported = findViewById(R.id.spinnerSittingUnsupported);
        Spinner spinnerStandingToSitting = findViewById(R.id.spinnerStandingToSitting);
        Spinner spinnerTransfers = findViewById(R.id.spinnerTransfers);
        Spinner spinnerStandingWithEyesClosed = findViewById(R.id.spinnerStandingWithEyesClosed);
        Spinner spinnerStandingWithFeetTogether = findViewById(R.id.spinnerStandingWithFeetTogether);
        Spinner spinnerReachingForwardWithOutstretchedArm = findViewById(R.id.spinnerReachingForwardWithOutstretchedArm);
        Spinner spinnerRetrievingObjectFromFloor = findViewById(R.id.spinnerRetrievingObjectFromFloor);
        Spinner spinnerTurningToLookBehind = findViewById(R.id.spinnerTurningToLookBehind);
        Spinner spinnerTurning360Degrees = findViewById(R.id.spinnerTurning360Degrees);
        Spinner spinnerPlacingAlternateFootOnStool = findViewById(R.id.spinnerPlacingAlternateFootOnStool);
        Spinner spinnerStandingWithOneFootInFront = findViewById(R.id.spinnerStandingWithOneFootInFront);
        Spinner spinnerStandingOnOneFoot = findViewById(R.id.spinnerStandingOnOneFoot);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.dropdown_values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSittingToStanding.setAdapter(adapter);
        spinnerStandingUnsupported.setAdapter(adapter);
        spinnerSittingUnsupported.setAdapter(adapter);
        spinnerTransfers.setAdapter(adapter);
        spinnerStandingToSitting.setAdapter(adapter);
        spinnerStandingWithEyesClosed.setAdapter(adapter);
        spinnerStandingWithFeetTogether.setAdapter(adapter);
        spinnerReachingForwardWithOutstretchedArm.setAdapter(adapter);
        spinnerRetrievingObjectFromFloor.setAdapter(adapter);
        spinnerTurningToLookBehind.setAdapter(adapter);
        spinnerTurning360Degrees.setAdapter(adapter);
        spinnerPlacingAlternateFootOnStool.setAdapter(adapter);
        spinnerStandingWithOneFootInFront.setAdapter(adapter);
        spinnerStandingOnOneFoot.setAdapter(adapter);

        // Add other metric spinners initialization here

        Button btnCalculateTotal = findViewById(R.id.btnCalculateTotal);
        btnCalculateTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateTotal();
            }
        });
    }

    private void calculateTotal() {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        // Retrieve values from spinners
        int sittingToStandingValue = ((Spinner) findViewById(R.id.spinnerSittingToStanding)).getSelectedItemPosition();
        int standingUnsupportedValue = ((Spinner) findViewById(R.id.spinnerStandingUnsupported)).getSelectedItemPosition();
        int SittingUnsupported = ((Spinner) findViewById(R.id.spinnerSittingUnsupported)).getSelectedItemPosition();
        int StandingToSitting = ((Spinner) findViewById(R.id.spinnerStandingToSitting)).getSelectedItemPosition();
        int Transfers = ((Spinner) findViewById(R.id.spinnerTransfers)).getSelectedItemPosition();
        int StandingWithEyesClosed = ((Spinner) findViewById(R.id.spinnerStandingWithEyesClosed)).getSelectedItemPosition();
        int StandingWithFeetTogether = ((Spinner) findViewById(R.id.spinnerStandingWithFeetTogether)).getSelectedItemPosition();
        int ReachingForwardWithOutstretchedArm = ((Spinner) findViewById(R.id.spinnerReachingForwardWithOutstretchedArm)).getSelectedItemPosition();
        int RetrievingObjectFromFloor = ((Spinner) findViewById(R.id.spinnerRetrievingObjectFromFloor)).getSelectedItemPosition();
        int TurningToLookBehind = ((Spinner) findViewById(R.id.spinnerTurningToLookBehind)).getSelectedItemPosition();
        int Turning360Degrees = ((Spinner) findViewById(R.id.spinnerTurning360Degrees)).getSelectedItemPosition();
        int PlacingAlternateFootOnStool = ((Spinner) findViewById(R.id.spinnerPlacingAlternateFootOnStool)).getSelectedItemPosition();
        int StandingWithOneFootInFront = ((Spinner) findViewById(R.id.spinnerStandingWithOneFootInFront)).getSelectedItemPosition();
        int StandingOnOneFoot = ((Spinner) findViewById(R.id.spinnerStandingOnOneFoot)).getSelectedItemPosition();

        // Calculate total
        int total = sittingToStandingValue + standingUnsupportedValue + SittingUnsupported + StandingToSitting + Transfers + StandingWithEyesClosed + StandingWithFeetTogether + ReachingForwardWithOutstretchedArm + RetrievingObjectFromFloor + TurningToLookBehind + Turning360Degrees + PlacingAlternateFootOnStool + StandingWithOneFootInFront + StandingOnOneFoot;
        UserDataManager userDataManager = UserDataManager.getInstance();
        int userId = dbHelper.getUserIdByUsername(userDataManager.getUsername());
        dbHelper.insertBBSMetrics(userId, sittingToStandingValue, standingUnsupportedValue, SittingUnsupported, StandingToSitting, Transfers, StandingWithEyesClosed, StandingWithFeetTogether, ReachingForwardWithOutstretchedArm, RetrievingObjectFromFloor, TurningToLookBehind, Turning360Degrees, PlacingAlternateFootOnStool, StandingWithOneFootInFront, StandingOnOneFoot, total);
        Intent intent = new Intent(BBSResultsActivity.this, BBSResultsFull.class);
        intent.putExtra("bbsResult", total);
        startActivity(intent);
    }
}
