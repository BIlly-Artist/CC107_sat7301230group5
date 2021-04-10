package com.example.lguprojectc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class markroute extends AppCompatActivity {

    EditText etSource , etDestination;
    Button btTrack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_markroute);

        etSource = findViewById(R.id.et_source);
        etDestination = findViewById(R.id.et_destination);
        etSource = findViewById(R.id.et_source);



        btTrack = findViewById(R.id.bt_track);

        btTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sSource = etSource.getText().toString().trim();
                String sDestination = etDestination.getText().toString().trim();


                if(sSource.equals("") && sDestination.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter Both Location", Toast.LENGTH_SHORT).show();

                }else{

                    DisplaTrack(sSource, sDestination);

                }



            }

            private void DisplaTrack(String sSource, String sDestination) {

                try{


                    Uri uri = Uri.parse("https://www.google.co.in/maps/dir/" + sSource + "/"
                            + sDestination);


                    //initialize intent
                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);

                    //set package
                    intent.setPackage("com.google.android.apps.maps");

                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);


                }catch (ActivityNotFoundException e){
                    Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.maps");
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);

                }

            }
        });


    }
}