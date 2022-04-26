package com.formationandroid.appandroidtp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.formationandroid.appandroidtp.R
import com.formationandroid.appandroidtp.bo.Memo

class MemoAdapter(private var listeMemos: MutableList<Memo>) : RecyclerView.Adapter<MemoAdapter.MemoViewHolder>() {

    // ViewHolder :
    inner class MemoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textViewLibelleMemo: TextView = itemView.findViewById(R.id.memo_item);
        val deleteImageButtonMemo: ImageButton = itemView.findViewById(R.id.delete_memo);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoViewHolder {
     val viewMemo = LayoutInflater.from(parent.context).inflate(R.layout.item_memo, parent, false);
        return MemoViewHolder(viewMemo);
    }

    override fun onBindViewHolder(holder: MemoViewHolder, position: Int) {
      holder.textViewLibelleMemo.text = listeMemos[position].libelle;
    }

    override fun getItemCount(): Int  = listeMemos.size;

}