package com.ahamed.digitalkot.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ahamed.digitalkot.R;
import com.ahamed.digitalkot.databinding.LayoutItemCbBinding;
import com.ahamed.digitalkot.entites.Pizza;
import com.ahamed.digitalkot.listener.PizzaListener;

import java.util.List;

public class CBAdapter extends RecyclerView.Adapter<CBAdapter.CBViewHolder> {
    private List<Pizza> pizzaList;
    private PizzaListener listener;

    public CBAdapter(List<Pizza> pizzaList, Fragment fragment) {
        this.pizzaList = pizzaList;
        this.listener = (PizzaListener) fragment;
    }

    public CBAdapter() {
    }

    @NonNull
    @Override
    public CBViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final LayoutItemCbBinding binding = LayoutItemCbBinding.inflate(inflater, parent, false);
        return new CBViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CBViewHolder holder, int position) {
        Pizza cheesy = pizzaList.get(position);
        holder.bind(cheesy);
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public class CBViewHolder extends RecyclerView.ViewHolder {
        private final LayoutItemCbBinding binding;

        public CBViewHolder(@NonNull LayoutItemCbBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.btnMore.setOnClickListener(view -> {
                final Pizza cheesy = pizzaList.get(getAdapterPosition());
                final PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                final MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.menu_delete, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(menuItem -> {
                    if (menuItem.getItemId() == R.id.item_delete) {
                        listener.actionListener(cheesy);
                        return true;
                    }
                    return false;
                });
            });
        }

        public void bind(Pizza pizza) {
            binding.setPizza(pizza);
        }
    }
}
