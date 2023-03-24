package com.example.fooddiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AddFoodAdapter extends RecyclerView.Adapter<AddFoodAdapter.AddFoodHolder> {
    private Context context;
    private ArrayList<FoodItem> foodItems;

    public AddFoodAdapter(Context context, ArrayList<FoodItem> foodItems) {
        this.context = context;
        this.foodItems = foodItems;
    }

    @NonNull
    @Override
    public AddFoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.food_item, parent, false);
        return new AddFoodHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AddFoodHolder holder, int position) {
        final FoodItem foodItem = foodItems.get(position);

        holder.portion.setText(String.valueOf(foodItems.get(position).getPortion()));
        holder.rda.setText(String.valueOf((int) foodItems.get(position).getRda()));
        holder.calories.setText(String.valueOf((int) foodItems.get(position).getCalories()));
    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    public static class AddFoodHolder extends RecyclerView.ViewHolder {
        TextView portion, rda, calories;

        public AddFoodHolder(@NonNull View itemView) {
            super(itemView);
            portion = itemView.findViewById(R.id.txtFoodPortion);
            rda = itemView.findViewById(R.id.txtFoodRDA);
            calories = itemView.findViewById(R.id.txtFoodCalories);
        }
    }

}
