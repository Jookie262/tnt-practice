package com.example.notesroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notesroom.data.entity.Note;
import com.example.notesroom.data.repository.NoteRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    NoteRepository noteRepository;
    private final LiveData<List<Note>> getAllNotes;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        getAllNotes = noteRepository.getGetAllNotes();
    }

    public LiveData<List<Note>> getAllNotes(){
        return getAllNotes;
    }


    public void delete(Note note){
        noteRepository.delete(note);
    }
}
