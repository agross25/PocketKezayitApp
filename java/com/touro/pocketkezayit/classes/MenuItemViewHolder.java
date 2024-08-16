package com.touro.pocketkezayit.classes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.touro.pocketkezayit.R;

public class MenuItemViewHolder extends RecyclerView.ViewHolder {

    CardView cardView;
    ImageView imageView;
    TextView hebrewTextView;
    TextView englishTextView;

    public MenuItemViewHolder(@NonNull View itemView, OnMenuItemClickListener listener)
    {
        super(itemView);
        cardView = itemView.findViewById(R.id.card_view);
        imageView = itemView.findViewById(R.id.menu_image);
        hebrewTextView = itemView.findViewById(R.id.menu_item_hebrew);
        englishTextView = itemView.findViewById(R.id.menu_item_english);

        itemView.setOnClickListener(v -> {
            if (listener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onMenuItemClick(position);
                }
            }
        });
    }
}
