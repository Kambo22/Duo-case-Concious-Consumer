package com.example.duocase18

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class company_page : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_company_page)


        val backButton = findViewById<ImageButton>(R.id.back)

        backButton.setOnClickListener {
            val intent = Intent(this, CompanyInfoActivity::class.java)
            startActivity(intent)
        }

        val postReview = findViewById<Button>(R.id.postReviewButton)

        postReview.setOnClickListener {
            val intent = Intent(this, ReviewForm::class.java)
            startActivity(intent)
        }


        val descriptionButton = findViewById<ImageButton>(R.id.descriptionButton)
        val descriptionTextView = findViewById<TextView>(R.id.descriptionTextView)

        val ecofriendlyButton = findViewById<ImageButton>(R.id.ecoFriendlinessButton)
        val ecofriendlyTextView = findViewById<TextView>(R.id.ecoFriendlinessTextView)

        val workEthicsButton = findViewById<ImageButton>(R.id.workEthicsButton)
        val workEthicsTextView = findViewById<TextView>(R.id.workEthicsTextView)


        var isDescriptionExpanded = false
        var isEcoFriendlyExpanded = false
        var isWorkEthicsExpanded = false

        descriptionButton.setOnClickListener {
            if (isDescriptionExpanded) {
                descriptionTextView.layoutParams.height = 0
                descriptionButton.setImageResource(R.drawable.arrow)
            } else {
                descriptionTextView.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                descriptionTextView.text = "1Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                descriptionButton.setImageResource(R.drawable.arrow_down)

                ecofriendlyTextView.layoutParams.height = 0
                ecofriendlyButton.setImageResource(R.drawable.arrow)
                workEthicsTextView.layoutParams.height = 0
                workEthicsButton.setImageResource(R.drawable.arrow)

                isEcoFriendlyExpanded = false
                isWorkEthicsExpanded = false
            }
            descriptionTextView.requestLayout()

            isDescriptionExpanded = !isDescriptionExpanded
        }

        ecofriendlyButton.setOnClickListener {
            if (isEcoFriendlyExpanded) {
                ecofriendlyTextView.layoutParams.height = 0
                ecofriendlyButton.setImageResource(R.drawable.arrow)
            } else {
                ecofriendlyTextView.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                ecofriendlyTextView.text = "2Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                ecofriendlyButton.setImageResource(R.drawable.arrow_down)

                descriptionTextView.layoutParams.height = 0
                descriptionButton.setImageResource(R.drawable.arrow)
                workEthicsTextView.layoutParams.height = 0
                workEthicsButton.setImageResource(R.drawable.arrow)

                isDescriptionExpanded = false
                isWorkEthicsExpanded = false
            }
            ecofriendlyTextView.requestLayout()

            isEcoFriendlyExpanded = !isEcoFriendlyExpanded
        }

        workEthicsButton.setOnClickListener {
            if (isWorkEthicsExpanded) {
                workEthicsTextView.layoutParams.height = 0
                workEthicsButton.setImageResource(R.drawable.arrow)
            } else {
                workEthicsTextView.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                workEthicsTextView.text = "3Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                workEthicsButton.setImageResource(R.drawable.arrow_down)

                descriptionTextView.layoutParams.height = 0
                descriptionButton.setImageResource(R.drawable.arrow)
                ecofriendlyTextView.layoutParams.height = 0
                ecofriendlyButton.setImageResource(R.drawable.arrow)

                isDescriptionExpanded = false
                isEcoFriendlyExpanded = false
            }
            workEthicsTextView.requestLayout()

            isWorkEthicsExpanded = !isWorkEthicsExpanded
        }



    }


}
