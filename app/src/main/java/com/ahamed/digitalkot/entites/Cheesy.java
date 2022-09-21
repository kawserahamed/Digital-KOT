package com.ahamed.digitalkot.entites;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_cb_pizza")
public class Cheesy {

    @PrimaryKey(autoGenerate = true)
    int id;
    @ColumnInfo(name = "item_name")
    String itemName;
    @ColumnInfo(name = "personal_price")
    int personalPrice;
    @ColumnInfo(name = "medium_price")
    int mediumPrice;
    @ColumnInfo(name = "family_price")
    int familyPrice;

    public Cheesy(String itemName, int personalPrice, int mediumPrice, int familyPrice) {
        this.itemName = itemName;
        this.personalPrice = personalPrice;
        this.mediumPrice = mediumPrice;
        this.familyPrice = familyPrice;
    }

    @Ignore
    public Cheesy(int id, String itemName, int personalPrice, int mediumPrice, int familyPrice) {
        this.id = id;
        this.itemName = itemName;
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
