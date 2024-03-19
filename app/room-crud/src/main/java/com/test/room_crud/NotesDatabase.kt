package com.test.room_crud

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        const val DATABASE_NAME = "notes_db"

        private var INSTANCE: NotesDatabase? = null

        fun getInstance(context: Context): NotesDatabase {
            if (INSTANCE == null) {
                synchronized(NotesDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        NotesDatabase::class.java,
                        DATABASE_NAME
                    ).build()
                }
            }
            return INSTANCE!!
        }
    }
}