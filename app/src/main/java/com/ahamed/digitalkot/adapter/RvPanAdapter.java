package com.ahamed.digitalkot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahamed.digitalkot.databinding.LayoutRvPanBinding;
import com.ahamed.digitalkot.entites.Pan;

import java.util.List;

public class RvPanAdapter extends RecyclerView.Adapter<RvPanAdapter.RvPanViewHolder> {
    private List<Pan> pizzaList;

    public RvPanAdapter(List<Pan> pizzaList) {
        this.pizzaList = pizzaList;
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
