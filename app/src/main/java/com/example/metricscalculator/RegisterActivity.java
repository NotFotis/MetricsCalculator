package com.example.metricscalculator;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.List;

public class RegisterActivity extends Activity {

    private EditText etUsername, etFirstName, etLastName, etPassword;
    private Button btnDateOfBirth, btnRegister;
    private Spinner spinnerEducation;
    private DatabaseHelper dbHelper;
    String selectedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DatabaseHelper(this);

        etUsername = findViewById(R.id.etUsername);
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etPassword = findViewById(R.id.etPassword);
        btnDateOfBirth = findViewById(R.id.btnDateOfBirth);
        spinnerEducation = findViewById(R.id.spinnerEducation);
        btnRegister = findViewById(R.id.btnRegister);

        btnDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Populate the Spinner with choices "1," "2," and "3"
        List<String> educationOptions = new ArrayList<>();
        educationOptions.add("Πρωτοβάθμια Εκπαίδευση");
        educationOptions.add("Δευτεροβάθμια Εκπαίδευση");
        educationOptions.add("Τριτοβάθμια Εκπαίδευση");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, educationOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEducation.setAdapter(adapter);
    }

    private void showDatePickerDialog() {
        // Get the current date
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a date picker dialog and set the initial date
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int selectedYear, int selectedMonth, int selectedDay) {
                // Handle the selected date
                 selectedDate = selectedYear + "-" + (selectedMonth + 1) + "-" + selectedDay;
                // Update a TextView or any other field with the selected date
                // textViewDate.setText(selectedDate);
            }
        }, year, month, day);

        // Show the date picker dialog
        datePickerDialog.show();
    }


    private void registerUser() {
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        // Retrieve user input
        String username = etUsername.getText().toString();
        String firstName = etFirstName.getText().toString();
        String lastName = etLastName.getText().toString();
        String dateOfBirth = selectedDate; // Replace with the actual selected date
        String password = etPassword.getText().toString();
        String education = spinnerEducation.getSelectedItem().toString();

        // Put user data into ContentValues
        values.put("username", username);
        values.put("first_name", firstName);
        values.put("last_name", lastName);
        values.put("date_of_birth", dateOfBirth);
        values.put("password", password);
        values.put("education", education);

        // Insert user data into the database
        long newRowId = database.insert("user", null, values);

        if (newRowId != -1) {
            // Registration successful
            // You can add further handling or redirection here
        } else {
            // Registration failed
            // Handle the error, e.g., show an error message
        }
    }
}
