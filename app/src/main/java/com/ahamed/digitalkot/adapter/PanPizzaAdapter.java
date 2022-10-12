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
import com.ahamed.digitalkot.databinding.LayoutItemPanBinding;
import com.ahamed.digitalkot.entites.Pizza;
import com.ahamed.digitalkot.listener.PizzaListener;

import java.util.List;

public class PanPizzaAdapter extends RecyclerView.Adapter<PanPizzaAdapter.PanPizzaViewHolder> {
    private List<Pizza> pizzaList;
    private PizzaListener listener;

    public PanPizzaAdapter(List<Pizza> pizzaList, Fragment fragment) {
        this.pizzaList = pizzaList;
        this.listener = (PizzaListener) fragment;
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
        final Pizza pizza = pizzaList.get(position);
        holder.bind(pizza);
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    public class PanPizzaViewHolder extends RecyclerView.ViewHolder {
        private final LayoutItemPanBinding binding;

        public PanPizzaViewHolder(@NonNull LayoutItemPanBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.btnMore.setOnClickListener(view -> {
                final Pizza pan = pizzaList.get(getAdapterPosition());
                final PopupMenu popupMenu = new PopupMenu(view.getContext(), view);
                final MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.menu_delete, popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(menuItem -> {
                    if (menuItem.getItemId() == R.id.item_delete) {
                        listener.actionListener(pan);
                        return true;
                    }
                    return false;
                });
            });
        }

        public void bind(Pizza panPizza) {
            binding.setPizza(panPizza);
        }
    }
}
