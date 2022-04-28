package com.formationandroid.appandroidtp.activities

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.formationandroid.appandroidtp.R


class PhoneContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_contacts)

        val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if(permission == PackageManager.PERMISSION_GRANTED){
            lireContacts();
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), 111);
        }
    }
    private fun lireContacts(){
        Toast.makeText(this, "Accès aux contacts", Toast.LENGTH_LONG).show();
    }
}