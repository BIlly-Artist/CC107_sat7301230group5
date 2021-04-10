package com.example.lguprojectc;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.ArrayList;

public class Route extends AppCompatActivity {

    EditText etSource;
    Button btTrack;
    String num = "1623";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routeresponse);

        etSource = findViewById(R.id.et_source);
        btTrack = findViewById(R.id.bt_track);


        btTrack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String sSource = etSource.getText().toString().trim();

                if(sSource.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter Current Location", Toast.LENGTH_SHORT).show();
                    requestPermissions();
                }

                else {
                    btTrack.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


                            String uname = getIntent().getStringExtra("Keyname");

                            AlertDialog dialog = new AlertDialog.Builder(Route.this)
                                    .setIcon(R.drawable.ic_baseline_add_alert_24)
                                    .setTitle("Nearby Response are Ready to Rescue")
                                    .setMessage("We will Call you Please wait")

                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent integer = new Intent(getApplicationContext(), Police.class);
                                            startActivity(integer);

                                            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                                                if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
//                                    sendSMS();
                                                }
                                                else {
                                                    requestPermissions(new String[] {Manifest.permission.SEND_SMS}, 1);
                                                }
                                            }
                                            String respo = num;

                                            Intent intent = new Intent(Intent.ACTION_CALL);
                                            intent.setData(Uri.parse("tel:" + respo));


                                            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                                Toast.makeText(Route.this, "PLease Grand Permission", Toast.LENGTH_LONG).show();
                                                requestPermissions();


                                            } else {
                                                startActivity(intent);
                                            }



                                        }
                                    })
                                    .show();
                        }
                    });


                }



            }


        });



    }


    private void requestPermissions() {

        ActivityCompat.requestPermissions(Route.this, new String[] {Manifest.permission.CALL_PHONE}, 1);
    }

}