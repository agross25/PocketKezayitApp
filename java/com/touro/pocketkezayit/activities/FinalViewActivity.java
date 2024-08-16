package com.touro.pocketkezayit.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.touro.pocketkezayit.R;
import com.touro.pocketkezayit.classes.SubcategoryItem;

public class FinalViewActivity extends AppCompatActivity {

    private TextView titleTextView;
    private TextView infoTextView;
    private ImageView imageView;

    // Will show the user the specific data for the chosen food
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_view_activity);
        setSupportActionBar(findViewById(R.id.final_toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeActionContentDescription("Back");
        }

        // Initialize UI components
        titleTextView = findViewById(R.id.item_title);
        infoTextView = findViewById(R.id.item_info);
        imageView = findViewById(R.id.item_image);

        // Get the item info from the intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("item_name");
        String quantity = intent.getStringExtra("item_quantity");
        String weight = intent.getStringExtra("item_weight");
        int image = intent.getIntExtra("item_image", -1);

        // Display appropriate information based on item info
        displayInfo(name, quantity, weight, image);
    }

    private void displayInfo(String name, String quantity, String weight, int image) {

        titleTextView.setText(name);
        String info = "";
        if (!quantity.isEmpty())
        { info+= "Quantity: " + quantity; }
        if (!weight.isEmpty())
        { info += "\nWeight: " + weight; }
        infoTextView.setText(info);
        imageView.setImageResource(image);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }
}
