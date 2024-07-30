package com.example.notesroom.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notesroom.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    TextView title, desc;

    Button delete, update;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title_text);
        desc = itemView.findViewById(R.id.desc_text);

        delete = itemView.findViewById(R.id.delete);
        update = itemView.findViewById(R.id.update);
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getDesc() {
        return desc;
    }

    public Button getDelete() {
        return delete;
    }

    public Button getUpdate() {
        return update;
    }
}
