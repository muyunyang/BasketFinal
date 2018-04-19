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
    private List<Breakfast> breakfast;
    private Context context;

    public BreakfastAdapter(ArrayList<Breakfast> breakfast, Context context) {
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
        Breakfast newBreakfast = breakfast.get(position);
        holder.foodName.setText(newBreakfast.getName());
        holder.foodInfo.setText(newBreakfast.getInfo());
        holder.foodPhoto.setImageResource(newBreakfast.getPhotoId());
    }

    @Override
    public int getItemCount() {
        return breakfast.size();
    }

}
