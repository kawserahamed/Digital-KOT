package com.ahamed.digitalkot.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.ahamed.digitalkot.R;
import com.ahamed.digitalkot.databinding.FragmentSettingBinding;

import java.util.Objects;


public class SettingFragment extends Fragment {
    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSettingBinding binding = FragmentSettingBinding.inflate(inflater, container, false);

        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        assert appCompatActivity != null;
        appCompatActivity.setSupportActionBar(binding.idToolbar);
        Objects.requireNonNull(appCompatActivity.getSupportActionBar()).setTitle("Settings");


        binding.tvPan.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.settingToPan));
        binding.tvCheesy.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.settingToCB));
        binding.tvSausage.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.settingToSausage));
        binding.tvThin.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.settingToTC));

        return binding.getRoot();
    }
}