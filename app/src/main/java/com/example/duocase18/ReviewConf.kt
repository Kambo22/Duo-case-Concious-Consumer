package com.example.duocase18

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ReviewConf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_conf)



        val homeReturn = findViewById<Button>(R.id.homeReturn)

        homeReturn.setOnClickListener {
            val intent = Intent(this, CompanyInfoActivity::class.java)
            startActivity(intent)
        }

    }
}