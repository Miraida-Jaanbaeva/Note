package com.example.lecture_1a_7.data.local

import androidx.room.*
import com.example.lecture_1a_7.data.model.NoteEntity

@Dao
interface NoteDao {
    @Insert
    suspend fun insert(noteEntity: NoteEntity)

    @Update
    suspend fun update(noteEntity: NoteEntity)

    @Delete
    suspend fun delete(noteEntity: NoteEntity)

    @Query("select * from notes")
    suspend fun getAllNotes(): List<NoteEntity>
}