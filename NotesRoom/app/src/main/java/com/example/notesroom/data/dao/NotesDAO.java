package com.example.notesroom.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.notesroom.data.entity.Note;

import java.util.List;

@Dao
public interface NotesDAO {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("SELECT * FROM notes_table")
    LiveData<List<Note>> getAllNotes();

    @Query("SELECT EXISTS(SELECT * FROM notes_table WHERE title = :title)")
    LiveData<Boolean> checkExistTitle(String title);

}
