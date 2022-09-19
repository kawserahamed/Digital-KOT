package com.ahamed.digitalkot.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.ahamed.digitalkot.R;
import com.ahamed.digitalkot.databinding.FragmentPanBinding;


public class PanFragment extends Fragment {
    AlertDialog alertDialog;

    public PanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentPanBinding binding = FragmentPanBinding.inflate(inflater);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        View dialogView = getLayoutInflater().inflate(R.layout.dailog_add_pizza, null);
        builder.setView(dialogView);
       // builder.setTitle("Enter your Item");
        alertDialog = builder.create();

        binding.btnAdd.setOnClickListener(view -> alertDialog.show());

        Button submit = dialogView.findViewById(R.id.btn_ok);
        Button cancel = dialogView.findViewById(R.id.btn_cancel);
        EditText name = dialogView.findViewById(R.id.tv_item_name);
        EditText ed_personal = dialogView.findViewById(R.id.tv_personal_price);
        EditText ed_medium = dialogView.findViewById(R.id.tv_medium_price);
        EditText ed_family = dialogView.findViewById(R.id.tv_family_price);

        submit.setOnClickListener(view -> {
            String itemName = name.getText().toString();
            int personal = Integer.parseInt(ed_personal.getText().toString());
            int medium = Integer.parseInt(ed_medium.getText().toString());
            int family = Integer.parseInt(ed_family.getText().toString());

            alertDialog.dismiss();

            name.setText(null);
            ed_personal.setText(null);
            ed_medium.setText(null);
            ed_family.setText(null);

        });

        cancel.setOnClickListener(view -> {
            alertDialog.dismiss();

            name.setText(null);
            ed_personal.setText(null);
            ed_medium.setText(null);
            ed_family.setText(null);

        });


        return binding.getRoot();
    }


}