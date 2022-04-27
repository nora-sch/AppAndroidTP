package com.formationandroid.appandroidtp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.formationandroid.appandroidtp.R
import com.formationandroid.appandroidtp.bo.Memo
import com.formationandroid.appandroidtp.fragments.DetailFragment

class DetailMemoActivity : AppCompatActivity() {

    companion object
    {
        const val EXTRA_MEMO = "memo"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_memo)

        // memo :
        val memo : Memo? = intent.getParcelableExtra(EXTRA_MEMO);

        // fragment :
        val fragment = DetailFragment();

        // envoi des arguments
        val bundle = Bundle();
        bundle.putParcelable(DetailFragment.EXTRA_MEMO, memo);
        fragment.arguments = bundle;

        // ajout :
        val transaction : FragmentTransaction = supportFragmentManager.beginTransaction();
        transaction.replace(R.id.conteneur_detail, fragment, "info_memo");
        transaction.commit();
    }
}