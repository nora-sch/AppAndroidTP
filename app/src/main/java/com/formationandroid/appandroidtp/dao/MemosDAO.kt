package com.formationandroid.appandroidtp.dao

import androidx.room.*
import com.formationandroid.appandroidtp.bo.Memo

@Dao
abstract class MemosDAO {

    @Query("SELECT * FROM memos ORDER BY memos.memoId DESC")
    abstract fun getListeMemos() : List<Memo>;

    @Insert
    abstract fun insert(vararg memos : Memo);

    @Update
    abstract fun update(vararg memos : Memo);

    @Delete
    abstract fun delete(vararg memos : Memo);

}