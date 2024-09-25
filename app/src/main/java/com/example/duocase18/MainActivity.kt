package com.example.duocase18

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.duocase18.R

class MainActivity : AppCompatActivity() {

    // Initialize variables for EditText and Button
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // This will refer to your XML layout

        // Link the variables with the views in the layout
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnNext = findViewById(R.id.btnNext)

        // Set up the button click listener
        btnNext.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            // Check if the entered email and password are correct
            if (email == "admin" && password == "123") {
                // If correct, navigate to CompanyInfoActivity
                val intent = Intent(this, CompanyInfoActivity::class.java)
                startActivity(intent)
            } else {
                // If incorrect, show a Toast message
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
