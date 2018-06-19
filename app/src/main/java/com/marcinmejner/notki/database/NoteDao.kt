package com.marcinmejner.notki.database

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.os.FileObserver.DELETE


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(noteEntity: NoteEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(notes: List<NoteEntity>)

    @Delete
    fun deleteNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNoteById(id: Int): NoteEntity

    @Query("SELECT * FROM notes ORDER BY date DESC")
    fun getall() : LiveData<List<NoteEntity>>

    @Query("DELETE FROM notes ")
    fun deleteAll() : Int

    @Query("SELECT COUNT(*) FROM notes")
    fun getCount(): Int


}