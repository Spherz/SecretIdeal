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
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddiary.R;
import com.example.fooddiary.interfaces.FoodListener;
import com.example.fooddiary.model.FoodItem;

import java.util.ArrayList;

public class AddFoodAdapter extends RecyclerView.Adapter<AddFoodAdapter.AddFoodHolder> {
    private Context context;
    private ArrayList<FoodItem> foodList;

    private FoodListener foodListener;

    private ArrayList<FoodItem> selectedFoodList = new ArrayList<>();

    public AddFoodAdapter(Context context, ArrayList<FoodItem> foodItems, FoodListener foodListener) {
        this.context = context;
        this.foodList = foodItems;
        this.foodListener = foodListener;
    }

    @NonNull
    @Override
    public AddFoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.food_item, parent, false);
        return new AddFoodHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AddFoodHolder holder, int position) {
        final FoodItem foodItem = foodList.get(position);

        holder.foodName.setText(String.valueOf(foodList.get(position).getFoodName()));
        holder.portion.setText(String.valueOf(foodList.get(position).getPortion()));
        holder.rda.setText(String.valueOf(foodList.get(position).getRda()));
        holder.calories.setText(String.valueOf((foodList.get(position).getCalories())));
        holder.foodFats.setText(String.valueOf((foodList.get(position).getFoodFats())));
        holder.foodCarbohydrates.setText(String.valueOf((foodList.get(position).getCarbohydrates())));
        holder.foodProtein.setText(String.valueOf((foodList.get(position).getProtein())));

        boolean isExpandable = foodList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

        if(isExpandable) {
            holder.selectFood.setChecked(true);
        } else {
            holder.selectFood.setChecked(false);
        }

        holder.selectFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foodList != null && foodList.size() > 0) {
                    if(holder.selectFood.isChecked()) {
                        selectedFoodList.add(foodList.get(position));
                    } else {
                        selectedFoodList.remove(foodList.get(position));
                    }
                    foodListener.onFoodChange(selectedFoodList);
                }
            }
        });

//        System.out.println(isExpandable);
//        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
//
//        if(isExpandable) {
//            holder.selectFood.setChecked(true);
//        } else {
//            holder.selectFood.setChecked(false);
//        }
//
//        holder.selectFood.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                foodItem.setExpandable(!foodItem.isExpandable());
//                System.out.println("Clicked");
//                foodSubItems = foodItem.getNestedItem();
//                notifyItemChanged(holder.getAdapterPosition());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public void filterList(ArrayList<FoodItem> filteredList) {
        foodList = filteredList;
        notifyDataSetChanged();
    }

    public class AddFoodHolder extends RecyclerView.ViewHolder {
        private TextView foodName, portion, rda, calories, foodFats, foodCarbohydrates, foodProtein;
        private ConstraintLayout constraintLayout;
        private CheckBox selectFood;
        private RelativeLayout expandableLayout;

        public AddFoodHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.txtFoodName);
            portion = itemView.findViewById(R.id.txtFoodPortion);
            rda = itemView.findViewById(R.id.txtFoodRDA);
            calories = itemView.findViewById(R.id.txtFoodCalories);
            foodFats = itemView.findViewById(R.id.txtSelectDietaryFats);
            foodCarbohydrates = itemView.findViewById(R.id.txtSelectCarbohydrates);
            foodProtein = itemView.findViewById(R.id.txtSelectProtein);
            constraintLayout = itemView.findViewById(R.id.mainInfoLayout);
            expandableLayout = itemView.findViewById(R.id.expandable_layout);
            selectFood = itemView.findViewById(R.id.cbSelectFood);

            selectFood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FoodItem foodItems = foodList.get(getAdapterPosition());
                    foodItems.setExpandable(!foodItems.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }

}
