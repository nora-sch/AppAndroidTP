package com.formationandroid.appandroidtp.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import com.formationandroid.appandroidtp.R
import com.formationandroid.appandroidtp.activities.DetailMemoActivity
import com.formationandroid.appandroidtp.bo.Memo
import com.formationandroid.appandroidtp.fragments.DetailFragment
import com.formationandroid.appandroidtp.metier.bdd.AppDatabaseMemoHelper

class MemoAdapter(private var listeMemos: MutableList<Memo>, private val activity: FragmentActivity) : RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    // ViewHolder :
    inner class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewLibelleMemo: TextView = itemView.findViewById(R.id.memo_item);
        val deleteImageButtonMemo: ImageButton = itemView.findViewById(R.id.delete_memo);

        // Listener pour chaque memo pour récuperer les données d'un memo
        init{
            textViewLibelleMemo.setOnClickListener{
                val memo = listeMemos[adapterPosition];
                val preferences = PreferenceManager.getDefaultSharedPreferences(itemView.context);
                val editor = preferences.edit();
                editor.putInt("idMemo", memo.memoId);
                editor.apply();

                if(activity.findViewById<FrameLayout>(R.id.conteneur_detail) != null){
                    // landscape portable / tablette :

                    val fragment = DetailFragment();

                    // envoi d'argument :
                    val bundle = Bundle();
                    bundle.putParcelable(DetailFragment.EXTRA_MEMO, memo);
                    fragment.arguments = bundle;

                    // ajout :
                    val transaction : FragmentTransaction = activity.supportFragmentManager.beginTransaction();
                    transaction.replace(R.id.conteneur_detail, fragment, "info_memo");
                    transaction.commit();

                }else{
                    // portrait portable / tablette :

                    // lancement d'activité de détail memo :
                    val intent = Intent(itemView.context, DetailMemoActivity::class.java);
                    intent.putExtra(DetailMemoActivity.EXTRA_MEMO, memo);
                    itemView.context.startActivity(intent);
                }
            }
            deleteImageButtonMemo.setOnClickListener{
                val memo = listeMemos[adapterPosition];
                Toast.makeText(itemView.context, "\""+memo.libelle + "\" a été supprimé!", Toast.LENGTH_SHORT).show();
                AppDatabaseMemoHelper.getDatabase(itemView.context).memosDAO().delete(memo);
                listeMemos = AppDatabaseMemoHelper.getDatabase(itemView.context).memosDAO().getListeMemos().toMutableList();
                updateMemos(listeMemos);
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
     val viewMemo = LayoutInflater.from(parent.context).inflate(R.layout.item_memo, parent, false);
        return MemoViewHolder(viewMemo);
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
      holder.textViewLibelleMemo.text = listeMemos[position].libelle;
    }

    override fun getItemCount(): Int  = listeMemos.size;

   /*
    fun ajouterMemo(memo: Memo){
        listeMemos.add(0, memo);
        notifyItemInserted(0);
    }
    */

    @SuppressLint("NotifyDataSetChanged")
    fun updateMemos(listeMemos: MutableList<Memo>) {
        this.listeMemos = listeMemos;
        notifyDataSetChanged();
    }


}