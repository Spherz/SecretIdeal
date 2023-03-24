package com.example.fooddiary;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NestedAddFoodAdapter extends RecyclerView.Adapter<NestedAddFoodAdapter.NestedAddFoodHolder> {
    private List<String> modelList;

    public NestedAddFoodAdapter(List<String> modelList) {
        this.modelList = modelList;
    }


    @NonNull
    @Override
    public NestedAddFoodAdapter.NestedAddFoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_subitem, parent, false);
        return new NestedAddFoodHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NestedAddFoodAdapter.NestedAddFoodHolder holder, int position) {
        holder.txtPortion.setText(modelList.get(position));
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class NestedAddFoodHolder extends RecyclerView.ViewHolder {
        private TextView txtSelectCalories;
        private TextView txtSelectDietaryFats;
        private TextView txtSelectCarbohydrates;
        private TextView txtSelectProtein;
        private TextView txtPortion;

        public NestedAddFoodHolder(@NonNull View itemView) {
            super(itemView);
            txtSelectCalories = itemView.findViewById(R.id.txtSelectCalories);
            txtSelectDietaryFats = itemView.findViewById(R.id.txtSelectDietaryFats);
            txtSelectCarbohydrates = itemView.findViewById(R.id.txtSelectCarbohydrates);
            txtSelectProtein = itemView.findViewById(R.id.txtSelectProtein);
            txtPortion = itemView.findViewById(R.id.txtGrams);
        }
    }
}
