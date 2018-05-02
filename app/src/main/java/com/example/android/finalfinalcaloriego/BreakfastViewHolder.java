package com.example.android.finalfinalcaloriego;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by Cherry on 4/18/18.
 */

public class BreakfastViewHolder extends RecyclerView.ViewHolder {
    public CardView cardView;
    public TextView foodName;
    public TextView foodInfo;
    public ImageView foodPhoto;
    public Context context;
    public CheckBox checkBox;


    public BreakfastViewHolder(View itemView, final Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        foodName = (TextView) itemView.findViewById(R.id.bfName);
        foodInfo = (TextView) itemView.findViewById(R.id.bfCalorie);
        foodPhoto = (ImageView) itemView.findViewById(R.id.bfPic);
//        checkBox = (CheckBox) itemView.findViewById(R.id.bfBox);
        this.context = context;

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, foodInfo.getText().toString()+ "Kcal", Toast.LENGTH_SHORT).show();
            }
        });
    }



//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                cardView.setCardBackgroundColor(Color.GRAY);

//                Intent aIntent = new Intent();
//                String calorieData = foodInfo.getText().toString();
//                aIntent.putExtra("calorie", calorieData);
//                context.startActivity(aIntent);
//                Toast.makeText(context, foodInfo.getText()+ "Kcal", Toast.LENGTH_SHORT).show();

//    public boolean isHolderChecked(){
//        if(checkBox.isChecked()){
//            return true;
//        } else {
//            return false;
//        }
//    }


}

