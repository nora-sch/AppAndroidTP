package com.formationandroid.appandroidtp.metier.bdd

import android.content.Context
import androidx.room.Room

class AppDatabaseMemoHelper(context: Context){

    // Singletone :
    companion object
    {
        // Helper :
        private lateinit var databaseHelper: AppDatabaseMemoHelper;

        fun getDatabase(context: Context): AppDatabaseMemo{
            if(!::databaseHelper.isInitialized){
                databaseHelper = AppDatabaseMemoHelper(context);
            }
            return databaseHelper.database;
        }
    }

    // Base de données :
    val database: AppDatabaseMemo = Room
        .databaseBuilder(context.applicationContext, AppDatabaseMemo::class.java, "memos.db")
        .allowMainThreadQueries()
        .build();
}