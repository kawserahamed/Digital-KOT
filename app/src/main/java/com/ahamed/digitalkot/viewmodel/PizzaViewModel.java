package com.ahamed.digitalkot.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ahamed.digitalkot.entites.Pizza;
import com.ahamed.digitalkot.repository.PanRepository;

import java.util.List;

public class PizzaViewModel extends AndroidViewModel {
    private PanRepository repository;

    public PizzaViewModel(@NonNull Application application) {
        super(application);
        repository = new PanRepository(application);
    }

    public void addPan(Pizza pan) {
        repository.addPan(pan);
    }

    public void deletePan(Pizza pan) {
        repository.deletePan(pan);
    }

    public void updatePan(Pizza pan) {
        repository.updatePan(pan);
    }

    public LiveData<List<Pizza>> getAllPanPizza() {
        return repository.getAllPanPizza();
    }

    public LiveData<List<Pizza>> getAllCB() {
        return repository.getAllCB();
    }
}
