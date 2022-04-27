package com.formationandroid.appandroidtp.activities

import android.content.ClipData
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.formationandroid.appandroidtp.R
import com.formationandroid.appandroidtp.adapters.MemoAdapter
import com.formationandroid.appandroidtp.bo.Memo
import com.formationandroid.appandroidtp.metier.bdd.AppDatabaseMemoHelper


class MemoActivity : AppCompatActivity() {

    private lateinit var memoAdapter : MemoAdapter;
    private lateinit var recyclerView: RecyclerView;
    private var favoriSelected = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)
        favoriSelected = false;
        val preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(preferences.getInt("idMemo", 0) != 0) {
             Toast.makeText(this, preferences.getInt("idMemo", 0).toString(), Toast.LENGTH_LONG).show();
        }

        AppDatabaseMemoHelper.getDatabase(this).memosDAO().getListeMemos();

        // Liste :
        recyclerView = findViewById(R.id.liste_memo);

        recyclerView.setHasFixedSize(true);

        val layoutManager = LinearLayoutManager(this);
        recyclerView.layoutManager = layoutManager;

        val listeMemos = AppDatabaseMemoHelper.getDatabase(this).memosDAO().getListeMemos();

        // Adapter :
        memoAdapter = MemoAdapter(listeMemos.toMutableList(), this);
        recyclerView.adapter = memoAdapter;

    }

    fun addMemo(view: View) {
        val textSaisieField : EditText = findViewById(R.id.add_memo_text);
        val textSaisie = textSaisieField.text.toString();
            if(textSaisie != "") {
                val memo = Memo(0, textSaisie);
                AppDatabaseMemoHelper.getDatabase(this).memosDAO().insert(memo);

                val listeMemos = AppDatabaseMemoHelper.getDatabase(this).memosDAO().getListeMemos();
                memoAdapter.updateMemos(listeMemos.toMutableList());

                recyclerView.smoothScrollToPosition(0);
                textSaisieField.setText("");
            }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        menuInflater.inflate(R.menu.memo_menu, menu);
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        return when (item.itemId)
        {

            R.id.action_favori ->
            {
                val legende : TextView = findViewById(R.id.legende_favori);
                if(favoriSelected) {
                    Log.i("tag", "not-favori");
                    favoriSelected = false;
                    item.setIcon(R.drawable.ic_favorite_false);
                    legende.isVisible = false;
                    false
                }else{
                    Log.i("tag", "favori");
                    favoriSelected = true;
                    item.setIcon(R.drawable.ic_favorite_true);
                    legende.isVisible = true;
                    true
                }
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}