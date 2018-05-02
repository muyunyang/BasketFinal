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

public class Tab3 extends Fragment {
    public Tab3() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancestate) {


        View view = inflater.inflate(R.layout.activity_tab3, container, false);
        ImageView fitness3 = (ImageView) view.findViewById(R.id.fitness3);
        fitness3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), FitnessActivity3.class);
                startActivity(in);
            }

        });
        return view;
    }
}