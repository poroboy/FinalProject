package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText edtUsername = findViewById(R.id.edtUsername);
        final EditText edtPassword = findViewById(R.id.edtPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(login.this, "Error: Username and Password cannot be empty!", Toast.LENGTH_SHORT).show();
                } else {
                    // Handle login logic here
                    // If login is successful, navigate to MainActivity
                    Intent intent = new Intent(login.this, BuynewplanFragment.class);
                    startActivity(intent);
                    finish(); // This will close the LoginActivity
                }
            }
        });
    }
}