package com.example.notes.database.room

import androidx.lifecycle.LiveData
import com.example.notes.database.DatabaseRepository
import com.example.notes.model.Note

class AppRoomRepository(private val dao: AppRoomDao) : DatabaseRepository {

    override val allNotes: LiveData<List<Note>>
        get() = dao.getAllNotes()

    override suspend fun insert(note: Note, onSuccess: () -> Unit) {
        dao.insert(note)
        onSuccess()
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
        dao.delete(note)
        onSuccess()
    }

}