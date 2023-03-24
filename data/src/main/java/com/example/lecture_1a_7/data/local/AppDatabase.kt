package com.example.lecture_1a_7.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lecture_1a_7.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}