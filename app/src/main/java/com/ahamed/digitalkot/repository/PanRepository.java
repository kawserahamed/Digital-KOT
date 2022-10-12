package com.ahamed.digitalkot.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.ahamed.digitalkot.dao.PanDao;
import com.ahamed.digitalkot.database.PanPizzaDatabase;
import com.ahamed.digitalkot.entites.Pizza;

import java.util.List;

public class PanRepository {

    private PanDao panDao;

    public PanRepository(Context context) {
        panDao = PanPizzaDatabase.getDatabase(context).getPanDao();
    }

    public void addPan(Pizza pan) {
        panDao.insertPan(pan);
    }

    public void deletePan(Pizza pan) {
        panDao.deletePan(pan);
    }

    public void updatePan(Pizza pan) {
        panDao.updatePan(pan);
    }

    public LiveData<List<Pizza>> getAllPanPizza() {
        return panDao.getAllPan();
    }
    public LiveData<List<Pizza>> getAllCB() {
        return panDao.getAllCB();
    }
}
