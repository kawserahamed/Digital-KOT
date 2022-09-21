package com.ahamed.digitalkot.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.ahamed.digitalkot.entites.Cheesy;
import com.ahamed.digitalkot.entites.Pan;

import java.util.List;

@Dao
public interface CbDao {

    @Insert
    void insertCB(Cheesy cheesy);

    @Delete
    void deleteCB(Cheesy cheesy);

    @Update
    void updateCB(Cheesy cheesy);

    @Query("select * from tbl_cb_pizza")
    LiveData<List<Cheesy>> getAllCB();
}
