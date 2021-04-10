package com.example.lguprojectc.ui.way;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lguprojectc.R;
import com.example.lguprojectc.Route;
import com.example.lguprojectc.markroute;
import com.example.lguprojectc.routeCar;
import com.example.lguprojectc.routeMotor;
import com.example.lguprojectc.routewalk;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RouteActivity extends Fragment {
    FloatingActionButton fab1 , fab2 , fab3, fab4,fab5;
    Animation fabrot, fabrotback, fabforward, fabbackward, fabop2;

    boolean isopen = true;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View  root = inflater.inflate(R.layout.route2, container, false);

        fab1 = (FloatingActionButton) root.findViewById(R.id.floating1);
        fab2 = (FloatingActionButton) root.findViewById(R.id.floating2);
        fab3 = (FloatingActionButton) root.findViewById(R.id.floating3);
        fab4 = (FloatingActionButton) root.findViewById(R.id.floating4);
        fab5 = (FloatingActionButton) root.findViewById(R.id.floating5);

        //animatiom
        fabrot = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate);
        fabrotback = AnimationUtils.loadAnimation(getActivity(), R.anim.rotate_back);

        fabforward = AnimationUtils.loadAnimation(getActivity(), R.anim.fabopen);
        fabbackward = AnimationUtils.loadAnimation(getActivity(), R.anim.fabclose);
        fabop2 = AnimationUtils.loadAnimation(getActivity(), R.anim.fab2ndopen);


        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        if (isopen){

            fab1.startAnimation(fabrot);
            fab2.startAnimation(fabforward);
            fab3.startAnimation(fabop2);
            fab4.startAnimation(fabforward);
            fab5.startAnimation(fabop2);


            fab2.setVisibility(View.VISIBLE);
            fab3.setVisibility(View.VISIBLE);
            fab4.setVisibility(View.VISIBLE);
            fab5.setVisibility(View.VISIBLE);


            fab2.setClickable(true);
            fab2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), routeMotor.class);
                    startActivity(intent);
                }
            });

            fab3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), routeCar.class);
                    startActivity(intent);
                }
            });

            fab4.setClickable(true);
            fab4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), routewalk.class);
                    startActivity(intent);
                }
            });




            fab5.setClickable(true);
            fab5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), markroute.class);
                    startActivity(intent);
                }
            });




            isopen=false;


        }else {


            fab1.startAnimation(fabrotback);
            fab2.startAnimation(fabbackward);
            fab3.startAnimation(fabbackward);
            fab4.startAnimation(fabbackward);
            fab5.startAnimation(fabbackward);

            fab2.setVisibility(View.INVISIBLE);
            fab3.setVisibility(View.INVISIBLE);
            fab4.setVisibility(View.INVISIBLE);
            fab5.setVisibility(View.INVISIBLE);

            fab2.setClickable(false);
            fab3.setClickable(false);
            fab4.setClickable(false);
            fab5.setClickable(false);

            isopen=true;

        }



            }
        });


        return root;
    }}