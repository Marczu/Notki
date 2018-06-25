package com.marcinmejner.notki.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marcinmejner.notki.EditorScreen.EditActivity
import com.marcinmejner.notki.R
import com.marcinmejner.notki.database.NoteEntity
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

        holder.fab.setOnClickListener {
            Intent(context, EditActivity::class.java).apply {
                this.putExtra(com.marcinmejner.notki.utils.NOTES_ID_KEY, notesList[position].id)
                context.startActivity(this)
            }
        }

    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val fab = view.floating_action_button
        val notes = view.notes_tv
    }
}