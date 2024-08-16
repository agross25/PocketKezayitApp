package com.touro.pocketkezayit.classes;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.touro.pocketkezayit.R;

public class SubcategoryViewHolder extends RecyclerView.ViewHolder {

    CardView cardView;
    ImageView imageView;
    TextView textView;

    public SubcategoryViewHolder(@NonNull View itemView, OnMenuItemClickListener listener)
    {
        super(itemView);
        cardView = itemView.findViewById(R.id.sub_card_view);
        imageView = itemView.findViewById(R.id.item_image);
        textView = itemView.findViewById(R.id.item_name);

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
