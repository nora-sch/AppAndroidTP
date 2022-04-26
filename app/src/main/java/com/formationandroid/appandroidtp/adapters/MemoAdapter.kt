package com.formationandroid.appandroidtp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.formationandroid.appandroidtp.R
import com.formationandroid.appandroidtp.bo.Memo
import com.formationandroid.appandroidtp.metier.bdd.AppDatabaseMemoHelper

class MemoAdapter(private var listeMemos: MutableList<Memo>) : RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    // ViewHolder :
    inner class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewLibelleMemo: TextView = itemView.findViewById(R.id.memo_item);
        val deleteImageButtonMemo: ImageButton = itemView.findViewById(R.id.delete_memo);
        // Listener pour chaque memo pour récuperer les données d'un meme (plus tard l'id pour pouvoir le supprimer, modifier)
        init{
            textViewLibelleMemo.setOnClickListener{
                // TODO  - montrer position dans la liste  - pas id
                val memo = listeMemos[adapterPosition];
                Toast.makeText(itemView.context, memo.memoId.toString(), Toast.LENGTH_SHORT).show();
            }
            deleteImageButtonMemo.setOnClickListener{
                val memo = listeMemos[adapterPosition];
                Toast.makeText(itemView.context, memo.libelle, Toast.LENGTH_SHORT).show();
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