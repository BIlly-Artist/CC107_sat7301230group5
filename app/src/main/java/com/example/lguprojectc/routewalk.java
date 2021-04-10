package com.example.lguprojectc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class routewalk extends AppCompatActivity {

    EditText etSource , etDestination;
    Button btTrack;
    String respo = "Taguig Pateros District Hospital";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routewalk);

        etSource = findViewById(R.id.et_source);

        btTrack = findViewById(R.id.bt_track);

        btTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sSource = etSource.getText().toString().trim();
                if(sSource.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter Current Location", Toast.LENGTH_SHORT).show();
                }

                else {
                    btTrack.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            DisplaTrack(sSource, respo);
                                            Toast.makeText(routewalk.this, "They have already seen your place "
                                                    , Toast.LENGTH_LONG).show();
                                            Toast.makeText(routewalk.this, "You can follow the route if needed "
                                                    , Toast.LENGTH_LONG).show();

                        }
                    });


                }

            }

            private void DisplaTrack(String sSource, String respo) {
                try{
                    Uri uri = Uri.parse("google.navigation:q="+sSource+"&mode=w");


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