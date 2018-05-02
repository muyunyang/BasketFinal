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

public class LunchAdapter extends RecyclerView.Adapter<LunchViewHolder> {
    private List<Food> lunch;
    private Context context;

    public LunchAdapter(ArrayList<Food> lunch, Context context) {
        this.lunch = lunch;
        this.context = context;
    }

    @Override
    public LunchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_lunch, parent, false);
        return new LunchViewHolder(view, context);
    }


    @Override
    public void onBindViewHolder(LunchViewHolder holder, int position) {
        Food newFood = lunch.get(position);
        holder.foodName.setText(newFood.getName());
        holder.foodInfo.setText(String.valueOf(newFood.getInfo()));
        holder.foodPhoto.setImageResource(newFood.getPhotoId());
    }

    @Override
    public int getItemCount() {
        return lunch.size();
    }

}
