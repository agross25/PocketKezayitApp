package com.touro.pocketkezayit.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.touro.pocketkezayit.classes.OnMenuItemClickListener;
import com.touro.pocketkezayit.R;
import com.touro.pocketkezayit.classes.SubcategoryAdapter;
import com.touro.pocketkezayit.classes.SubcategoryItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubcategoryActivity extends AppCompatActivity implements OnMenuItemClickListener {

    private final String[] csvFiles = {"mezonos_list.csv", "shehakol_list.csv", "haeitz_list.csv", "haadama_list.csv", "hamotzi_list.csv", "pesach_list.csv"};
    private List<SubcategoryItem> itemsInfo;
    private int[] itemImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subcategory_activity);
        setSupportActionBar(findViewById(R.id.toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeActionContentDescription("Back");
        }

        // Create a reference to the RecyclerView in subcategory_main.xml
        RecyclerView recyclerView = findViewById((R.id.sub_recycler_view));

        // Set number of column to 2 (or 4 for landscape)
        final int COLUMNS = getResources().getInteger(R.integer.rv_subcategory_columns);

        // Create and set a Grid Layout Manager to use as the Layout Manager for this RV
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, COLUMNS);
        recyclerView.setLayoutManager(gridLayoutManager);

        // Get data based on what the user clicked
        String categoryName = getIntent().getStringExtra("menu_category");
        TextView tvBanner = findViewById(R.id.category_title);
        tvBanner.setText(categoryName);

        int menuPosition = getIntent().getIntExtra("menu_position", -1);
        itemsInfo = readCSV(csvFiles[menuPosition]);
        String[] itemNames = getNames(itemsInfo);
        itemImages = getImages(menuPosition, itemNames.length);

        SubcategoryAdapter adapter = new SubcategoryAdapter(itemImages, itemNames, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onMenuItemClick(int position) {
        // Handle the click event for the sub-menu items
        Intent intent = new Intent(this, FinalViewActivity.class);

        String itemName = itemsInfo.get(position).getName();
        String itemQuantity = itemsInfo.get(position).getQuantity();
        String itemWeight = itemsInfo.get(position).getWeight();

        intent.putExtra("item_name", itemName);
        intent.putExtra("item_quantity", itemQuantity);
        intent.putExtra("item_weight", itemWeight);
        intent.putExtra("item_image", itemImages[position]);

        // tell finalActivity what the name of this food is and its picture
        startActivity(intent);
    }

    public List<SubcategoryItem> readCSV(String csvFilePath) {
        String line = "";
        String csvDelimiter = ",";
        // List to hold all items of this category
        List<SubcategoryItem> itemsList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open(csvFilePath)))) {
            int currentRow = 0;

            while ((line = br.readLine()) != null) {
                currentRow++;
                String[] fields = line.split(csvDelimiter);

                // Skip the first row (column names)
                if (currentRow > 1) {
                    // Handle rows with fewer columns than expected
                    SubcategoryItem newItem = new SubcategoryItem();
                    for (int i = 0; i < fields.length; i++) {
                        // Account for potential null values
                        if (fields[i] == null) {
                            fields[i] = "";
                        }
                        // Remove potential quotation marks
                        String field = fields[i].replace("\"", "");

                        switch (i) {
                            case 0:
                                newItem.setName(field);
                                break;
                            case 1:
                                newItem.setQuantity(field);
                                break;
                            case 2:
                                newItem.setWeight(field);
                                break;
                            case 3:
                                newItem.setCategory(field);
                                break;
                            default:
                                break;
                        }
                    }
                    itemsList.add(newItem);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemsList;
    }

    public String[] getNames(List<SubcategoryItem> itemList) {
        String[] names = new String[itemList.size()];

        for (int i = 0; i < itemList.size(); i++) {
            names[i] = itemList.get(i).getName();
        }

        return names;
    }

    public int[] getImages(int position, int len) {
        int[] images = new int[len];

        switch (position) {
            case 0: // Mezonos
                images = new int[]{R.drawable.animal_crackers, R.drawable.b_w_cookies, R.drawable.breadsticks, R.drawable.cheerios, R.drawable.cc_cookies,
                        R.drawable.cupcakes, R.drawable.donuts, R.drawable.eclairs, R.drawable.flat_crackers, R.drawable.franks_n_blanks, R.drawable.grahams,
                        R.drawable.muffins, R.drawable.oatmeal, R.drawable.pasta, R.drawable.pie, R.drawable.pizza, R.drawable.pound_cake, R.drawable.nuggets,
                        R.drawable.pretzel_rods, R.drawable.pretzel_sticks, R.drawable.pretzels, R.drawable.rice, R.drawable.rugalah, R.drawable.saltines,
                        R.drawable.oreos, R.drawable.seven_layer, R.drawable.snackers, R.drawable.tea_biscuits};
                break;
            case 1: // Shehakol
                images = new int[]{R.drawable.cheese, R.drawable.bamba, R.drawable.candy_corn, R.drawable.chocolate, R.drawable.corn_chips, R.drawable.egg,
                        R.drawable.gumdrops, R.drawable.gummy_worms, R.drawable.hot_dogs, R.drawable.jelly_beans, R.drawable.gummy_fish, R.drawable.taffies,
                        R.drawable.twizzlers, R.drawable.licorice_bites, R.drawable.licorice_nibs, R.drawable.mike_n_ikes, R.drawable.onion_rings, R.drawable.salami,
                        R.drawable.tortilla_chips, R.drawable.yogurt};
                break;
            case 2: // Haeitz
                images = new int[]{R.drawable.almonds, R.drawable.apples, R.drawable.blueberries, R.drawable.cashews, R.drawable.cherries, R.drawable.dates, R.drawable.grapes,
                        R.drawable.nectarines, R.drawable.olives, R.drawable.oranges, R.drawable.pistachios, R.drawable.plums, R.drawable.raisins, R.drawable.tangerines};
                break;
            case 3: // Haadama
                images = new int[]{R.drawable.baby_carrots, R.drawable.bananas, R.drawable.cantaloupe, R.drawable.cherry_tomatoes, R.drawable.chickpeas, R.drawable.cornflakes,
                        R.drawable.fries, R.drawable.granola_bar, R.drawable.lettuce, R.drawable.peanuts, R.drawable.peppers, R.drawable.pickles, R.drawable.popcorn,
                        R.drawable.potato_chips, R.drawable.pringles, R.drawable.rice_cakes};
                break;
            case 4: // Hamotzi
                images = new int[]{R.drawable.bagels, R.drawable.challah_rolls, R.drawable.matzah_background, R.drawable.onion_rolls, R.drawable.pita, R.drawable.pizza,
                        R.drawable.rye_bread, R.drawable.white_bread};
                break;
            case 5: // Pesach
                images = new int[]{R.drawable.endives, R.drawable.horseradish, R.drawable.romaine, R.drawable.matzah, R.drawable.korech, R.drawable.afikoman};
            default:
                break;
        }
        return images;
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
