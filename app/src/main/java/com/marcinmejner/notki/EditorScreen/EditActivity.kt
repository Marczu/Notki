package com.marcinmejner.notki.EditorScreen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.marcinmejner.notki.R
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)




    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
