package com.ahamed.digitalkot.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ahamed.digitalkot.entites.Pizza;

import java.util.List;

@Dao
public interface PanDao {

    @Insert
    void insertPan(Pizza pan);

    @Delete
    void deletePan(Pizza pan);

    @Update
    void updatePan(Pizza pan);

    @Query("select * from tbl_pan_pizza where item_type = 'Pan' ")
    LiveData<List<Pizza>> getAllPan();

    @Query("select * from tbl_pan_pizza where item_type = 'CB' ")
    LiveData<List<Pizza>> getAllCB();
}
