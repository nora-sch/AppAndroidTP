package com.formationandroid.appandroidtp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class LanceurDesActivity : AppCompatActivity() {

    companion object {
        const val TAG = "randomNb";
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lanceur_des)
        val dice1 : TextView = findViewById(R.id.first_dice);
        val dice2 : TextView = findViewById(R.id.second_dice);
        val dice3 : TextView = findViewById(R.id.third_dice);

        dice1.text = randomNb().toString();
        dice2.text = randomNb().toString();
        dice3.text = randomNb().toString();

    }
    fun randomNb() : Int{
        var nb = Random.nextInt(1,6);
        return nb;
    }
}