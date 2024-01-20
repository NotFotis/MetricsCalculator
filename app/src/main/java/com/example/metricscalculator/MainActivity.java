package com.example.metricscalculator;

// MainActivity.java
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button loginButton = findViewById(R.id.btnLogin);
        Button registerButton = findViewById(R.id.btnRegister);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the Login button click, e.g., navigate to the login screen
                 Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                 startActivity(loginIntent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the Register button click, e.g., navigate to the registration screen
                Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
                 startActivity(registerIntent);
            }
        });
    }
}
