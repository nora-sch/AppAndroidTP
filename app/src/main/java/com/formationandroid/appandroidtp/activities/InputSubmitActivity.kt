package com.formationandroid.appandroidtp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.formationandroid.appandroidtp.R

class InputSubmitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_submit)
    }

    fun submitSaisie(view: View) {
        val intent = Intent(this, InputMainActivity::class.java);
        val textField : EditText = findViewById(R.id.saisie);
        val incomingValue = textField.text.toString();
        intent.putExtra("value", incomingValue);
        startActivity(intent);
    }
}