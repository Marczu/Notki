package com.marcinmejner.notki.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marcinmejner.notki.R
import com.marcinmejner.notki.model.NoteEntity
import kotlinx.android.synthetic.main.content_main.view.*
import kotlinx.android.synthetic.main.note_list_item.view.*

class NotesAdapter(val notesList: ArrayList<NoteEntity>, val context: Context) : RecyclerView.Adapter<NotesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.note_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.notes.text = notesList[position].noteText

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val notes = view.notes_tv
    }
}