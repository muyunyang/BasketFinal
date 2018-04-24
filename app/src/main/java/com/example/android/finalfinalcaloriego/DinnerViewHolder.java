package com.example.android.finalfinalcaloriego;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Cherry on 4/19/18.
 */

public class DinnerViewHolder extends RecyclerView.ViewHolder{
    public CardView cardView;
    public TextView foodName;
    public TextView foodInfo;
    public ImageView foodPhoto;


    public DinnerViewHolder(View itemView, final Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view2);
        foodName = (TextView) itemView.findViewById(R.id.dinnerName);
        foodInfo = (TextView) itemView.findViewById(R.id.dinnerCalorie);
        foodPhoto = (ImageView) itemView.findViewById(R.id.dinnerPic);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, foodInfo.getText()+ "Kcal", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
