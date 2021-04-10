package com.example.lguprojectc.ui.location;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.lguprojectc.Contact;
import com.example.lguprojectc.Police;
import com.example.lguprojectc.R;
import com.example.lguprojectc.Route;

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
                AlertDialog dialog = new AlertDialog.Builder(getActivity())
                        .setTitle("Emergency")
                        .setMessage("Waiting For admin Apporval")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent integer = new Intent(getActivity(), Route.class);
                                startActivity(integer);

                            }
                        })
                        .show();
            }
       });




        c2 = (CardView) root.findViewById(R.id.card2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getActivity())
                        .setTitle("Emergency")
                        .setMessage("Waiting For admin Apporval")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent integer = new Intent(getActivity(), Route.class);
                                startActivity(integer);

                            }
                        })
                        .show();
            }
        });




        c3 = (CardView) root.findViewById(R.id.card3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = new AlertDialog.Builder(getActivity())
                        .setTitle("Emergency")
                        .setMessage("Waiting For admin Apporval")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent integer = new Intent(getActivity(), Police.class);
                                startActivity(integer);

                            }
                        })
                        .show();
            }
        });

        return root;
    }
}