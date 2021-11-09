package com.example.notes.database.firebase

import androidx.lifecycle.LiveData
import com.example.notes.model.Note
import com.example.notes.utilits.REF_DATABASE
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class AllNotesLiveData : LiveData<List<Note>>() {


    private val listener = object : ValueEventListener {
        override fun onCancelled(p0: DatabaseError) {

        }

        override fun onDataChange(p0: DataSnapshot) {
            value = p0.children.map {
                it.getValue(Note::class.java) ?: Note()
            }
        }

    }

    override fun onInactive() {
        REF_DATABASE.removeEventListener(listener)
        super.onInactive()
    }

    override fun onActive() {
        REF_DATABASE.addValueEventListener(listener)
        super.onActive()
    }
}