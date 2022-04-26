package com.formationandroid.appandroidtp.dao

import androidx.room.*
import com.formationandroid.appandroidtp.bo.Memo

@Dao
abstract class MemosDAO {

    @Query("SELECT * FROM memos")
    abstract fun getListeMemos() : List<MemosDAO>;

    @Insert
    abstract fun insert(vararg memos : Memo);

    @Update
    abstract fun update(vararg memos : Memo);

    @Delete
    abstract fun delete(vararg memos : Memo);

}