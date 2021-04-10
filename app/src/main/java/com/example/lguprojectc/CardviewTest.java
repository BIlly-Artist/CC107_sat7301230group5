package com.example.lguprojectc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CardviewTest extends AppCompatActivity{
     CardView c1, c2, c3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);

        c2 = findViewById(R.id.card2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog dialog = new AlertDialog.Builder(CardviewTest.this)
                        .setTitle("Emergency")
                        .setMessage("Waiting For admin Apporval")
                        .show();


                Intent integer = new Intent(CardviewTest.this, Route.class);
                startActivity(integer);
                finish();
            }
        });






        c1 = findViewById(R.id.card1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog dialog = new AlertDialog.Builder(CardviewTest.this)
                        .setTitle("Emergency")
                        .setMessage("Waiting For admin Apporval")
                        .show();


                Intent integer = new Intent(CardviewTest.this,Route.class);
                startActivity(integer);
                finish();
            }
        });



        c3 = findViewById(R.id.card3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog dialog = new AlertDialog.Builder(CardviewTest.this)
                        .setTitle("Emergency")
                        .setMessage("Waiting For admin Apporval")
                        .show();


                Intent integer = new Intent(CardviewTest.this,Route.class);
                startActivity(integer);
                finish();
            }
        });


    }

}