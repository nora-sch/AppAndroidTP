package com.formationandroid.appandroidtp.bo

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "memos")
@Parcelize
data class Memo (
    @PrimaryKey(autoGenerate = true)
    val memoId: Int,
    val libelle: String): Parcelable;