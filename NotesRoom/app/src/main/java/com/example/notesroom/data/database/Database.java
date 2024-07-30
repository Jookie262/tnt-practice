package com.example.notesroom.data.database;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.notesroom.data.dao.NotesDAO;
import com.example.notesroom.data.entity.Note;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@androidx.room.Database(entities = {Note.class}, version = 1)
public abstract class Database extends RoomDatabase {

    public abstract NotesDAO notesDAO();

    public static Database INSTANCE;

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static Database getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            Database.class, "notes_database").build();
                }
            }
        }
        return INSTANCE;
    };
}
