package com.formationandroid.appandroidtp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InputMainActivity : AppCompatActivity() {

    private lateinit var spinner : ProgressBar;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_main)

        spinner = findViewById(R.id.spinner);
    }

    fun lancerPageSaisie(view: View) {
        doStartSpinner();
    }

    fun doStartSpinner(){
        spinner.setIndeterminate(true);
        CoroutineScope(Dispatchers.Default).launch{
            withContext(Dispatchers.Main) {spinner.setVisibility(View.VISIBLE)};
            SystemClock.sleep(5000); // Sleep 5 seconds.
            val intent = Intent(this@InputMainActivity, InputSubmitActivity::class.java);
            startActivity(intent);
        }
    }
}