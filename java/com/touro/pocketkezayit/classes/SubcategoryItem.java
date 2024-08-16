package com.touro.pocketkezayit.classes;

public class SubcategoryItem {

    private String name;
    private String quantity;
    private String weight;
    private String category;

    public SubcategoryItem()
    {
        this.name = "";
        this.quantity = "";
        this.weight = "";
        this.category = "";
    }

    // Setters
    public void setName(String name) { this.name = name; }

    public void setQuantity(String quantity) { this.quantity = quantity; }

    public void setWeight(String weight) { this.weight = weight; }

    public void setCategory(String category) { this.category = category; }

    // Getters
    public String getName() { return name; }

    public String getQuantity() { return quantity; }

    public String getWeight() { return weight; }

    public String getCategory() { return category; }

}
