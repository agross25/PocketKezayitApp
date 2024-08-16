package com.touro.pocketkezayit.classes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.touro.pocketkezayit.R;

public class SubcategoryAdapter extends RecyclerView.Adapter<SubcategoryViewHolder> {

    private final int [] itemImages;
    private final String [] itemNames;
    private final OnMenuItemClickListener listener;

    public SubcategoryAdapter(int[] images, String[] names, OnMenuItemClickListener listener)
    {
        this.itemImages = images;
        this.itemNames = names;
        this.listener = listener;
    }

    @NonNull
    public SubcategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // Make one tile - this will be called repeatedly
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_subcategory_item, parent, false);
        return new SubcategoryViewHolder(itemView, listener);
    }

    public void onBindViewHolder(@NonNull SubcategoryViewHolder holder, int position)
    {
        // Insert into this tile the image and names we are up to
        holder.imageView.setImageResource(itemImages[position]);
        holder.textView.setText(itemNames[position]);
    }

    // Get menu item count
    public int getItemCount() { return itemNames.length; }

}
