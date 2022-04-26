package com.formationandroid.appandroidtp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.formationandroid.appandroidtp.R
import com.formationandroid.appandroidtp.adapters.MemoAdapter
import com.formationandroid.appandroidtp.bo.Memo
import com.formationandroid.appandroidtp.metier.bdd.AppDatabaseMemoHelper

class MemoActivity : AppCompatActivity() {

    private lateinit var memoAdapter : MemoAdapter;
    private lateinit var recyclerView: RecyclerView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)

        AppDatabaseMemoHelper.getDatabase(this).memosDAO().getListeMemos();

        // Liste :
        recyclerView = findViewById(R.id.liste_memo);

        recyclerView.setHasFixedSize(true);

        val layoutManager = LinearLayoutManager(this);
        recyclerView.layoutManager = layoutManager;

       // val listeMemos: MutableList<Memo> = ArrayList();
        // for (a in 1..30){
        //    listeMemos.add(Memo("Memo : $a"));
       // }
        val listeMemos = AppDatabaseMemoHelper.getDatabase(this).memosDAO().getListeMemos();

        // Adapter :
        memoAdapter = MemoAdapter(listeMemos.toMutableList());
        recyclerView.adapter = memoAdapter;

    }

    fun addMemo(view: View) {
        val textSaisieField : EditText = findViewById(R.id.add_memo_text);
        val textSaisie = textSaisieField.text;
        //val memo = Memo(textSaisie.toString());
        //memoAdapter.ajouterMemo(memo);

        val memo = Memo(0, textSaisie.toString());
        AppDatabaseMemoHelper.getDatabase(this).memosDAO().insert(memo);

        val listeMemos = AppDatabaseMemoHelper.getDatabase(this).memosDAO().getListeMemos();
        memoAdapter.updateMemos(listeMemos.toMutableList());

        recyclerView.smoothScrollToPosition(0);
        textSaisieField.setText("");
    }
}