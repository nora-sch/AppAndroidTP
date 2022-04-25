package com.formationandroid.appandroidtp

import android.os.Bundle
import android.widget.Button
import android.widget.ScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton


class ArticleActivity : AppCompatActivity() {
    private lateinit var scrollView: ScrollView;
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        Toast.makeText(getApplicationContext(),
            "Bienvenue!",
            Toast.LENGTH_LONG).show();
        scrollView = findViewById(R.id.scroll_view_article);


        val bouton: AppCompatButton = findViewById(R.id.btn_retour);

        //val bouton: Button = findViewById(R.id.btn_retour);
         bouton.setOnClickListener{
           Toast.makeText(getApplicationContext(),
                "Vous êtes revenu \n" + "au début de l'article!",
                Toast.LENGTH_LONG).show();
             scrollView.scrollTo(0,0);
        }
    }



}