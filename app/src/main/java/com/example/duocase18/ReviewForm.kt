package com.example.duocase18

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ReviewForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_review_form)

        val backButton = findViewById<ImageButton>(R.id.back)
        val anonymousCheckbox = findViewById<CheckBox>(R.id.anonymousCheckbox)
        val nonAnonymousCheckbox = findViewById<CheckBox>(R.id.nonAnonymousCheckbox)
        val postReviewButton = findViewById<Button>(R.id.postReviewButton)
        val commentInputField = findViewById<EditText>(R.id.commentInputField)

        postReviewButton.setOnClickListener {
            val reviewText = commentInputField.text.toString().trim()

            if (reviewText.isEmpty() || (!anonymousCheckbox.isChecked && !nonAnonymousCheckbox.isChecked)) {
                Toast.makeText(this, "Please enter a review and select a checkbox.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ReviewConf::class.java)
                startActivity(intent)
            }
        }

        backButton.setOnClickListener {
            val intent = Intent(this, KFC::class.java)
            startActivity(intent)
        }

        anonymousCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                nonAnonymousCheckbox.isChecked = false
            }
        }

        nonAnonymousCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                anonymousCheckbox.isChecked = false
            }
        }
    }
}
