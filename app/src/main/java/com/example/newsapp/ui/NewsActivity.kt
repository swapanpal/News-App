package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.R
import kotlinx.android.synthetic.main.activity_news.*

// project source: https://www.youtube.com/watch?v=asuOWE5KuFM&list=PLQkwcJG4YTCRF8XiCRESq1IFFW8COlxYJ
// API source: https://newsapi.org/
// api key: 09eec4e2cab248dbbc9b2e5f95a5ae66
// api url: https://newsapi.org/v2/everything?q=tesla&from=2022-02-24&sortBy=publishedAt&apiKey=09eec4e2cab248dbbc9b2e5f95a5ae66
class NewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        // setup navigation
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())

    }
}