package com.example.fooddiary.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddiary.model.FoodSubItem;
import com.example.fooddiary.R;

import java.util.List;

public class NestedAddFoodAdapter extends RecyclerView.Adapter<NestedAddFoodAdapter.NestedAddFoodHolder> {
    private List<FoodSubItem> foodSubItems;

    public NestedAddFoodAdapter(List<FoodSubItem> modelList) {
        this.foodSubItems = modelList;
    }

    @NonNull
    @Override
    public NestedAddFoodAdapter.NestedAddFoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_subitem, parent, false);
        return new NestedAddFoodHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NestedAddFoodAdapter.NestedAddFoodHolder holder, int position) {
        final FoodSubItem foodSubItem = foodSubItems.get(position);

        holder.txtPortion.setText(String.valueOf(foodSubItems.get(position).getPortion()));
        holder.txtSelectCalories.setText(String.valueOf(foodSubItems.get(position).getCalories()));
        holder.txtSelectDietaryFats.setText(String.valueOf(foodSubItems.get(position).getDietaryFats()));
        holder.txtSelectCarbohydrates.setText(String.valueOf(foodSubItems.get(position).getCarbohydrates()));
        holder.txtSelectProtein.setText(String.valueOf(foodSubItems.get(position).getProtein()));
    }

    @Override
    public int getItemCount() {
        return foodSubItems.size();
    }

    public class NestedAddFoodHolder extends RecyclerView.ViewHolder {
        private TextView txtSelectCalories;
        private TextView txtSelectDietaryFats;
        private TextView txtSelectCarbohydrates;
        private TextView txtSelectProtein;
        private TextView txtPortion;
        private NumberPicker portionPicker, partPortionPicker;

        public NestedAddFoodHolder(@NonNull View itemView) {
            super(itemView);
            txtSelectCalories = itemView.findViewById(R.id.txtSelectCalories);
            txtSelectDietaryFats = itemView.findViewById(R.id.txtSelectDietaryFats);
            txtSelectCarbohydrates = itemView.findViewById(R.id.txtSelectCarbohydrates);
            txtSelectProtein = itemView.findViewById(R.id.txtSelectProtein);
            txtPortion = itemView.findViewById(R.id.txtGrams);

            portionPicker = itemView.findViewById(R.id.portionPicker);
            partPortionPicker = itemView.findViewById(R.id.partPortionPicker);

            portionPicker.setMaxValue(10000);
            portionPicker.setMinValue(0);
            portionPicker.setValue(100);

            partPortionPicker.setMaxValue(3);
            partPortionPicker.setMinValue(0);
            partPortionPicker.setValue(1);
        }
    }
}
