package com.example.notes.database

import androidx.lifecycle.LiveData
import com.example.notes.model.Note

interface DatabaseRepository {

    val allNotes: LiveData<List<Note>>

    suspend fun insert(note: Note, onSuccess: () -> Unit)

    suspend fun delete(note: Note, onSuccess: () -> Unit)

    fun connectToDatabase(onSuccess: () -> Unit, onFail: (String) -> Unit) {}

    fun signOut() {}
}