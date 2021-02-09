package com.e.simplenote.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.e.simplenote.R
import com.e.simplenote.model.AppNote
import kotlinx.android.synthetic.main.note_item.view.*

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var noteList = emptyList<AppNote>()

    fun setList(list: List<AppNote>) {
        noteList = list
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: MainViewHolder) {
        holder.itemView.setOnClickListener {
            MainFragment.click(noteList[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: MainViewHolder) {
        holder.itemView.setOnClickListener(null)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.note_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.nameNote.text = noteList[position].name
        holder.textNote.text = noteList[position].text
    }

    override fun getItemCount(): Int {
        return noteList.size
    }


    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameNote: TextView = view.item_note_title
        val textNote: TextView = view.item_note_text
    }


}