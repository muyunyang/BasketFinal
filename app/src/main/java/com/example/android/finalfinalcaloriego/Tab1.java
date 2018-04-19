package com.example.android.finalfinalcaloriego;

import android.app.Activity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by yangmuyun on 4/17/18.
 */

//public class Tab1 extends Fragment
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//        View rootView= inflater.inflate(R.layout.tab1,container,false);
//        return  rootView;
//    }
public class Tab1 extends Fragment {

    public Tab1() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstancestate) {
Toast.makeText(getActivity()," Hello",Toast.LENGTH_LONG).show();



View view= inflater.inflate(R.layout.tab1,container,false);
   ImageView recipe1=(ImageView)view.findViewById(R.id.recipe1);
           recipe1.setOnClickListener(new View.OnClickListener(){
@Override
               public void onClick(View v){
    Intent in =new Intent(getActivity(),RecipeActivity1.class);
    in.putExtra("some","some gaaga");
    startActivity(in);
}

           });
   return view;
    }
}


