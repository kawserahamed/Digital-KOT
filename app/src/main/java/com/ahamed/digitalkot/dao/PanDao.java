package com.ahamed.digitalkot.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ahamed.digitalkot.entites.Pan;

import java.util.List;

@Dao
public interface PanDao {

    @Insert
    void insertPan(Pan pan);

    @Delete
    void deletePan(Pan pan);

    @Update
    void updatePan(Pan pan);

    @Query("select * from tbl_pan_pizza")
    LiveData<List<Pan>> getAllPan();
}
