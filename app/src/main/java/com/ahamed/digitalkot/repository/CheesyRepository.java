package com.ahamed.digitalkot.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.ahamed.digitalkot.dao.CbDao;
import com.ahamed.digitalkot.database.CbDatabase;
import com.ahamed.digitalkot.entites.Cheesy;

import java.util.List;

public class CheesyRepository {

    CbDao cbDao;

    public CheesyRepository(Context context) {
        cbDao = CbDatabase.getDatabase(context).getCBDao();
    }

    public void addCB(Cheesy cheesy) {
        cbDao.insertCB(cheesy);
    }

    public void deleteCB(Cheesy cheesy) {
        cbDao.deleteCB(cheesy);
    }

    public void updateCB(Cheesy cheesy) {
        cbDao.updateCB(cheesy);
    }


    public LiveData<List<Cheesy>> getAllCb() {
        return cbDao.getAllCB();
    }
}
