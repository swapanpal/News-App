package com.example.newsapp.db

import androidx.room.TypeConverter
import com.example.newsapp.models.Source

// Kotlin only can convert primitive data type that why we need converters class
// example we have source type data in Article class
class Converters {
    // Convert source type to String type
    @TypeConverter
    fun fromSource(source : Source): String{
        return source.name
    }
    // Convert String to Source
    @TypeConverter
    fun toSource(name : String): Source {
        return Source(name, name)
    }
}