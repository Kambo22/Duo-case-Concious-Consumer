package com.example.duocase18

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.duocase18.R

class MainActivity : AppCompatActivity() {


    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnNext: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnNext = findViewById(R.id.btnNext)


        btnNext.setOnClickListener {
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()


            if (email == "admin" && password == "123") {

                val intent = Intent(this, CompanyInfoActivity::class.java)
                startActivity(intent)
            } else {

                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
