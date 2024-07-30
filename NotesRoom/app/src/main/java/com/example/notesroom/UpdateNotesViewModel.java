package com.example.notesroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.notesroom.data.entity.Note;
import com.example.notesroom.data.repository.NoteRepository;

public class UpdateNotesViewModel extends AndroidViewModel {

    NoteRepository noteRepository;

    public UpdateNotesViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
    }

    public void update(Note note){
        noteRepository.update(note);
    }
}
