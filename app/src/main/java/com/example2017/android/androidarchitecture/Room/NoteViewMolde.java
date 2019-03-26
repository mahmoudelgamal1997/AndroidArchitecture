package com.example2017.android.androidarchitecture.Room;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by M7moud on 25-Mar-19.
 */
public class NoteViewMolde extends AndroidViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<Note>> allNotes;

    public NoteViewMolde(@NonNull Application application) {
        super(application);
        noteRepository=new NoteRepository(application);
        allNotes=noteRepository.getAllNotes();
    }

    public void insert(Note note){
        noteRepository.insert(note);
    }

    public void delete(Note note){
        noteRepository.delete(note);
    }

    public void update(Note note){
        noteRepository.update(note);
    }

    public void deleteAll(){
        noteRepository.deleteAllNotes();
    }

    public LiveData<List<Note>> getAllNotes(){
        return allNotes;
    }


}
