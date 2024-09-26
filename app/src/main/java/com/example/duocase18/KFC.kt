package com.example.duocase18

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
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

        // Eco-friendliness Button Logic
        ecofriendlyButton.setOnClickListener {
            if (isEcoFriendlyExpanded) {
                ecofriendlyTextView.layoutParams.height = 0
                ecofriendlyButton.setImageResource(R.drawable.arrow)
            } else {
                ecofriendlyTextView.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                setupEcoFriendlyText(ecofriendlyTextView)
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

        // Work Ethics Button Logic
        workEthicsButton.setOnClickListener {
            if (isWorkEthicsExpanded) {
                workEthicsTextView.layoutParams.height = 0
                workEthicsButton.setImageResource(R.drawable.arrow)
            } else {
                workEthicsTextView.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                setupWorkEthicsText(workEthicsTextView)
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

    private fun setupEcoFriendlyText(ecofriendlyTextView: TextView) {
        val ecoFriendlyText = "KFC has made efforts toward eco-friendliness by focusing on sustainable sourcing, " +
                "reducing plastic usage, and improving packaging. The company aims to use 100% renewable or recyclable materials " +
                "for its consumer-facing packaging by 2025. KFC is also working on responsible sourcing of chicken, reducing food waste, " +
                "and improving energy efficiency in its operations. \n" +
                "Sources: \n" +
                "https://global.kfc.com/stories/positively-impacting-our-planet/\n" +
                "https://www.nrn.com/quick-service/kfc-convert-renewable-recycled-plastic-sources-2025"

        setClickableLinks(ecofriendlyTextView, ecoFriendlyText)
    }

    private fun setupWorkEthicsText(workEthicsTextView: TextView) {
        val workEthicsText = "KFC has faced mixed reviews regarding worker treatment. " +
                "The company has taken steps to improve employee conditions through training, " +
                "career development programs, and offering benefits such as health insurance in some locations. " +
                "However, there have been concerns raised about low wages, labor rights issues, " +
                "and stressful working conditions in certain franchises. KFC has made commitments to " +
                "improving labor standards and fostering a better work environment, but challenges remain. \n" +
                "Sources: \n" +
                "https://www.sda.au/your-rights/agreements/kfc-agreement/\n" +
                "https://www.hcamag.com/au/specialisation/employment-law/kfc-facing-class-action-lawsuit-over-work-breaks/469190"

        setClickableLinks(workEthicsTextView, workEthicsText)
    }

    private fun setClickableLinks(textView: TextView, text: String) {
        val spannableString = SpannableString(text)

        // Define the links and set ClickableSpan for each
        val links = arrayOf(
            "https://global.kfc.com/stories/positively-impacting-our-planet/" to "https://global.kfc.com/stories/positively-impacting-our-planet/",
            "https://www.nrn.com/quick-service/kfc-convert-renewable-recycled-plastic-sources-2025" to "https://www.nrn.com/quick-service/kfc-convert-renewable-recycled-plastic-sources-2025",
            "https://www.sda.au/your-rights/agreements/kfc-agreement/" to "https://www.sda.au/your-rights/agreements/kfc-agreement/",
            "https://www.hcamag.com/au/specialisation/employment-law/kfc-facing-class-action-lawsuit-over-work-breaks/469190" to "https://www.hcamag.com/au/specialisation/employment-law/kfc-facing-class-action-lawsuit-over-work-breaks/469190"
        )

        for (link in links) {
            val start = text.indexOf(link.first)
            val end = start + link.first.length

            if (start >= 0) {
                spannableString.setSpan(object : ClickableSpan() {
                    override fun onClick(widget: android.view.View) {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link.second))
                        widget.context.startActivity(intent)
                    }

                    override fun updateDrawState(ds: TextPaint) {
                        super.updateDrawState(ds)
                        ds.isUnderlineText = true // Makes the text underlined
                    }
                }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }

        textView.text = spannableString
        textView.movementMethod = LinkMovementMethod.getInstance() // Enable link clicking
    }
}
