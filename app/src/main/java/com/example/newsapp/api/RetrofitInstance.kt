package com.example.newsapp.api

import com.example.newsapp.util.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit singleton class
 */
class RetrofitInstance {
    companion object{
        // lazy means only initialize once
        private val retrofit by lazy {
            // For take log of retrofit it's very helpful for debugging.
            val logging = HttpLoggingInterceptor()
            // To see the body(original) response of the network request
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            // now use the http client and pass the retrofit instance
            Retrofit.Builder()
                .baseUrl(BASE_URL)// how the request to be interpreted & converted by kotlin object
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        // Finally get our api instance from retrofit builder
        // This is the actual api object that we can use everywhere to make network request
        val api by lazy {
            retrofit.create(NewsAPI::class.java)
        }
    }
}