package com.marcinmejner.notki.EditorScreen

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.marcinmejner.notki.R
import com.marcinmejner.notki.viewModel.EditorViewModel
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    private val TAG = "EditActivity"

    lateinit var editorViewModel: EditorViewModel


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
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
