package com.ahamed.digitalkot.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ahamed.digitalkot.entites.Pan;
import com.ahamed.digitalkot.repository.PanRepository;

import java.util.List;

public class PanViewModel extends AndroidViewModel {
    private PanRepository repository;

    public PanViewModel(@NonNull Application application) {
        super(application);
        repository = new PanRepository(application);
    }

    public void addPan(Pan pan) {
        repository.addPan(pan);
    }

    public void deletePan(Pan pan) {
        repository.deletePan(pan);
    }

    public void updatePan(Pan pan) {
        repository.updatePan(pan);
    }

    public LiveData<List<Pan>> getAllPanPizza() {
        return repository.getAllPanPizza();
    }
}
