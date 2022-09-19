package com.ahamed.digitalkot.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
        Log.d("TAG", "dataSend: " + itemName + personal + medium + family);
    }


}