package com.ahamed.digitalkot.entites;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_pan_pizza")
public class Pizza {

    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "item_name")
    String itemName;
    @ColumnInfo(name = "item_type")
    String pizzaType;
    @ColumnInfo(name = "personal_price")
    int personalPrice;
    @ColumnInfo(name = "medium_price")
    int mediumPrice;
    @ColumnInfo(name = "family_price")
    int familyPrice;

    public Pizza(String itemName, String pizzaType, int personalPrice, int mediumPrice, int familyPrice) {
        this.itemName = itemName;
        this.pizzaType = pizzaType;
        this.personalPrice = personalPrice;
        this.mediumPrice = mediumPrice;
        this.familyPrice = familyPrice;
    }

    @Ignore
    public Pizza(int id, String itemName, String pizzaType, int personalPrice, int mediumPrice, int familyPrice) {
        this.id = id;
        this.itemName = itemName;
        this.pizzaType = pizzaType;
        this.personalPrice = personalPrice;
        this.mediumPrice = mediumPrice;
        this.familyPrice = familyPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    public int getPersonalPrice() {
        return personalPrice;
    }

    public void setPersonalPrice(int personalPrice) {
        this.personalPrice = personalPrice;
    }

    public int getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(int mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public int getFamilyPrice() {
        return familyPrice;
    }

    public void setFamilyPrice(int familyPrice) {
        this.familyPrice = familyPrice;
    }
}
