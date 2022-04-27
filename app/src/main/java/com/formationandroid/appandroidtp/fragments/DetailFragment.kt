package com.formationandroid.appandroidtp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.formationandroid.appandroidtp.R
import com.formationandroid.appandroidtp.bo.Memo

class DetailFragment : Fragment() {
    companion object
    {
        const val EXTRA_MEMO = "memo"
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);
        val arguments = requireArguments();
        val memo: Memo? = arguments.getParcelable(EXTRA_MEMO);

        val textView: TextView = view.findViewById(R.id.memo_detail);
        textView.text = memo!!.libelle;
    }

}