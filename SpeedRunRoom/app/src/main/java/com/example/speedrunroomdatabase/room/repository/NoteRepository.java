package com.example.speedrunroomdatabase.room.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.speedrunroomdatabase.room.dao.NoteDao;
import com.example.speedrunroomdatabase.room.database.Database;
import com.example.speedrunroomdatabase.room.entity.Note;

import java.util.List;

public class NoteRepository {

    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application){
        Database database = Database.getDatabase(application);
        noteDao = database.noteDao();
    }

    public void insert(Note note){
        Database.databaseWriteExecutor.execute(() -> {
            noteDao.insert(note);
        });
    }

    public boolean checkExistNote(String title){
        return noteDao.checkExistNote(title);
    }

}
