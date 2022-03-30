package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newsapp.R
import com.example.newsapp.db.ArticleDatabase
import com.example.newsapp.repository.NewsRepository
import kotlinx.android.synthetic.main.activity_news.*

// project source: https://www.youtube.com/watch?v=asuOWE5KuFM&list=PLQkwcJG4YTCRF8XiCRESq1IFFW8COlxYJ
// API source: https://newsapi.org/
// api key: 09eec4e2cab248dbbc9b2e5f95a5ae66
// api url: https://newsapi.org/v2/everything?q=tesla&from=2022-02-24&sortBy=publishedAt&apiKey=09eec4e2cab248dbbc9b2e5f95a5ae66
class NewsActivity : AppCompatActivity() {

    lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        // setup viewModel
        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(NewsViewModel::class.java)

        // setup navigation
        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())

    }
}