package com.marcinmejner.notki.MainScreen

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.marcinmejner.notki.EditorScreen.EditActivity
import com.marcinmejner.notki.R
import com.marcinmejner.notki.adapter.NotesAdapter
import com.marcinmejner.notki.database.NoteEntity
import com.marcinmejner.notki.viewModel.MainViewModel

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"


    //widgets
    var recyclerView: RecyclerView? = null

    //vars
    var notesData = ArrayList<NoteEntity>()
    var notesAdapter: NotesAdapter? = null
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        init()


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.action_add_sample_data -> addSampleData()
            else -> super.onOptionsItemSelected(item)

        }
        return super.onOptionsItemSelected(item)
    }

    private fun addSampleData() {
        Log.d(TAG, "addSampleData: klikniete")
        mainViewModel.addSampleData()

    }

    private fun init(){
        initRecyclerView()
        initViewModel()
        initFab()
        }

    private fun initViewModel() {
        val notesObserver: Observer<List<NoteEntity>> = Observer {
            notesData.clear()
            notesData.addAll(it!!)

            if(notesAdapter == null){
                notesAdapter = NotesAdapter(notesData, this@MainActivity)
                recyclerView?.adapter = notesAdapter
            }else{
                notesAdapter?.notifyDataSetChanged()
            }
        }

        mainViewModel = ViewModelProviders.of(this)
                .get(MainViewModel::class.java)
        mainViewModel.notes.observe(this, notesObserver)
    }

    private fun initFab() {
        fab.setOnClickListener { view ->
          Intent(this@MainActivity, EditActivity::class.java).apply {
              startActivity(this)
          }
        }
    }

    private fun initRecyclerView() {
        recyclerView = recycler_view
        recyclerView?.hasFixedSize()
        val layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager

    }
}

