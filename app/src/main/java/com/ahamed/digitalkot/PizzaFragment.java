package com.ahamed.digitalkot;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.ahamed.digitalkot.databinding.FragmentPizzaBinding;

import java.util.Objects;


public class PizzaFragment extends Fragment {

    public PizzaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentPizzaBinding binding = FragmentPizzaBinding.inflate(inflater, container, false);

        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        assert appCompatActivity != null;
        appCompatActivity.setSupportActionBar(binding.idToolbar);
        Objects.requireNonNull(appCompatActivity.getSupportActionBar()).setTitle("Pizza Settings");

        binding.tvPan.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.pizzaToPan));


        return binding.getRoot();
    }
}