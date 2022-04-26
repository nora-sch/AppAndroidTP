package com.formationandroid.appandroidtp.metier.bdd

import androidx.room.Database
import androidx.room.RoomDatabase
import com.formationandroid.appandroidtp.bo.Memo
import com.formationandroid.appandroidtp.dao.MemosDAO

@Database(entities = [Memo::class], version  = 1)
abstract class AppDatabaseMemo : RoomDatabase(){
    abstract fun memosDAO() : MemosDAO;
}