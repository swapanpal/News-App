package com.example.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.newsapp.models.Article

@Database(entities = [Article::class], version = 1)
@TypeConverters(Converters::class)  // tell database to us Type Converters class
abstract class ArticleDatabase : RoomDatabase(){
    abstract fun getArticleDao() : ArticleDao

    // To create our actual database
    companion object{
        // Create an instance of Article database
        @Volatile
        private var instance: ArticleDatabase? = null
        // Create a lock variable to synchronize the setting of the instance
        private var LOCK = Any()

        // if we call ArticleDatabase class this operator fun will be execute
        operator fun invoke(context : Context) = instance?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it

            }

        }
        // Create the database
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDatabase::class.java,
                "article_db.db"
            ).build()
    }
}