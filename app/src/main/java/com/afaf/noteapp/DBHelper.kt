package com.afaf.noteapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context): SQLiteOpenHelper(context, "note.db", null, 1) {

    private var SQLiteDatabase: SQLiteDatabase = writableDatabase

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table Note (Content text)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun addNote (content: String): Boolean {
        val contentValues = ContentValues()
        contentValues.put("Content", content)
        var status = SQLiteDatabase.insert("Note", null, contentValues)
        return status != -1L
    }

}