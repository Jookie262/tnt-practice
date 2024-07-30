package com.example.notesroom;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.notesroom.data.entity.Note;
import com.example.notesroom.data.repository.NoteRepository;

import java.util.List;

public class AddNotesViewModel extends AndroidViewModel {
    NoteRepository noteRepository;


    public AddNotesViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
    }

    public void insert(Note note){
        noteRepository.insert(note);
    }

   public LiveData<Boolean> checkExistTitle(String title){
        return noteRepository.checkExistTitle(title);
   }
}
