package com.test.room_crud

class NoteRepository(private val db: NoteDao) {

    suspend fun insert(note: Note): Long {
        return db.insert(note)
    }

    suspend fun update(note: Note) {
        db.update(note)
    }

    suspend fun delete(note: Note) {
        db.delete(note)
    }

    suspend fun getAllNotes(): List<Note> {
        return db.getAllNotes()
    }
}