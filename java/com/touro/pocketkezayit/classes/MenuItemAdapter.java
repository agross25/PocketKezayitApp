package com.touro.pocketkezayit.classes;

import android.view.LayoutInflater;

import com.touro.pocketkezayit.R;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MenuItemAdapter extends RecyclerView.Adapter<MenuItemViewHolder> {

    private final int [] menuImages;
    private final String [] menuItemHebrewNames;
    private final String [] menuItemEnglishNames;
    private final OnMenuItemClickListener listener;

    public MenuItemAdapter(int[] images, String[] hebrewNames, String[] englishNames, OnMenuItemClickListener listener)
    {
        this.menuImages = images;
        this.menuItemHebrewNames = hebrewNames;
        this.menuItemEnglishNames = englishNames;
        this.listener = listener;
    }

    @NonNull
    public MenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        // Make one tile - this will be called repeatedly
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_menu_item, parent, false);
        return new MenuItemViewHolder(itemView, listener);
    }

    public void onBindViewHolder(@NonNull MenuItemViewHolder holder, int position)
    {
        // Insert into this tile the image and names we are up to
        holder.imageView.setImageResource(menuImages[position]);
        holder.hebrewTextView.setText(menuItemHebrewNames[position]);
        holder.englishTextView.setText(menuItemEnglishNames[position]);
    }

    // Get menu item count
    public int getItemCount() { return menuImages.length; }

}
