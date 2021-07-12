package com.example.lguprojectc;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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

public class Firestation extends AppCompatActivity {
    EditText etSource;
    Spinner spinner;
    TextView tf_location;
    Button btTrack;
//    String num = "1623";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routeresponse);

        etSource = findViewById(R.id.et_source);
        btTrack = findViewById(R.id.bt_track);

        spinner = findViewById(R.id.spinner2);


        ArrayList<String> Ambulances = new ArrayList<>();
        Ambulances.add("Select a Contact Number");
        Ambulances.add("837-0740");
        Ambulances.add("837-4496");
        Ambulances.add("642-9982");
        Ambulances.add("837-4496");
        Ambulances.add("0919-0703112");

        spinner.setAdapter(new ArrayAdapter<>(getApplication(),
                android.R.layout.simple_spinner_dropdown_item, Ambulances));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(parent.getItemAtPosition(position).equals("Select a Contact Number")){

                }else if (parent.getItemAtPosition(position).equals("837-0740"))
                {
                    String snum = parent.getItemAtPosition(position).toString();
                    etSource.setText(snum);

                }else if (parent.getItemAtPosition(position).equals("837-4496"))
                {
                    String snum = parent.getItemAtPosition(position).toString();
                    etSource.setText(snum);

                }else if (parent.getItemAtPosition(position).equals("642-9982"))
                {
                    String snum = parent.getItemAtPosition(position).toString();
                    etSource.setText(snum);

                }else if (parent.getItemAtPosition(position).equals("837-4496"))
                {
                    String snum = parent.getItemAtPosition(position).toString();
                    etSource.setText(snum);


                }else if (parent.getItemAtPosition(position).equals("0919-0703112"))
                {
                    String snum = parent.getItemAtPosition(position).toString();
                    etSource.setText(snum);

                }
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btTrack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String sSource = etSource.getText().toString().trim();

                if(sSource.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter a number", Toast.LENGTH_SHORT).show();
                    requestPermissions();
                }

                else {
                    btTrack.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {


//                            String uname = getIntent().getStringExtra("Keyname");

                            AlertDialog dialog = new AlertDialog.Builder(Firestation.this)
                                    .setIcon(R.drawable.ic_baseline_add_alert_24)
                                    .setTitle("Nearby Response are Ready to Rescue")
                                    .setMessage("Click yes if this is an emegency")

                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {


                                            Intent intent = new Intent(Intent.ACTION_CALL);
                                            intent.setData(Uri.parse("tel:" + sSource));


                                            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                                Toast.makeText(Firestation.this, "PLease Grand Permission", Toast.LENGTH_LONG).show();
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

        ActivityCompat.requestPermissions(Firestation.this, new String[] {Manifest.permission.CALL_PHONE}, 1);
    }

}