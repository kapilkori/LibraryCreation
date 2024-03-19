package com.test.room_crud

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(private val repository: NoteRepository) : ViewModel() {

    private val allNotes = MutableLiveData<List<Note>>()

    fun getAllNotes(): LiveData<List<Note>> {
        CoroutineScope(Dispatchers.IO).launch {
            allNotes.postValue(repository.getAllNotes())
        }

        return allNotes
    }

    suspend fun insert(note: Note) {
        repository.insert(note)
    }

    suspend fun update(note: Note) {
        repository.update(note)
    }

    suspend fun delete(note: Note) {
        repository.delete(note)
    }
}

class WordViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}