package com.test.room_crud

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class MyApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { NotesDatabase.getInstance(this) }
    val repository by lazy { NoteRepository(database.noteDao()) }


}
