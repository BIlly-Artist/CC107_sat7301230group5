package com.example.lguprojectc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import org.jetbrains.annotations.TestOnly;

public class Contact extends AppCompatActivity {

    ListView listView;
    String num =" Billy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        listView = findViewById(R.id.listcontact);
    }

    public void get(View view){
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null);
        startManagingCursor(cursor);

        String[] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID};

        int[] to = {android.R.id.text1,android.R.id.text2};

        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,cursor,from,to);

     listView.setAdapter(simpleCursorAdapter);
     listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             String respo = num;

             Intent intent = new Intent(Intent.ACTION_CALL);
             intent.setData(Uri.parse("tel:" + respo));


             if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                 Toast.makeText(Contact.this, "PLease Grand Permission", Toast.LENGTH_LONG).show();
                 requestPermissions();
             } else {
                 startActivity(intent);
             }
         }
     });
    }



    private void requestPermissions() {

        ActivityCompat.requestPermissions(Contact.this, new String[] {Manifest.permission.CALL_PHONE}, 1);
    }

}