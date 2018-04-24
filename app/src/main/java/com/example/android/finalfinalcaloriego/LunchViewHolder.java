package com.example.android.finalfinalcaloriego;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Cherry on 4/18/18.
 */

public class LunchViewHolder extends RecyclerView.ViewHolder{
    public CardView cardView;
    public TextView foodName;
    public TextView foodInfo;
    public ImageView foodPhoto;
//    public Context context;

    public LunchViewHolder(View itemView, final Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view2);
        foodName = (TextView) itemView.findViewById(R.id.lunchName);
        foodInfo = (TextView) itemView.findViewById(R.id.lunchCalorie);
        foodPhoto = (ImageView) itemView.findViewById(R.id.lunchPic);
//        this.context = context;

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, foodInfo.getText()+ "Kcal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

