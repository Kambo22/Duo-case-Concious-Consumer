package com.example.duocase18

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class KFC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_kfc)


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
                descriptionTextView.text = "KFC (Kentucky Fried Chicken) is a global fast-food chain known for its fried chicken, which is prepared using a secret blend of 11 herbs and spices. Founded by Colonel Harland Sanders in 1952, KFC is famous for its crispy chicken, offering various menu items like buckets, sandwiches, sides, and desserts. It operates in over 150 countries and is a subsidiary of Yum! Brands."
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
                ecofriendlyTextView.text = "KFC has made efforts toward eco-friendliness by focusing on sustainable sourcing, reducing plastic usage, and improving packaging. The company aims to use 100% renewable or recyclable materials for its consumer-facing packaging by 2025. KFC is also working on responsible sourcing of chicken, reducing food waste, and improving energy efficiency in its operations."
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
                workEthicsTextView.text = "KFC has faced mixed reviews regarding worker treatment. The company has taken steps to improve employee conditions through training, career development programs, and offering benefits such as health insurance in some locations. However, there have been concerns raised about low wages, labor rights issues, and stressful working conditions in certain franchises. KFC has made commitments to improving labor standards and fostering a better work environment, but challenges remain."
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