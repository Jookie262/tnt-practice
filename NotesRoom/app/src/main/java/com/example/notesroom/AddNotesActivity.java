package com.example.notesroom;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesroom.data.entity.Note;
import com.google.android.material.textfield.TextInputLayout;

public class AddNotesActivity extends AppCompatActivity {

    AddNotesViewModel addNotesViewModel;

    Button cancel_button, save_button;

    TextInputLayout title, desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notes);
        addNotesViewModel = new ViewModelProvider(this).get(AddNotesViewModel.class);

        getSupportActionBar().setTitle("Add Notes");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cancel_button = findViewById(R.id.cancel_button);
        save_button = findViewById(R.id.save_button);
        title = findViewById(R.id.title);
        desc = findViewById(R.id.desc);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertNote();
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


    public void insertNote(){
        String getTitle = title.getEditText().getText().toString();
        String getdesc = desc.getEditText().getText().toString();

        if(getTitle.isEmpty()){
            title.setError("Please Input Title");
        }else{
            title.setError(null);
        }

        if(getdesc.isEmpty()){
            desc.setError("Please Input Description");
        } else {
            desc.setError(null);
        }

        if(!getTitle.isEmpty() && !getdesc.isEmpty()){


            addNotesViewModel.checkExistTitle(getTitle).observe(this, exist ->{
                if(!exist){
                    Note note = new Note(getTitle, getdesc);
                    addNotesViewModel.insert(note);
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Cannot Insert Title already exist", Toast.LENGTH_LONG).show();
                }
            });


        }
    }
}