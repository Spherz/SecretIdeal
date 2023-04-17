package com.example.fooddiary.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddiary.R;
import com.example.fooddiary.model.ButtonItem;
import com.example.fooddiary.model.FoodItem;

import java.util.ArrayList;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.DiaryHolder> {
    Context context;
    private ArrayList<ButtonItem> buttonsList;

    public DiaryAdapter(Context context, ArrayList<ButtonItem> buttonsList) {
        this.context = context;
        this.buttonsList = buttonsList;
    }

    @NonNull
    @Override
    public DiaryAdapter.DiaryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.diary_btn_item, parent, false);
        return new DiaryHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryAdapter.DiaryHolder holder, int position) {
        Intent intent = new Intent();
        ButtonItem buttonItem = buttonsList.get(position);

        holder.title.setText(buttonsList.get(position).getTitle());
        holder.imageLeft.setImageResource(buttonsList.get(position).getImageLeft());
        holder.imageRight.setImageResource(buttonsList.get(position).getImageRight());

        boolean isExpandable = buttonsList.get(position).isExpandable();
        holder.expandableItem.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
    }

    @Override
    public int getItemCount() {
        return buttonsList.size();
    }

    public class DiaryHolder extends RecyclerView.ViewHolder {
        RelativeLayout diaryButton, expandableItem;
        TextView title, foodName;
        ImageView imageLeft, imageRight;

        public DiaryHolder(@NonNull View itemView) {
            super(itemView);

            diaryButton = itemView.findViewById(R.id.diaryButton);
            expandableItem = itemView.findViewById(R.id.expandableList);
            title = itemView.findViewById(R.id.txtTitle);
            foodName = itemView.findViewById(R.id.txtName);
            imageLeft = itemView.findViewById(R.id.food_icon);
            imageRight = itemView.findViewById(R.id.add_icon);

            diaryButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ButtonItem buttonItems = buttonsList.get(getAdapterPosition());
                    buttonItems.setExpandable(!buttonItems.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
