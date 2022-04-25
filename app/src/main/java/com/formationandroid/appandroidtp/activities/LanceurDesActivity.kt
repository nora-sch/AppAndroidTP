package com.formationandroid.appandroidtp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.formationandroid.appandroidtp.R
import kotlin.random.Random

class LanceurDesActivity : AppCompatActivity() {
    private var val1 = 0;
    private var val2 = 0;
    private var val3 = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lanceur_des)

        val dice1 : TextView = findViewById(R.id.first_dice);
        val dice2 : TextView = findViewById(R.id.second_dice);
        val dice3 : TextView = findViewById(R.id.third_dice);

        if(savedInstanceState != null){
            val1 = savedInstanceState.getInt("val1");
            val2 = savedInstanceState.getInt("val2");
            val3 = savedInstanceState.getInt("val3");
        }else{
            val1 = randomNb();
            val2 = randomNb();
            val3 = randomNb();
        }

        dice1.text = val1.toString();
        dice2.text = val2.toString();
        dice3.text = val3.toString();

    }

    fun randomNb() : Int {
        var nb = Random.nextInt(1,6);
        return nb;
    }

    // sauvegarde de numèros crées dans onCreate
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("val1", val1);
        outState.putInt("val2", val2);
        outState.putInt("val3", val3);
        super.onSaveInstanceState(outState);
    }

}