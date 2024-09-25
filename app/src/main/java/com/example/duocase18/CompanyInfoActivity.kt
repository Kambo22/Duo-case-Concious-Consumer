package com.example.duocase18

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class CompanyInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_info)

        val companyButton = findViewById<LinearLayout>(R.id.linearLayout2)

        companyButton.setOnClickListener {
            val intent = Intent(this, company_page::class.java)
            startActivity(intent)
        }

    }
}