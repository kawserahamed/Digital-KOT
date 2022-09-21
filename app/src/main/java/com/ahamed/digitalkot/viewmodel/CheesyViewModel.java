package com.ahamed.digitalkot.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ahamed.digitalkot.entites.Cheesy;
import com.ahamed.digitalkot.repository.CheesyRepository;

import java.util.List;

public class CheesyViewModel extends AndroidViewModel {
    private CheesyRepository repository;

    public CheesyViewModel(@NonNull Application application) {
        super(application);
        repository = new CheesyRepository(application);
    }


    public void addCB(Cheesy cheesy) {
        repository.addCB(cheesy);
    }

    public void deleteCB(Cheesy cheesy) {
        repository.deleteCB(cheesy);
    }

    public void updateCB(Cheesy cheesy) {
        repository.updateCB(cheesy);
    }


    public LiveData<List<Cheesy>> getAllCb() {
        return repository.getAllCb();
    }
}
