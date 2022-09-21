package com.ahamed.digitalkot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahamed.digitalkot.databinding.LayoutItemPanBinding;
import com.ahamed.digitalkot.entites.Pan;

import java.util.List;

public class PanPizzaAdapter extends RecyclerView.Adapter<PanPizzaAdapter.PanPizzaViewHolder> {
    private List<Pan> pizzaList;

    public PanPizzaAdapter(List<Pan> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public PanPizzaAdapter() {
    }

    @NonNull
    @Override
    public PanPizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)
                parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LayoutItemPanBinding binding = LayoutItemPanBinding.inflate(inflater, parent, false);
        return new PanPizzaViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PanPizzaViewHolder holder, int position) {
        final Pan pizza = pizzaList.get(position);
        holder.bind(pizza);
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public static class PanPizzaViewHolder extends RecyclerView.ViewHolder {
        private final LayoutItemPanBinding binding;

        public PanPizzaViewHolder(@NonNull LayoutItemPanBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
           this.binding.btnMore.setOnClickListener(view -> {



           });
        }

        public void bind(Pan panPizza) {
            binding.setPizza(panPizza);
        }
    }
}
