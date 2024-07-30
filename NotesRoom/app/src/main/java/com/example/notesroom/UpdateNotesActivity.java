package com.example.notesroom;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.notesroom.data.entity.Note;
import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;

public class UpdateNotesActivity extends AppCompatActivity {

    Note note;

    TextInputLayout title, desc;

    Button update_button, cancel_button;

    UpdateNotesViewModel updateNotesViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_notes);

        updateNotesViewModel = new ViewModelProvider(this).get(UpdateNotesViewModel.class);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("note")) {
            note = (Note) intent.getSerializableExtra("note");
        }

        getSupportActionBar().setTitle("Update Notes");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        populateEditText();

        update_button = findViewById(R.id.update_button);
        cancel_button = findViewById(R.id.cancel_button);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note newNote = new Note(title.getEditText().getText().toString(), desc.getEditText().getText().toString());
                newNote.setId(note.getId());
                updateNotesViewModel.update(newNote);
                finish();
                Toast.makeText(getApplicationContext(), "Success Updated", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void populateEditText(){
        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);

        if (note != null) {
            title.getEditText().setText(note.getTitle());
            desc.getEditText().setText(note.getDesc());
        }
    }
}