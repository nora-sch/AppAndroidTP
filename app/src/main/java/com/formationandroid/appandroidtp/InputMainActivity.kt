package com.formationandroid.appandroidtp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InputMainActivity : AppCompatActivity() {

    companion object{
       // const val TAG = "res";
    }

    private lateinit var spinner : ProgressBar;
    private lateinit var btn : AppCompatButton;
    var actionDone : Boolean = false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_main)

        spinner = findViewById(R.id.spinner);
        btn = findViewById(R.id.button);
        val retour = intent.getStringExtra("value");

        if(retour != null){
            actionDone = true;
            spinner.setVisibility(View.VISIBLE)
            btn.text = "ENVOYER";
            val displayText : TextView = findViewById(R.id.text_received);
            displayText.text = retour;
        }
    }

    fun lancerPageSaisie(view: View) {
        if(!actionDone){
        doStartSpinner();
        }else{
            shareData();
        }
    }

    private fun shareData() {
        //Log.i(TAG, "SHARE is HERE")

    }

    fun doStartSpinner(){
        spinner.setIndeterminate(true);

        CoroutineScope(Dispatchers.Default).launch{
            withContext(Dispatchers.Main) {spinner.setVisibility(View.VISIBLE)};
            SystemClock.sleep(2000); // Sleep 2 seconds.
            val intent = Intent(this@InputMainActivity, InputSubmitActivity::class.java);
            startActivity(intent);
        }

    }
}