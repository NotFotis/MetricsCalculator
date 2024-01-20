package com.example.metricscalculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // Check authentication against the database
                DatabaseHelper dbHelper = new DatabaseHelper(LoginActivity.this);
                boolean isAuthenticated = dbHelper.checkLogin(username, password);

                if (isAuthenticated) {
                    // Update session manager to mark the user as logged in
                    SessionManager sessionManager = new SessionManager(LoginActivity.this);
                    sessionManager.login(username,password);
                    UserData userData = dbHelper.getUserData(username);
                    // Create an intent to open the ProfileActivity
                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);

                    // Pass user attributes as extras in the intent
                    intent.putExtra("username", userData.getUsername());
                    intent.putExtra("firstName", userData.getFirstName());
                    intent.putExtra("lastName", userData.getLastName());
                    intent.putExtra("dateOfBirth", userData.getDateOfBirth());
                    intent.putExtra("education", userData.getEducation());

                    startActivity(intent);
                } else {
                    // Authentication failed, show an error message
                    Toast.makeText(LoginActivity.this, "Authentication failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
