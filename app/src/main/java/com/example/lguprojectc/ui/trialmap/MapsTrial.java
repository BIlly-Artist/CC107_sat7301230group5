package com.example.lguprojectc.ui.trialmap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import com.example.lguprojectc.GetNearbyPlacesData;
import com.example.lguprojectc.R;
import com.google.android.gms.location.LocationListener;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapsTrial extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode)
        {
            case REQUEST_LOCATION_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    // permisson granted

                    if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
                    {
                        if(client == null)
                        {
                            buildGoogleApiClient();
                        }
                        mMap.setMyLocationEnabled(true);
                    }

                }
                else {
                    Toast.makeText(this , "Permissioon Denied" ,  Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    private GoogleMap mMap;
    private GoogleApiClient client;
    private LocationRequest locationRequest;
    private Location lastLocation;
    private Marker currentLocationMarker;
    private  EditText tf_location;
    int PROXIMITY_RADIUS = 10000;
    double latitude,longitude;
    private Spinner spinner;
    private Spinner spinner2;
    public static  final int REQUEST_LOCATION_CODE = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        spinner = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        ArrayList<String> BFPlist  = new ArrayList<>();
        BFPlist.add("Fire Station");
        BFPlist.add("BFP Taguig City Fire Station");
        BFPlist.add("BFP Taguig City Fire Station1");
        BFPlist.add("Bagumbayan Fire Sub Station BFP NCR FDIV1");



        spinner.setAdapter(new ArrayAdapter<>(MapsTrial.this
                , android.R.layout.simple_spinner_dropdown_item, BFPlist));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).equals("Fire Station"))
                {}
                else if (parent.getItemAtPosition(position).equals("BFP Taguig City Fire Station"))
                {
                    String snum = parent.getItemAtPosition(position).toString();
                    tf_location.setText(snum);

                }  else if (parent.getItemAtPosition(position).equals("Bagumbayan Fire Sub Station BFP NCR FDIV1"))
                {
                    String snum = parent.getItemAtPosition(position).toString();
                    tf_location.setText(snum);

                }
                else if(parent.getItemAtPosition(position).equals("Ambulace")){

                }
                else {
                    String snum = parent.getItemAtPosition(position).toString();
                    Toast.makeText(parent.getContext(), "Selected:"+ snum , Toast.LENGTH_SHORT).show();
                }

                ArrayList<String> Ambulances = new ArrayList<>();
                Ambulances.add("Ambulace");
                Ambulances.add("Pilipinas911");
                Ambulances.add("Taguig Rescue-municipal");
                Ambulances.add("SOAR Ambulance");
                Ambulances.add("Taguig Pateros District Hospital");
                Ambulances.add("LIFELINE");
                Ambulances.add("Lifeline Ems Academy");
                Ambulances.add("Hi Flying Aviation");


                spinner2.setAdapter(new ArrayAdapter<>(MapsTrial.this,
                        android.R.layout.simple_spinner_dropdown_item, Ambulances));

                spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(parent.getItemAtPosition(position).equals("Ambulace")){

                        }else if (parent.getItemAtPosition(position).equals("Pilipinas911"))
                        {
                            String snum = parent.getItemAtPosition(position).toString();
                            tf_location.setText(snum);

                        }else if (parent.getItemAtPosition(position).equals("Taguig Rescue-municipal"))
                        {
                            String snum = parent.getItemAtPosition(position).toString();
                            tf_location.setText(snum);

                        }else if (parent.getItemAtPosition(position).equals("SOAR Ambulance"))
                        {
                            String snum = parent.getItemAtPosition(position).toString();
                            tf_location.setText(snum);

                        }else if (parent.getItemAtPosition(position).equals("Taguig Pateros District Hospital"))
                        {
                            String snum = parent.getItemAtPosition(position).toString();
                            tf_location.setText(snum);

                        }else if (parent.getItemAtPosition(position).equals("LIFELINE"))
                        {
                            String snum = parent.getItemAtPosition(position).toString();
                            tf_location.setText(snum);

                        }else if (parent.getItemAtPosition(position).equals("Lifeline Ems Academy"))
                        {
                            String snum = parent.getItemAtPosition(position).toString();
                            tf_location.setText(snum);

                        }else if (parent.getItemAtPosition(position).equals("Hi Flying Aviation"))
                        {
                            String snum = parent.getItemAtPosition(position).toString();
                            tf_location.setText(snum);

                        }
                        else {
                            String snum = parent.getItemAtPosition(position).toString();
                            Toast.makeText(parent.getContext(), "Selected:"+ snum , Toast.LENGTH_SHORT).show();
                        }




                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            checkLocationPermission();
        }


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);




    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if(ContextCompat.checkSelfPermission(this , Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {

                buildGoogleApiClient();
                mMap.setMyLocationEnabled(true);
            }

        }
        else {
            buildGoogleApiClient();
            mMap.setMyLocationEnabled(true);
        }
    }

    private  void startLocationUpdates(){

    }
    private void stopLocationUpdates()
    {

    }


    public void onClick(View v) {
        Object dataTransfer[] = new Object[12];
        GetNearbyPlacesData getNearbyPlacesData = new GetNearbyPlacesData();

        tf_location = (EditText) findViewById(R.id.TF_location);
        String location = tf_location.getText().toString();

        String location1 = String.valueOf(spinner.getSelectedItemPosition());


        List<Address> addressList = null;
        MarkerOptions mo = new MarkerOptions();



        if (v.getId() == R.id.B_search) {

            if (!location.equals("")) {
                Geocoder geocoder = new Geocoder(this);
                try {
                    addressList = geocoder.getFromLocationName(location, 5);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < addressList.size(); i++) {
                    Address myAddress = addressList.get(i);
                    LatLng latLng = new LatLng(myAddress.getLatitude(), myAddress.getLongitude());
                    mo.position(latLng);
                    mo.title("your search result");
                    mMap.addMarker(mo);

                    mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
                }
            }
        }

    }

    protected synchronized  void buildGoogleApiClient(){
        client = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        client.connect();

    }
    @Override
    public void onLocationChanged(@NonNull Location location) {

        lastLocation = location;


        if(currentLocationMarker != null){
            currentLocationMarker.remove();
        }

        LatLng latlang = new LatLng(location.getLatitude() , location.getLongitude());

        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latlang);
        markerOptions.title("Currect Location");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

        currentLocationMarker = mMap.addMarker(markerOptions);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlang));
        mMap.animateCamera(CameraUpdateFactory.zoomBy(13));




        if(client != null)
        {
            LocationServices.FusedLocationApi.removeLocationUpdates(client , this);

        }






    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);


        if(ContextCompat.checkSelfPermission(this , Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(client, locationRequest, this);
        }

    }
    public boolean checkLocationPermission(){
        if(ContextCompat.checkSelfPermission(this , Manifest.permission.ACCESS_FINE_LOCATION)  != PackageManager.PERMISSION_GRANTED)
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this , Manifest.permission.ACCESS_FINE_LOCATION))
            {
                ActivityCompat.requestPermissions(this , new String[] {Manifest.permission.ACCESS_FINE_LOCATION} , REQUEST_LOCATION_CODE);

            }
            else {
                ActivityCompat.requestPermissions(this , new String[] {Manifest.permission.ACCESS_FINE_LOCATION} , REQUEST_LOCATION_CODE);

            }
            return false;
        }
        else
            return  true;

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


}



