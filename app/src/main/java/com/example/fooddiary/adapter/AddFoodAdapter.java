package com.example.fooddiary.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddiary.model.FoodItem;
import com.example.fooddiary.model.FoodSubItem;
import com.example.fooddiary.R;

import java.util.ArrayList;
import java.util.List;

public class AddFoodAdapter extends RecyclerView.Adapter<AddFoodAdapter.AddFoodHolder> {
    private Context context;
    private ArrayList<FoodItem> foodItems;
    private List<FoodSubItem> foodSubItems = new ArrayList<>();

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

        boolean isExpandable = foodItem.isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

        if(isExpandable) {
            holder.selectFood.setChecked(true);
        } else {
            holder.selectFood.setChecked(false);
        }

        NestedAddFoodAdapter adapter = new NestedAddFoodAdapter(foodSubItems);
        holder.nestedSubFoodList.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
        holder.nestedSubFoodList.setHasFixedSize(true);
        holder.nestedSubFoodList.setAdapter(adapter);
        holder.selectFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foodItem.setExpandable(!foodItem.isExpandable());
                foodSubItems = foodItem.getNestedList();
                notifyItemChanged(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }

    public static class AddFoodHolder extends RecyclerView.ViewHolder {
        private TextView portion, rda, calories;
        private ConstraintLayout constraintLayout;
        private CheckBox selectFood;
        private RelativeLayout expandableLayout;
        private RecyclerView nestedSubFoodList;

        public AddFoodHolder(@NonNull View itemView) {
            super(itemView);
            portion = itemView.findViewById(R.id.txtFoodPortion);
            rda = itemView.findViewById(R.id.txtFoodRDA);
            calories = itemView.findViewById(R.id.txtFoodCalories);

            constraintLayout = itemView.findViewById(R.id.mainInfoLayout);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
            nestedSubFoodList = itemView.findViewById(R.id.childRcList);
            selectFood = itemView.findViewById(R.id.cbSelectFood);
        }
    }

}
