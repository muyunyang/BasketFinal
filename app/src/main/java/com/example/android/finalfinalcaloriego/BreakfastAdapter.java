package com.example.android.finalfinalcaloriego;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherry on 4/18/18.
 */

public class BreakfastAdapter extends RecyclerView.Adapter<BreakfastViewHolder> {
    private List<Food> breakfast;
    private Context context;

    public BreakfastAdapter(ArrayList<Food> breakfast, Context context) {
        this.breakfast = breakfast;
        this.context = context;
    }

    @Override
    public BreakfastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_breakfast, parent, false);
        return new BreakfastViewHolder(view, context);
    }


    @Override
    public void onBindViewHolder(BreakfastViewHolder holder, int position) {
        Food newFood = breakfast.get(position);
        holder.foodName.setText(newFood.getName());
        holder.foodInfo.setText(String.valueOf(newFood.getInfo()));
        holder.foodPhoto.setImageResource(newFood.getPhotoId());
//        holder.checkBox.setChecked(newFood.checked);
//        newFood.checked = holder.isHolderChecked();
    }



    @Override
    public int getItemCount() {
        return breakfast.size();
    }

}
