package com.marcinmejner.notki.EditorScreen

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.marcinmejner.notki.R
import com.marcinmejner.notki.utils.NOTES_ID_KEY
import com.marcinmejner.notki.viewModel.EditorViewModel
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.content_edit.*

class EditActivity : AppCompatActivity() {
    private val TAG = "EditActivity"

    //widgets


    //vars
    lateinit var editorViewModel: EditorViewModel
    var newNote: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        init()

    }

    private fun init() {
        initViewModel()
    }

    private fun initViewModel() {
        editorViewModel = ViewModelProviders.of(this)
                .get(EditorViewModel::class.java)

        editorViewModel.liveNote.observe(this, Observer {
            note_text_ed.setText(it?.noteText)

        })

        val extras = intent.extras
        if (extras == null) {
            title = "Nowa Notka"
            newNote = true
        }else{
            title = "Wyedytuj Notkę"
            var noteId = extras.getInt(NOTES_ID_KEY)
            editorViewModel.loadData(noteId)
        }
    }



    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        if (item?.itemId == R.id.menu_save_data) {
            saveAndReturn()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun saveAndReturn() {
        editorViewModel.saveNote(note_text_ed.text.toString())
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_edit, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
