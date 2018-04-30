package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by yangmuyun on 4/17/18.
 */

public class Tab2 extends Fragment {
    public Tab2() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancestate) {


        View view = inflater.inflate(R.layout.activity_tab2, container, false);
        ImageView health2 = (ImageView) view.findViewById(R.id.health2);
        health2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), HealthActivity2.class);
                startActivity(in);
            }

        });
        return view;
    }
}