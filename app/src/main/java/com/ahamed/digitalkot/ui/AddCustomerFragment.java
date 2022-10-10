package com.ahamed.digitalkot.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ahamed.digitalkot.R;
import com.ahamed.digitalkot.adapter.RvPanAdapter;
import com.ahamed.digitalkot.databinding.FragmentAddCustomerBinding;
import com.ahamed.digitalkot.entites.Pan;
import com.ahamed.digitalkot.listener.PizzaListener;
import com.ahamed.digitalkot.viewmodel.PanViewModel;

import java.util.ArrayList;
import java.util.List;


public class AddCustomerFragment extends Fragment implements PizzaListener {
    private AlertDialog alertDialog;
    private List<Pan> pizzaList;
    private RvPanAdapter adapter;


    public AddCustomerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        FragmentAddCustomerBinding binding = FragmentAddCustomerBinding.inflate(inflater);
        pizzaList = new ArrayList<>();

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_pan, null);
        RecyclerView recyclerView = dialogView.findViewById(R.id.rv_pan);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new RvPanAdapter(pizzaList, this);
        recyclerView.setAdapter(adapter);
        builder.setView(dialogView);
        alertDialog = builder.create();

        PanViewModel viewModel = new ViewModelProvider(requireActivity()).get(PanViewModel.class);
        viewModel.getAllPanPizza().observe(getViewLifecycleOwner(), pans -> {
            Log.d("TAG", "onClick: " + pans.size());
            pizzaList.clear();
            pizzaList.addAll(pans);
            adapter.notifyDataSetChanged();
        });

        binding.btnPan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.show();

            }
        });

        return binding.getRoot();
    }

    @Override
    public void actionListener(Pan pan) {

    }
}