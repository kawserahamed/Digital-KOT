package com.ahamed.digitalkot.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.ahamed.digitalkot.dao.PanDao;
import com.ahamed.digitalkot.database.PanPizzaDatabase;
import com.ahamed.digitalkot.entites.Pan;

import java.util.List;

public class PanRepository {

    private PanDao panDao;

    public PanRepository(Context context) {
        panDao = PanPizzaDatabase.getDatabase(context).getPanDao();
    }

    public void addPan(Pan pan) {
        panDao.insertPan(pan);
    }

    public void deletePan(Pan pan) {
        panDao.deletePan(pan);
    }

    public void updatePan(Pan pan) {
        panDao.updatePan(pan);
    }

    public LiveData<List<Pan>> getAllPanPizza() {
        return panDao.getAllPan();
    }
}
