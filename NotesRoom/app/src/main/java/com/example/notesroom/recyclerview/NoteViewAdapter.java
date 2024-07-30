package com.example.notesroom.recyclerview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesroom.MainActivityViewModel;
import com.example.notesroom.R;
import com.example.notesroom.UpdateNotesActivity;
import com.example.notesroom.data.entity.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteViewAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    MainActivityViewModel mainActivityViewModel;
    Context context;

    private List<Note> noteList = new ArrayList<>();

    public NoteViewAdapter(Context context, MainActivityViewModel mainActivityViewModel){
        this.context = context;
        this.mainActivityViewModel = mainActivityViewModel;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_layout, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note current = noteList.get(position);
        holder.getTitle().setText(current.getTitle());
        holder.getDesc().setText(current.getDesc());

        holder.getUpdate().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, UpdateNotesActivity.class);
                i.putExtra("note", current);
                context.startActivity(i);
            }
        });

        holder.getDelete().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setMessage("Do you want to delete");

                // Add the buttons.
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mainActivityViewModel.delete(current);
                        Toast.makeText(context, "Delete Success", Toast.LENGTH_LONG).show();
                    }
                });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });


                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
        notifyDataSetChanged();
    }
}

