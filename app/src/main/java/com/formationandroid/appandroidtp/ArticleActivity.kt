package com.formationandroid.appandroidtp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Toast


class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        Toast.makeText(getApplicationContext(),
            "Bienvenue!",
            Toast.LENGTH_LONG).show();
    }
}