package com.example.lguprojectc.ui.admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.lguprojectc.R;

public class Admin extends Fragment {

    CardView c1, c2, c3,c4,c5,c6;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.chat, container, false);

        c1 = (CardView) root.findViewById(R.id.card1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View root1 = inflater.inflate(R.layout.nosebleed, container, false);

            }
        });


        return root;
    }
}