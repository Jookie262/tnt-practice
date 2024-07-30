package com.example.recyclerviewsample.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewsample.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView name, desc;

    CardView cardView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.pic);
        name = itemView.findViewById(R.id.name);
        desc = itemView.findViewById(R.id.desc);
        cardView = itemView.findViewById(R.id.cardview);

    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getName() {
        return name;
    }

    public TextView getDesc() {
        return desc;
    }

    public CardView getCardView() {
        return cardView;
    }
}
