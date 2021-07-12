package com.example.lguprojectc.ui.location;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.lguprojectc.Contact;
import com.example.lguprojectc.MedicResponse;
import com.example.lguprojectc.Police;
import com.example.lguprojectc.R;
import com.example.lguprojectc.Firestation;

public class CardviewActivity extends Fragment {
    CardView c1, c2, c3, c4;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_cardview, container, false);


   c4 = root.findViewById(R.id.contact);
   c4.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent = new Intent(getActivity(), Contact.class);
           startActivity(intent);
           getActivity().finish();

       }
   });









        c1 = (CardView) root.findViewById(R.id.card1);
       c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                                Intent integer = new Intent(getActivity(), MedicResponse.class);
                                startActivity(integer);

                            }
                        });




        c2 = (CardView) root.findViewById(R.id.card2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                                Intent integer = new Intent(getActivity(), Firestation.class);
                                startActivity(integer);

                            }
                        });




        c3 = (CardView) root.findViewById(R.id.card3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                                Intent integer = new Intent(getActivity(), Police.class);
                                startActivity(integer);

                            }
                        });


        return root;
    }
}