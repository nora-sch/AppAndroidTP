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
    companion object{
        private const val REQUEST_CODE_CONTACTS = 111;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_contacts)

        val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if(permission == PackageManager.PERMISSION_GRANTED){
            lireContacts();
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), REQUEST_CODE_CONTACTS);
        }
    }
    private fun lireContacts(){
        Toast.makeText(this, "Accès aux contacts", Toast.LENGTH_LONG).show();
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == REQUEST_CODE_CONTACTS){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                lireContacts();
            }else{
                Toast.makeText(this, "Autorisation refusée", Toast.LENGTH_LONG).show();
            }
        }
    }
}