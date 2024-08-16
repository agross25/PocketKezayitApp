package com.touro.pocketkezayit.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;

import com.touro.pocketkezayit.classes.MenuItemAdapter;
import com.touro.pocketkezayit.classes.OnMenuItemClickListener;
import com.touro.pocketkezayit.R;

public class MainActivity extends AppCompatActivity implements OnMenuItemClickListener {

    private final int [] menuImages = {R.drawable.cookies, R.drawable.assorted_candy, R.drawable.apples,
                                        R.drawable.peppers, R.drawable.assorted_breads, R.drawable.matzah_background};

    private final String [] menuItemHebrewNames = {"מזונות", "שהכל", "העץ", "האדמה", "המוציא", "פסח"};

    private final String [] menuItemEnglishNames = {"Grains", "Misc. Snacks", "Fruits", "Vegetables", "Breads", "Passover"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(findViewById(R.id.toolbar));

        // Create a reference to the RecyclerView in activity_main.xml
        RecyclerView recyclerView = findViewById((R.id.recycler_view));

        // Set number of column to 2 (or 4 for landscape)
        final int COLUMNS = getResources().getInteger(R.integer.rv_columns);

        // Create and set a Grid Layout Manager to use as the Layout Manager for this RV
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, COLUMNS);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Create and set an adapter to use as the Layout Manager for this RV
        MenuItemAdapter menuItemAdapter = new MenuItemAdapter(menuImages, menuItemHebrewNames, menuItemEnglishNames, this);
        recyclerView.setAdapter(menuItemAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onMenuItemClick(int position) {
        // Handle the click event, for example:
        Intent intent = new Intent(this, SubcategoryActivity.class);
        intent.putExtra("menu_position", position);
        intent.putExtra("menu_category", menuItemHebrewNames[position]);
        startActivity(intent);
    }

}