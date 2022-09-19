package com.ahamed.digitalkot.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahamed.digitalkot.R;
import com.ahamed.digitalkot.entites.Pan;

import java.util.List;

public class PanAdapter extends RecyclerView.Adapter<PanAdapter.PanViewHolder> {

    private List<Pan> pizzaList;

    public PanAdapter(List<Pan> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public PanAdapter() {
    }

    @NonNull
    @Override
    public PanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_pan, parent, false);
        return new PanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PanViewHolder holder, int position) {
        Pan pan = pizzaList.get(position);
        holder.name.setText(pan.getItemName());
        holder.personal.setText(pan.getPersonalPrice());
        holder.medium.setText(pan.getMediumPrice());
        holder.family.setText(pan.getFamilyPrice());

    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public static class PanViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView personal;
        TextView medium;
        TextView family;

        public PanViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.id_pizzaName);
            personal = itemView.findViewById(R.id.tv_personal);
            medium = itemView.findViewById(R.id.tv_medium);
            family = itemView.findViewById(R.id.tv_family);

        }
    }
}
