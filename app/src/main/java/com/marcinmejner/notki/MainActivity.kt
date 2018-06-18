package com.marcinmejner.notki

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.marcinmejner.notki.model.NoteEntity
import com.marcinmejner.notki.utils.SampleData

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"


    //widgets
    var recyclerView: RecyclerView? = null

    //vars
    var notesData = ArrayList<NoteEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        init()

        notesData.addAll(SampleData.getNotes())

        notesData.forEach { Log.d(TAG, "onCreate: $it") }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun init(){
        initWidgets()
        initFab()
        }

    private fun initFab() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    private fun initWidgets() {
        recyclerView = recycler_view
        recyclerView?.hasFixedSize()
        val layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
    }
}

