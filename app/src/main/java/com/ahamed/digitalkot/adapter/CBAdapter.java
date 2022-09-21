package com.ahamed.digitalkot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahamed.digitalkot.databinding.LayoutItemCbBinding;
import com.ahamed.digitalkot.entites.Cheesy;

import java.util.List;

public class CBAdapter extends RecyclerView.Adapter<CBAdapter.CBViewHolder> {
    List<Cheesy> pizzaList;

    public CBAdapter(List<Cheesy> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public CBAdapter() {
    }

    @NonNull
    @Override
    public CBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)
                parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LayoutItemCbBinding binding = LayoutItemCbBinding.inflate(inflater, parent, false);
        return new CBViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CBViewHolder holder, int position) {
        Cheesy cheesy = pizzaList.get(position);
        holder.bind(cheesy);
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    class CBViewHolder extends RecyclerView.ViewHolder {
        private final LayoutItemCbBinding binding;

        public CBViewHolder(@NonNull LayoutItemCbBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Cheesy cheesy) {
            binding.setPizza(cheesy);
        }
    }
}
