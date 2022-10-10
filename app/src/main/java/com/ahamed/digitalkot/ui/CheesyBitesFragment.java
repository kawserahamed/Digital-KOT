package com.ahamed.digitalkot.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ahamed.digitalkot.R;
import com.ahamed.digitalkot.adapter.CBAdapter;
import com.ahamed.digitalkot.databinding.FragmentCheesyBitesBinding;
import com.ahamed.digitalkot.entites.Cheesy;
import com.ahamed.digitalkot.listener.CBListener;
import com.ahamed.digitalkot.viewmodel.CheesyViewModel;

import java.util.ArrayList;
import java.util.List;

public class CheesyBitesFragment extends Fragment implements CBListener {
    private AlertDialog alertDialog;
    private CheesyViewModel viewModel;
    private CBAdapter adapter;

    public CheesyBitesFragment() {
        // Required empty public constructor
    }


    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentCheesyBitesBinding binding = FragmentCheesyBitesBinding.inflate(inflater, container, false);
        List<Cheesy> pizzaList = new ArrayList<>();

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View dialogView = getLayoutInflater().inflate(R.layout.dailog_add_cb, null);
        builder.setView(dialogView);
        alertDialog = builder.create();
        binding.btnAdd.setOnClickListener(view -> alertDialog.show());

        binding.rvAllCV.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new CBAdapter(pizzaList, this);
        binding.rvAllCV.setAdapter(adapter);

        viewModel = new ViewModelProvider(requireActivity()).get(CheesyViewModel.class);
        viewModel.getAllCb().observe(getViewLifecycleOwner(), cheesies -> {
            pizzaList.clear();
            pizzaList.addAll(cheesies);
            adapter.notifyDataSetChanged();
        });

        Button submit = dialogView.findViewById(R.id.cv_btn_ok);
        Button cancel = dialogView.findViewById(R.id.cv_btn_cancel);
        EditText name = dialogView.findViewById(R.id.tv_cv_name);
        EditText ed_personal = dialogView.findViewById(R.id.cv_personal_price);
        EditText ed_medium = dialogView.findViewById(R.id.cv_medium_price);
        EditText ed_family = dialogView.findViewById(R.id.cv_family_price);

        submit.setOnClickListener(view -> {
            int personal;
            int medium;
            int family;

            String itemName = name.getText().toString();
            if (TextUtils.isEmpty(itemName)) {
                name.setError("Can't be empty");
                return;
            }

            if (TextUtils.isEmpty(ed_personal.getText())) {
                personal = 0;
            } else {
                personal = Integer.parseInt(ed_personal.getText().toString());
            }

            if (TextUtils.isEmpty(ed_medium.getText())) {
                medium = 0;
            } else {
                medium = Integer.parseInt(ed_medium.getText().toString());
            }

            if (TextUtils.isEmpty(ed_family.getText())) {
                family = 0;
            } else {
                family = Integer.parseInt(ed_family.getText().toString());
            }

            alertDialog.dismiss();
            dataSend(itemName, personal, medium, family);
            name.setText(null);
            name.setError(null);
            ed_personal.setText(null);
            ed_medium.setText(null);
            ed_family.setText(null);
        });
        cancel.setOnClickListener(view -> {
            alertDialog.dismiss();
            name.setText(null);
            name.setError(null);
            ed_personal.setText(null);
            ed_medium.setText(null);
            ed_family.setText(null);
        });

        return binding.getRoot();
    }

    private void dataSend(String itemName, int personal, int medium, int family) {
        Cheesy cheesy = new Cheesy(itemName, personal, medium, family);
        viewModel.addCB(cheesy);
        Toast.makeText(getContext(), "Item Added", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void actionListener(Cheesy cheesy) {
        viewModel.deleteCB(cheesy);
    }
}