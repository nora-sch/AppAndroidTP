package com.formationandroid.appandroidtp.activities

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.formationandroid.appandroidtp.R
import com.formationandroid.appandroidtp.dao.ContactsDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class PhoneContactsActivity : AppCompatActivity() {
    companion object{
        private const val REQUEST_CODE_CONTACTS = 111;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_contacts)

        val permission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
        if(permission == PackageManager.PERMISSION_GRANTED){
            lireContacts(this);
        }else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), REQUEST_CODE_CONTACTS);
        }
    }
    private fun lireContacts(context: Context){
        Toast.makeText(this, "Accès aux contacts", Toast.LENGTH_LONG).show();
        CoroutineScope(Dispatchers.IO).launch {
            val listeContacts = ContactsDAO.getListeContacts(context);
            val stringBuilder = StringBuilder();
            for(contact in listeContacts){
                stringBuilder.append(contact.nom).append(" : ").append(contact.telephone).append("\n");
            }
            withContext(Dispatchers.Main){
            val textViewContacts: TextView = findViewById(R.id.contact_list);
            textViewContacts.text = stringBuilder.toString();
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == REQUEST_CODE_CONTACTS){
            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                lireContacts(this);
            }else{
                Toast.makeText(this, "Autorisation refusée", Toast.LENGTH_LONG).show();
            }
        }
    }

}