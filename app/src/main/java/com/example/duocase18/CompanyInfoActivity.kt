package com.example.duocase18

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class CompanyInfoActivity : AppCompatActivity() {

    private lateinit var companyKFC: LinearLayout
    private lateinit var companyNike: LinearLayout
    private lateinit var companyPhillips: LinearLayout
    private lateinit var searchEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_info)


        companyKFC = findViewById(R.id.linearLayout2)
        companyNike = findViewById(R.id.linearLayout3)
        companyPhillips = findViewById(R.id.linearLayout4)


        searchEditText = findViewById(R.id.etSearch)


        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                filterCompanies(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })


        companyKFC.setOnClickListener {

            val intent = Intent(this, company_page::class.java)
            intent.putExtra("companyName", "KFC")
            intent.putExtra("companyDescription", "KFC (Kentucky Fried Chicken) is one of the world's largest fast food chains, known for its fried chicken.")
            intent.putExtra("companySector", "Fast Food")
            startActivity(intent)
        }

        companyNike.setOnClickListener {

            val intent = Intent(this, company_page::class.java)
            intent.putExtra("companyName", "Nike")
            intent.putExtra("companyDescription", "Nike is the world's largest supplier of athletic shoes and apparel, headquartered in Beaverton, Oregon.")
            intent.putExtra("companySector", "Clothing")
            startActivity(intent)
        }

        companyPhillips.setOnClickListener {

            val intent = Intent(this, company_page::class.java)
            intent.putExtra("companyName", "Phillips")
            intent.putExtra("companyDescription", "Philips is a Dutch multinational corporation, known for electronics and healthcare technology, founded in 1891.")
            intent.putExtra("companySector", "Tech")
            startActivity(intent)
        }
    }


    private fun filterCompanies(query: String) {
        val searchQuery = query.lowercase()


        val kfcDescription = companyKFC.contentDescription.toString().lowercase()
        val nikeDescription = companyNike.contentDescription.toString().lowercase()
        val phillipsDescription = companyPhillips.contentDescription.toString().lowercase()


        companyKFC.visibility = if (kfcDescription.contains(searchQuery)) LinearLayout.VISIBLE else LinearLayout.GONE
        companyNike.visibility = if (nikeDescription.contains(searchQuery)) LinearLayout.VISIBLE else LinearLayout.GONE
        companyPhillips.visibility = if (phillipsDescription.contains(searchQuery)) LinearLayout.VISIBLE else LinearLayout.GONE
    }
}
