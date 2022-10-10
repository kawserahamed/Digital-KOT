package com.ahamed.digitalkot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ahamed.digitalkot.databinding.LayoutRvPanBinding;
import com.ahamed.digitalkot.entites.Pan;
import com.ahamed.digitalkot.listener.PizzaListener;

import java.util.List;

public class RvPanAdapter extends RecyclerView.Adapter<RvPanAdapter.RvPanViewHolder> {
    private List<Pan> pizzaList;
    private PizzaListener listener;

    public RvPanAdapter(List<Pan> pizzaList, Fragment fragment) {
        this.pizzaList = pizzaList;
        this.listener = (PizzaListener) fragment;
    }

    public RvPanAdapter() {
    }

    @NonNull
    @Override
    public RvPanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LayoutRvPanBinding binding = LayoutRvPanBinding.inflate(inflater, parent, false);

        return new RvPanViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RvPanViewHolder holder, int position) {
        final Pan pan = pizzaList.get(position);
        holder.bind(pan);
        holder.itemView.setOnClickListener(view -> listener.actionListener(pan));


    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public static class RvPanViewHolder extends RecyclerView.ViewHolder {

        LayoutRvPanBinding binding;

        public RvPanViewHolder(@NonNull LayoutRvPanBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Pan pan) {
            binding.setPizza(pan);
        }
    }
}
