package com.formationandroid.appandroidtp.dao

import android.content.Context
import android.provider.ContactsContract
import com.formationandroid.appandroidtp.bo.Contact

object ContactsDAO {

    fun getListeContacts(context: Context): List<Contact>{
        val listeContacts : MutableList<Contact> = ArrayList();
        val orderBy = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC";
        val cursor = context.contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            null,
            null,
            null,
            orderBy);
        if(cursor != null){
            try{
                while(cursor.moveToNext()){
                    listeContacts.add(Contact(
                        cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER))
                    ))
                }
            }catch (e: Exception){
                e.printStackTrace();
            }finally {
                cursor.close();
            }
        }
        return listeContacts;
    }
}