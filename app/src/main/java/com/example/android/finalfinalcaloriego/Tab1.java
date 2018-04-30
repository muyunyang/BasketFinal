package com.example.android.finalfinalcaloriego;


import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

/**
 * Created by yangmuyun on 4/17/18.
 */


public class Tab1 extends Fragment {

    public Tab1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancestate) {


        View view = inflater.inflate(R.layout.activity_tab1, container, false);
        ImageView recipe1 = (ImageView) view.findViewById(R.id.recipe1);
        recipe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), RecipeActivity1.class);
                startActivity(in);
            }

        });
        return view;
    }
}