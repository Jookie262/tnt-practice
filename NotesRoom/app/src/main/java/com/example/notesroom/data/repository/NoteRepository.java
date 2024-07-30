package com.example.notesroom.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.notesroom.data.dao.NotesDAO;
import com.example.notesroom.data.database.Database;
import com.example.notesroom.data.entity.Note;

import java.util.List;

public class NoteRepository {

    private NotesDAO notesDAO;
    private LiveData<List<Note>> getAllNotes;

    public NoteRepository(Application application){
        Database database = Database.getDatabase(application);
        notesDAO = database.notesDAO();
        getAllNotes = notesDAO.getAllNotes();
    }

    public LiveData<List<Note>> getGetAllNotes(){
        return getAllNotes;
    }

    public LiveData<Boolean> checkExistTitle(String title){
        return notesDAO.checkExistTitle(title);
    }

    public void insert(Note note){
        Database.databaseWriteExecutor.execute(() -> {
            notesDAO.insert(note);
        });
    }

    public void delete(Note note){
        Database.databaseWriteExecutor.execute(()-> {
            notesDAO.delete(note);
        });

    }

    public void update(Note note){
        Database.databaseWriteExecutor.execute(() -> {
            notesDAO.update(note);
        });
    }

}
