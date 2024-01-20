package com.example.metricscalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ProfileActivity extends Activity {
    private SessionManager sessionManager;
    private UserDataManager userDataManager;
    private Button btn11;
    private Button btn12;
    private Button btn13;
    private Button btn14;
    private Button btn15;
    private Button btn21;
    private Button btn22;
    private Button btn23;
    private Button btn24;
    private Button btn25;
    private Button btn26;
    private Button btn31;
    private Button btn32;
    private Button btn33;
    private Button btn34;
    private Button btnLogout;
    private String username;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String education;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

// Check if the user is logged in
        sessionManager = new SessionManager(getApplicationContext());
        if (!sessionManager.isLoggedIn()) {
            // Redirect to the login activity
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(intent);
            finish(); // Close the current activity
        } else {
            setContentView(R.layout.activity_profile);
            userDataManager = UserDataManager.getInstance();
            btn11 = findViewById(R.id.button11);
            btn12 = findViewById(R.id.button12);
            btn13 = findViewById(R.id.button13);
            btn14 = findViewById(R.id.button14);
            btn15 = findViewById(R.id.button15);
            btn21 = findViewById(R.id.button21);
            btn22 = findViewById(R.id.button22);
            btn23 = findViewById(R.id.button23);
            btn24 = findViewById(R.id.button24);
            btn25 = findViewById(R.id.button25);
            btn26 = findViewById(R.id.button26);
            btn31 = findViewById(R.id.button31);
            btn32 = findViewById(R.id.button32);
            btn33 = findViewById(R.id.button33);
            btn34 = findViewById(R.id.button34);
            btnLogout = findViewById(R.id.btnLogout);

                Intent intent = getIntent();
                username = intent.getStringExtra("username");
                firstName = intent.getStringExtra("firstName");
                lastName = intent.getStringExtra("lastName");
                dateOfBirth = intent.getStringExtra("dateOfBirth");
                education = intent.getStringExtra("education");

                userDataManager.setUsername(username);
                userDataManager.setFirstName(firstName);
                userDataManager.setLastName(lastName);
                userDataManager.setDateOfBirth(dateOfBirth);
                userDataManager.setEducation(education);

                updateUI();


            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Perform logout actions, e.g., clear session data
                    sessionManager.logout();

                    // Redirect to the login activity
                    Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish(); // Close the current activity
                }
            });
            btn11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn11
                    Intent intent = new Intent(ProfileActivity.this, SSTResultsFull.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });

            btn12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn12
                    Intent intent = new Intent(ProfileActivity.this, BBSResultsFull.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });

            btn13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn11
                    Intent intent = new Intent(ProfileActivity.this, CSRTActivity.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });

            btn14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn12
                    Intent intent = new Intent(ProfileActivity.this, FRTActivity.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });

            btn15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn12
                    Intent intent = new Intent(ProfileActivity.this, TUGActivity.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });

            btn21.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn21
                    Intent intent = new Intent(ProfileActivity.this, MOCAActivity.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });

            btn22.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn21
                    Intent intent = new Intent(ProfileActivity.this, MMSEActivity.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });
            btn23.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn21
                    Intent intent = new Intent(ProfileActivity.this, TrialActivity.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });
            btn24.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn21
                    Intent intent = new Intent(ProfileActivity.this, SubstitutionActivity.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });
            btn25.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn21
                    Intent intent = new Intent(ProfileActivity.this, DigitSpanActivity.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });
            btn26.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn21
                    Intent intent = new Intent(ProfileActivity.this, StroopActivity.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });

            btn31.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn21
                    Intent intent = new Intent(ProfileActivity.this, SUSActivity.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });
            btn32.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn21
                    Intent intent = new Intent(ProfileActivity.this, IGEQActivity.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });
            btn33.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn21
                    Intent intent = new Intent(ProfileActivity.this, PACESActivity.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });
            btn34.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Start the corresponding activity for btn21
                    Intent intent = new Intent(ProfileActivity.this, TechnologyAcceptanceActivity.class); // Replace with the actual activity class
                    startActivity(intent);
                }
            });

        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Update UI when returning to the activity
        updateUI();
    }

    private void updateUI() {
        // Find TextViews in the layout
        TextView tvUsername = findViewById(R.id.tvUsername);
        TextView tvFirstName = findViewById(R.id.tvFirstName);
        TextView tvLastName = findViewById(R.id.tvLastName);
        TextView tvDateOfBirth = findViewById(R.id.tvDateOfBirth);
        TextView tvEducation = findViewById(R.id.tvEducation);

        // Set the text of TextViews with user attributes
        tvUsername.setText("Όνομα Χρήστη: " + userDataManager.getUsername());
        tvFirstName.setText("Όνομα: " + userDataManager.getFirstName());
        tvLastName.setText("Επώνυμο: " + userDataManager.getLastName());
        tvDateOfBirth.setText("Ημ/νια γέννησης: " + userDataManager.getDateOfBirth());
        tvEducation.setText("Εκπαίδευση: " + userDataManager.getEducation());
    }


}
