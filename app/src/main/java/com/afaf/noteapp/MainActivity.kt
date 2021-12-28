package com.afaf.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var bt: Button
    private lateinit var ed: EditText
    private lateinit var notes: MutableList<String>
    private lateinit var rvMain: RecyclerView
    private lateinit var adapter: RecyclerViwAdapter
    private val databaseSQLite by lazy { DBHelper(applicationContext) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt = findViewById(R.id.btSubmit)
        ed = findViewById(R.id.edNote)
        notes = mutableListOf()
        rvMain = findViewById(R.id.rvMain)
        adapter = RecyclerViwAdapter(notes)
        rvMain.adapter = adapter
        rvMain.layoutManager = LinearLayoutManager(this)

        bt.setOnClickListener {
            val note = ed.text.toString()
            if(note.isNotEmpty()) {
                val res = databaseSQLite.addNotes(note)
                if(res > 0){
                    notes.add(note)
                    Toast.makeText(this, "Added successfully", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}