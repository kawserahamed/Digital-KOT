package com.ahamed.digitalkot.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    private TextView itemSelectName;
    private Pan clickedItem;
    private Spinner spinner;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private int price;
    private int finalPrice = 0;
    private RecyclerView recyclerView;


    public AddCustomerFragment() {
        // Required empty public constructor
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentAddCustomerBinding binding = FragmentAddCustomerBinding.inflate(inflater);

        pizzaList = new ArrayList<>();

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_pan, null);

        itemSelectName = dialogView.findViewById(R.id.tv_selected_item);
        TextView cancel = dialogView.findViewById(R.id.btn_close);
        TextView okay = dialogView.findViewById(R.id.btn_okay);
        spinner = dialogView.findViewById(R.id.spQuantity);
        radioGroup = dialogView.findViewById(R.id.radioGroup);
        recyclerView = dialogView.findViewById(R.id.rv_pan);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        builder.setView(dialogView);
        alertDialog = builder.create();

        adapter = new RvPanAdapter(pizzaList, this);
        recyclerView.setAdapter(adapter);

        PanViewModel viewModel = new ViewModelProvider(requireActivity()).get(PanViewModel.class);
        viewModel.getAllPanPizza().observe(getViewLifecycleOwner(), pans -> {
            Log.d("TAG", "onClick: " + pans.size());
            pizzaList.clear();
            pizzaList.addAll(pans);
            adapter.notifyDataSetChanged();
        });

        binding.btnPan.setOnClickListener(view -> alertDialog.show());

        cancel.setOnClickListener(view -> alertDialog.cancel());

        okay.setOnClickListener(view -> {

            String strItem = itemSelectName.getText().toString();
            if (TextUtils.isEmpty(strItem)) {
                Toast.makeText(getContext(), "Select your Item", Toast.LENGTH_SHORT).show();
                return;
            }
            String strQuantity = spinner.getSelectedItem().toString();
            int intQuantity = Integer.parseInt(strQuantity);
            int radioId = radioGroup.getCheckedRadioButtonId();
            radioButton = dialogView.findViewById(radioId);

            if (radioButton.getText().equals("Personal")) {
                price = intQuantity * clickedItem.getPersonalPrice();
            } else if (radioButton.getText().equals("Medium")) {
                price = intQuantity * clickedItem.getMediumPrice();
            } else if (radioButton.getText().equals("Family")) {
                price = intQuantity * clickedItem.getFamilyPrice();
            }
            Toast.makeText(getContext(), "" + price, Toast.LENGTH_SHORT).show();
            finalPrice = finalPrice + price;
            binding.tvPrice.setText(String.valueOf(finalPrice));
            alertDialog.cancel();
            radioGroup.check(R.id.rMedium);
            spinner.setSelection(0);
            itemSelectName.setText(null);
            recyclerView.scrollToPosition(0);

        });

        return binding.getRoot();
    }

    @Override
    public void actionListener(Pan pan) {
        clickedItem = pan;
        itemSelectName.setText(clickedItem.getItemName());
    }
}