package com.example.speedrunroomdatabase.room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.speedrunroomdatabase.room.entity.Note;

import java.util.List;

@Dao
public interface NoteDao extends Dao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM note_table")
    void deleteAll();

    @Query("SELECT EXISTS(SELECT * FROM note_table WHERE title = :title)")
    boolean checkExistNote(String title);

    @Query("SELECT * FROM note_table")
    LiveData<List<Note>> getAllNotes();
}
