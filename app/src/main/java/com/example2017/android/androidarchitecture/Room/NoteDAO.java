package com.example2017.android.androidarchitecture.Room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by M7moud on 14-Mar-19.
 */
@Dao
public interface NoteDAO {

    @Insert
    void AddNote(Note note);

    @Delete
    void DeleteNote(Note note);

    @Update
    void UpdateNote(Note note);


    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Note>> getAllNotes();

}
