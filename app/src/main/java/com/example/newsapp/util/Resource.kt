package com.example.newsapp.util


//This class will differentiate between successful and unsuccessful response
// Handle the network response
sealed class Resource<T>(
    val data : T? = null,
    val message : String? = null) {

    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    class Loading<T> : Resource<T>()
}