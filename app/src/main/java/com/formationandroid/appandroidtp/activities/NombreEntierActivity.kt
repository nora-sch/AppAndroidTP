package com.formationandroid.appandroidtp.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.formationandroid.appandroidtp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NombreEntierActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nombre_entier)


    }

    fun calculer(view: View) {
        val editText : EditText = findViewById(R.id.number_saisie);
        val saisie = (editText.text.toString()).toLong();

        CoroutineScope(Dispatchers.IO).launch {

            withContext(Dispatchers.Main){
                val textViewResult: TextView = findViewById(R.id.number_result);
                val textViewNumber: TextView = findViewById(R.id.number_display);
                if(isNbPremier(saisie)) {
                    textViewResult.text = "Ce nombre est premier!";
                    textViewNumber.text = saisie.toString();
                    textViewNumber.setTextColor(Color.GREEN);
                }else{
                    textViewResult.text = "Ce nombre n'est pas premier!";
                    textViewNumber.text = saisie.toString();
                    textViewNumber.setTextColor(Color.RED);
                }
            }
        }
       editText.setText("");
    }

    private fun isNbPremier(nombre : Long): Boolean{
        var isPremier : Boolean = true;
        var reste : Long;
        if(nombre == 0L || nombre == 1L) {
            isPremier = false;
        }else{
            for(i in 2..nombre/2){
                reste = nombre%i;
                if(reste == 0L){
                    isPremier = false;
                    break
                }
            }
        }
        return isPremier;
    }
}