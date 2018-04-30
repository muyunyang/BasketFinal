package com.example.android.finalfinalcaloriego;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cherry on 4/19/18.
 */

public class DinnerAdapter extends RecyclerView.Adapter<DinnerViewHolder> {
    private List<Food> dinner;
    private Context context;

    public DinnerAdapter(ArrayList<Food> dinner, Context context) {
        this.dinner = dinner;
        this.context = context;
    }

    @Override
    public DinnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_dinner, parent, false);
        return new DinnerViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(DinnerViewHolder holder, int position) {
        Food newFood = dinner.get(position);
        holder.foodName.setText(newFood.getName());
        holder.foodInfo.setText(newFood.getInfo());
        holder.foodPhoto.setImageResource(newFood.getPhotoId());
    }

    @Override
    public int getItemCount() {
        return dinner.size();
    }

}
